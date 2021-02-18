package main;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(2);
        list.add(0);
        list.add(5);
        System.out.println("after add: ");
        for(Integer val: list) {
            System.out.print(val + " ");
        }

        Integer value = list.get(1);
        System.out.println();
        System.out.println("get 1 index: " + value);

        System.out.println();
        System.out.println("size: " + list.size());

        System.out.println();
        System.out.println("remove element by 1 index: " + list.remove(1));
        for(Integer val: list) {
            System.out.print(val + " ");
        }

        System.out.println();
        System.out.println("remove last: " + list.removeLast());
        for(Integer val: list) {
            System.out.print(val + " ");
        }

        System.out.println();
        System.out.println("size: " + list.size());
    }
}
