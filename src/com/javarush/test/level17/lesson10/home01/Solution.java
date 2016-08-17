//package com.javarush.test.level17.lesson10.home01;
//
//import java.util.*;
//
///* Общий список
//1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
//2. Список Solution должен работать только с целыми числами Long.
//3. Воспользуйтесь полем original.
//4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
//*/
//
//public class Solution implements List {
//    private ArrayList<Long> original = new ArrayList<Long>();
//
//    @Override
//    public int lastIndexOf(Object o) {
//        return original.lastIndexOf(o);
//    }
//
//    @Override
//    public int size() {
//        return original.size();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return original.isEmpty();
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return original.contains(o);
//    }
//
//    @Override
//    public Iterator iterator() {
//        return original.iterator();
//    }
//
//    @Override
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    @Override
//    public T[] toArray(Object[] a) {
//        return original.toArray(a);
//    }
//
//    @Override
//    public boolean add(Object o) {
//        return original.add((Long)o);
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        return original.remove(o);
//    }
//
//    @Override
//    public boolean containsAll(Collection c) {
//        return original.containsAll(c);
//    }
//
//    @Override
//    public boolean addAll(Collection c) {
//        return original.addAll(c);
//    }
//
//    @Override
//    public boolean addAll(int index, Collection c) {
//        return original.addAll(index, c);
//    }
//
//    @Override
//    public boolean removeAll(Collection c) {
//        return original.removeAll(c);
//    }
//
//    @Override
//    public boolean retainAll(Collection c) {
//        return original.retainAll(c);
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public Object get(int index) {
//        return original.get(index);
//    }
//
//    @Override
//    public Object set(int index, Object element) {
//        return original.set(index, (Long)element);
//    }
//
//    @Override
//    public void add(int index, Object element) {
//        original.add(index, (Long) element);
//
//    }
//
//    @Override
//    public Long remove(int index) {
//        return original.remove(index);
//    }
//
//    @Override
//    public int indexOf(Object o) {
//        return original.indexOf(o);
//    }
//
//    @Override
//    public ListIterator listIterator() {
//        return original.listIterator();
//    }
//
//    @Override
//    public ListIterator listIterator(int index) {
//        return original.listIterator(index);
//    }
//
//    @Override
//    public List subList(int fromIndex, int toIndex) {
//        return original.subList(fromIndex, toIndex);
//    }
//}
