package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("James Smith", 25);
        Employee e2 = new Employee("Benjamin Brennan", 20);
        Employee e3 = new Employee("Robert Frye", 27);

        //ArrayList() - constructor
        ArrayList arrayList = new ArrayList<Employee>();

        //boolean add(E e)
        arrayList.add(e1);
        arrayList.add(e2);
        arrayList.add(e3);
        System.out.println("ArrayList after add method");
        printList(arrayList);
        System.out.println("==========================");

        //void add(int index, E element)
        arrayList.add(2, new Employee("Caleb Fry", 31));
        System.out.println("ArrayList after add by index 2");
        printList(arrayList);
        System.out.println("==========================");

        //void clear()
        arrayList.clear();
        System.out.println("ArrayList after clear method");
        System.out.println("Size: " + arrayList.size());
        System.out.println("==========================");

        //boolean addAll(Collection<? extends E> c)
        LinkedList temp = new LinkedList<Employee>();
        temp.add(e1);
        temp.add(e2);
        temp.add(e3);
        arrayList.addAll(temp);
        System.out.println("ArrayList after addAll method");
        printList(arrayList);
        System.out.println("==========================");

        //Object clone()
        ArrayList clone = (ArrayList) arrayList.clone();
        System.out.println("Print clone list");
        printList(arrayList);
        System.out.println("==========================");

        //boolean contains(Object o)
        System.out.println("ArrayList contains e2: " + arrayList.contains(e2));
        System.out.println("==========================");

        //E get(int index)
        System.out.println("Get element by index 1: " + arrayList.get(1));
        System.out.println("==========================");

        //int indexOf(Object o)
        System.out.println("Index of element e1: " + arrayList.indexOf(e1));
        System.out.println("==========================");

        //boolean isEmpty()
        System.out.println("Array list is empty: " + arrayList.isEmpty());
        System.out.println("==========================");

        //Iterator<E> iterator()
        System.out.println("Print list using iterator:");
        Iterator iter = arrayList.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("==========================");

        //int lastIndexOf(Object o)
        System.out.println("Last index of e2: " + arrayList.lastIndexOf(e2));
        System.out.println("==========================");

        //boolean remove(Object o)
        System.out.println("after remove of Object e2");
        arrayList.remove(e1);
        printList(arrayList);
        System.out.println("==========================");

        //E remove(index i)
        System.out.println("after remove by index 1: ");
        arrayList.remove(1);
        printList(arrayList);
        System.out.println("==========================");

        //E set(int index, E element)
        System.out.println("Set element in 0 index: ");
        arrayList.set(0, e3);
        printList(arrayList);
        System.out.println("==========================");

        //List<E> subList(int fromIndex, int toIndex)
        arrayList.add(e1);
        arrayList.add(e2);
        System.out.println("print subList between 0 and 1 indexes: ");
        printList(arrayList.subList(0, 2));
        System.out.println("==========================");

        //Object[] toArray()
        Object[] emplArray = arrayList.toArray();
        System.out.println("print employee array: ");
        for(Object val: emplArray) {
            System.out.println(val);
        }
    }

    private static void printList(List<Employee> list) {
        for(Employee e: list) {
            System.out.println(e.toString());
        }
    }
}
