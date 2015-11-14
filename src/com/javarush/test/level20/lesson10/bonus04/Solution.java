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
public class Solution
    extends AbstractList<String>
    implements List<String>, Cloneable, Serializable
{
    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException {
        List<java.lang.String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(java.lang.String.valueOf(i));
        }
//        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("2");
        list.remove("9");
        for (int i = 16; i < 21; i++) {
            list.add(java.lang.String.valueOf(i));
        }
//        list.remove("18");
//        list.remove("20");
//        for (int i = 21; i < 23; i++) {
//            list.add(java.lang.String.valueOf(i));
//        }
//        System.out.println("before Serializing");
//        for (String x : list){
//            System.out.println("Parent of " + x + ": " + ((Solution) list).getParent(x));
//        }

        FileOutputStream fileOutputStream = new FileOutputStream("e:\\Books\\numbers.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("e:\\Books\\numbers.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<String> list2 = (Solution)objectInputStream.readObject();
        objectInputStream.close();

        list.remove("18");
        list.remove("20");
        for (int i = 21; i < 23; i++) {
            list.add(java.lang.String.valueOf(i));
        }
        for (String x : list){
            System.out.println("Parent of " + x + ": " + ((Solution) list).getParent(x));
        }


        System.out.println("after Serializing");

        list2.remove("18");
        list2.remove("20");
        for (int i = 21; i < 23; i++) {
            list2.add(java.lang.String.valueOf(i));
        }
        for (String x : list2){
            System.out.println("Parent of " + x + ": " + ((Solution) list).getParent(x));
        }

//        ListIterator<java.lang.String> iterator = list.listIterator();
//        while (iterator.hasNext()){
//            java.lang.String x = iterator.next();
//            System.out.println("Parent of " + x + ": " + ((Solution) list).getParent(x));
//        }




    }

    transient int size = 0;

    transient Node<String> first;

    transient Node<String> last;

    //new variable, it's needed for adding new elements
    transient Node<String> lastTA;

    public java.lang.String getParent(java.lang.String value) {
        java.lang.String result = null;
        for (Node<String> temp = first; temp != null; temp = temp.next) {
            if (temp.item.equals(value)) {
                if (temp.parent == null)
                    return "null";
                else
                    return java.lang.String.valueOf(temp.parent.item);
            }
        }
        return result;
    }

    void linkLast(String e) {
        final Node<String> l = last;
        final Node<String> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
            lastTA = newNode;
        }
        else if (l == first)
            l.next = newNode;
        else {
            l.next = newNode;
            if (lastTA.child2 != null)
                lastTA = lastTA.next;

            newNode.parent = lastTA;

            if (lastTA.child1 == null)
                lastTA.child1 = newNode;
            else
                lastTA.child2 = newNode;
        }

        size++;
        modCount++;
    }

    void linkBefore(String e, Node<String> succ) {
        // assert succ != null;
        final Node<String> pred = succ.prev;
        final Node<String> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    String unlink(Node<String> x) {
        // assert x != null;
        final String element = x.item;
        final Node<String> next = x.next;
        final Node<String> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        if (x.parent != null){
            if (x.parent.child1 == x)
                x.parent.child1 = null;
            else
                x.parent.child2 = null;
        }
        x.item = null;
        size--;
        modCount++;
        return element;
    }

    public boolean add(String e) {
        linkLast(e);
        return true;
    }



    public boolean remove(Object o) {
        if (o == null) {
            for (Node<String> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<String> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    if (x == lastTA)
                        lastTA = x.next;
                    if (x.child1 != null)
                        remove(x.child1.item);
                    if (x.child2 != null)
                        remove(x.child2.item);
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    Node<String> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<String> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<String> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {
        private Node<String> lastReturned = null;
        private Node<String> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        Itr() {
            // assert isPositionIndex(index);
            next = first;
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public String next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public String previous() {
            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<String> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        public void set(String e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.item = e;
        }

        public void add(String e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
            expectedModCount++;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private static class Node<E> {
        E item;
        Node<E> parent;
        Node<E> prev;
        Node<E> child1;
        Node<E> child2;
        Node<E> next;


        private Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
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

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // Write out size
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (Node<String> x = first; x != null; x = x.next)
            s.writeObject(x.item);

    }


    @SuppressWarnings("unchecked")
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();

        // Read in size
        int size = s.readInt();

        // Read in all elements in the proper order.
        for (int i = 0; i < size; i++)
            linkLast((String)s.readObject());

    }
}
