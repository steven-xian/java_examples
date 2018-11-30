package com.java.basic;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Deque<String> arrayDeque = new LinkedList<>();
        arrayDeque.push("aaaa");
        arrayDeque.push("bbbbbb");
        arrayDeque.push("cccccc");
        System.out.println(arrayDeque);

        Iterator<String> iter =  arrayDeque.iterator();
        while(iter.hasNext()) {
            String item = iter.next();
            System.out.println(item);
        }

        Iterator<String> iter2 = arrayDeque.iterator();
        iter2.forEachRemaining(item -> System.out.println("item in forEachRemaining:" + item.toString()));

        arrayDeque.forEach(item -> System.out.println("item in ForEach :" + item));
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque.pop());


        Deque<Integer> integerLinkedList = new LinkedList<Integer>();
        integerLinkedList.push(100);
        integerLinkedList.push(1000);
        integerLinkedList.push(10000);
        System.out.println(integerLinkedList);

        for (Integer item : integerLinkedList) {
            System.out.println("item:" + item.toString());
        }

        integerLinkedList.forEach(item -> System.out.println("item in forEach:" + item.toString()));
        integerLinkedList.pop();
        System.out.println(integerLinkedList);

        System.out.println("Linked List Test");
        LinkedListTest();
    }

    public static void LinkedListTest() {
        List<String> a = new LinkedList<>();
        a.add("AAA");
        a.add("CCC");
        a.add("EEEE");

        List<String> b = new LinkedList<>();
        b.add("BBB");
        b.add("DDD");
        b.add("FFF");
        b.add("GGG");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}
