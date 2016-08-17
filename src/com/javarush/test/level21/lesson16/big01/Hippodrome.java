package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by DNS on 16.12.2015.
 */
public class Hippodrome
{
    public static Hippodrome game;
    public ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return this.horses;
    }

    public void run() throws InterruptedException{

        for(int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){

        for(Horse h : horses){
            h.move();
        }
    }

    public void print(){
        for(Horse h : horses){
            h.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse winner = new Horse("win", 0, 0);
        for(Horse h : getHorses()){
            if(h.getDistance() > winner.getDistance()){
                winner = h;
            }
        }
        return winner;
    }

    public void printWinner(){
            System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main(String[] args) throws Exception
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Matilda", 3, 0);
        Horse horse2 = new Horse("Brungilda", 3,0);
        Horse horse3 = new Horse("Fazenda", 3,0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }
}