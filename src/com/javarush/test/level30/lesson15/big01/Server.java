package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by testim on 22.03.16.
 */
public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> pair : connectionMap.entrySet()){
            Connection connection = pair.getValue();
            try {
                connection.send(message);
            }catch (IOException e){
                ConsoleHelper.writeMessage("Can't send a message");
            }
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Server run!");
            while (true){
                try {
                    Socket socket = serverSocket.accept();
                    if (socket != null) {
                        Handler handler = new Handler(socket);
                        handler.start();
                    }
                }catch (Exception e){
                    serverSocket.close();
                    throw e;
                }
            }

        }catch (Exception e){
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true) {//8.7
                                connection.send(new Message(MessageType.NAME_REQUEST)); //8.1
                Message userName = connection.receive();//8.2
                if (userName.getType() == MessageType.USER_NAME) {//8.3
                    if (userName.getData() != null && !userName.getData().isEmpty()) {
                        String name = userName.getData();//8.4
                        if (!connectionMap.containsKey(name)) {
                            connectionMap.put(name, connection);//8.5
                            connection.send(new Message(MessageType.NAME_ACCEPTED));//8.6
                            return name;
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String, Connection> pair : connectionMap.entrySet()){
                String name = pair.getKey();
                if(!name.equals(userName)) {
                    Message addUser = new Message(MessageType.USER_ADDED, name);
                    connection.send(addUser);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message newTextMessage = connection.receive();
                if(newTextMessage.getType() == MessageType.TEXT){
                    if(newTextMessage.getData() != null && !newTextMessage.getData().isEmpty()) {
                        String text = userName + ": " + newTextMessage.getData();
                        sendBroadcastMessage(new Message(MessageType.TEXT, text));
                    }
                }else{
                    ConsoleHelper.writeMessage("This is wrong message type. Need TEXT");
                }
            }
        }

        public void run() {
            SocketAddress socketAddress = socket.getLocalSocketAddress();
            String error = "Error occurred when connection with " + socketAddress;
            ConsoleHelper.writeMessage("Connection with " + socketAddress);
            String userName = null;
            try(Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);

                serverMainLoop(connection, userName);

            }catch (IOException e){
                ConsoleHelper.writeMessage(error);
            }catch (ClassNotFoundException e){
                ConsoleHelper.writeMessage(error);
            }
            if(userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Connection with " + socketAddress + " is close");

        }
    }
}
