package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    private static final long serialVersionUID = 1L;
    int size = 0;

    Node<String> root = new Node<>(null, null);
    Node<String> parent = root;

//    public static void main(String[] args)
//    {
//        List<String> list = new Solution();
//        for (int i = 1; i < 16; i++)
//        {
//            list.add(String.valueOf(i));
//
//        }
//
//        list.remove("2");
//        list.remove("9");
//
//        for(int i = 16; i < 21; i++){
//            list.add(String.valueOf(i));
//        }
//        System.out.println("Expected 16, actual is " + ((Solution) list).getParent("16"));
//        System.out.println("Expected 17, actual is " + ((Solution) list).getParent("17"));
//        System.out.println("Expected 18, actual is " + ((Solution) list).getParent("18"));
//        System.out.println("Expected 19, actual is " + ((Solution) list).getParent("19"));
//        System.out.println("Expected 20, actual is " + ((Solution) list).getParent("20"));
//
//        list.remove("18");
//        list.remove("20");
//
//
//        list.add("21");
//        list.add("22");
//
//
//
//        System.out.println("Expected 21, actual is " + ((Solution) list).getParent("21"));
//        System.out.println("Expected 22, actual is " + ((Solution) list).getParent("22"));
//
//    }



    public static void main (String[]args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        List<String> listTree = new Solution();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }

        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        List<String> list2222 = new Solution();
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        list2222.add("test");
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        List<String> list1111 = new Solution();
        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());

        listTree.clear();
        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }

        //For additional check correct work clone method
        Solution list = ((Solution)listTree).clone();

        System.out.println("Start value with using clone: ");
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        list.display();
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        list.display();
        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        list.display();
        System.out.println("\n===== ADD 21 and 22 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        list.display();
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + list.size() + " expected = 22");
        System.out.println();

        System.out.println("=============== Clone test ==================");

        System.out.println("Object:");
        list.display();
        System.out.println("Size = " + list.size());
        Solution sol = list.clone();
        System.out.println("Clone object:");
        sol.display();
        System.out.println("Size = " + sol.size());

//        System.out.println("\nTest addAll: "); //todo
//        Solution add = new Solution();
//        add.addAll(sol);
//        add.display();
//        System.out.println("Size: " + add.size() + " = " + sol.size());
//
        System.out.println("=============== Iterator test ===============");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String a = itr.next();
            System.out.print(a + " ");
        }
        System.out.println("\nExpected size 22 = " + list.size());

        System.out.println("\nIter remove");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext()) {
            if (itr2.next().contains("31")) {
                itr2.remove();
            }
        }
        System.out.println("For test " + list + " --> Size = " + list.size());
        System.out.println("Collect size " + list.size() + " Expected 21");

        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
        System.out.println("Collect before serializable " + list.size());
        System.out.print("Save list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" Serializable done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" Deserializable done");
        System.out.println("Collect after deserializable " + list2.size());
//
        System.out.println("\n================ Clear test =================");
        System.out.println("Before: " + listTree.size());
        listTree.clear();
        System.out.println("After clear: " + listTree.size());
    }





    public Queue<Node<String>> getSubTree(Node<String> top)
    {
        Queue<Node<String>> queue = new LinkedList<>();
        Queue<Node<String>> subTree = new LinkedList<>();
        if (top != root)
            subTree.add(top);
            do
            {
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
                if(queue.isEmpty()) break;
                if (!queue.isEmpty()) top = queue.poll();
                subTree.add(top);

            }
            while (true);


        return subTree;
    }

    @Override
    public boolean remove(Object value)
    {
        Queue<Node<String>> queueForRemove = getSubTree(findNode((String) value));

        Node<String> current = findNode((String) value);
        if (current.parent.left.equals(current))
        {
            current.parent.left = null;
        } else
        {
            current.parent.right = null;
        }
        for (Node<String> node : queueForRemove)
        {
            node = null;
            size--;
        }
        return true;
    }

    public String getParent(String value)
    {
        //have to be implemented
        Node<String> searchingNode = findNode(value);
        if (searchingNode == null)
            return null;
        return (searchingNode.parent == null) ? null : searchingNode.parent.value;
    }

    // Поиск нода по значению
    Node<String> findNode(String value)
    {
        Queue<Node<String>> wholeTree = getSubTree(root);
        for (Node<String> node : wholeTree)
        {
            if (node.value == null)
                return null;
            if (node.value.equals(value))
                return node;
        }
        return null;
    }

    @Override
    public boolean add(String value)
    {
        Node<String> newNode = new Node<>(value, parent);
        newNode.level = parent.level + 1;

        // если левый слот родительского нода пуст
        if (parent.left == null)
        {
            newNode.parent = parent;
            parent.left = newNode;
            size++;
        }
        // если правый слот родительского нода пуст
        else if (parent.right == null)
        {
            newNode.parent = parent;
            parent.right = newNode;
            size++;
        }
        // если оба слота родительского нода заняты
        else
        {
            // ищем следующий свободный слот
            Queue<Node<String>> wholeTree = getSubTree(root);
            if(parent != root)
            {
                LinkedList<Node<String>> linkedList = new LinkedList<>();
                boolean check2 = false;
                for (Node<String> node : wholeTree)
                {
                    if (node.equals(parent))
                    {
                        check2 = true;
                    }
                    if (check2)
                    {
                        linkedList.add(node);
                    }
                }

                wholeTree.clear();
                for(Node<String> node : linkedList){
                    wholeTree.add(node);
                }
            }

            int needLevel;
            if (parent == root)
            {
                needLevel = 1;
            } else
            {
                needLevel = parent.level;
                if (needLevel == 0)
                {
                    needLevel = 1;
                }
            }
            boolean check = true;
            while (check)
            {
                for (Node<String> node : wholeTree)
                {

                    if ((node.left == null || node.right == null) && node.level == needLevel)
                    {
                        parent = node;
                        check = false;
                        break;

                    }
                }
                    needLevel += 1;
            }
            add(value);
        }

        return true;
    }

    public void display(){
        Queue<Node<String>> queue = getSubTree(root);
        for(Node<String> node : queue){
            System.out.print(node.value + " ");
        }
        System.out.println();
    }

    private static class Node<String> implements Serializable
    {
        String value;
        Node<String> parent;
        Node<String> left;
        Node<String> right;
        public int level = 0;

        private Node(String value, Node<String> parent)
        {
            this.value = value;
            this.parent = parent;
        }

    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear()
    {
        root.left = null;
        root.right = null;
        size = 0;
        parent = root;
        Queue<Node<String>> clearQueue = getSubTree(root);
        for(Node<String> node : clearQueue){
            node.left = null;
            node.right = null;
            node = null;
        }

    }

    @Override
    protected Solution clone() throws CloneNotSupportedException
    {
        return (Solution)super.clone();
    }

}