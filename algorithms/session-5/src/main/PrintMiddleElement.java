package main;

public class PrintMiddleElement {
    public static void main(String[] args) {
        test1();
        System.out.println("========================");
        test2();
        System.out.println("========================");
        test3();
    }

    private static Integer getMiddleElement(LinkedListTest.ListNode head) {
        if(head == null) {
            return null;
        }

        LinkedListTest.ListNode temp = head;
        int size = 1;
        while(temp.next != null) {
            temp = temp.next;
            size++;
        }

        int middle = size % 2 == 0 ? size / 2 : size / 2 + 1;
        temp = head;
        --middle;
        while(temp.next != null && middle != 0) {
            temp = temp.next;
            --middle;
        }
        return (Integer) temp.val;
    }

    private static void test1() {
        LinkedListTest list = new LinkedListTest();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Integer val = getMiddleElement(list.head);
        System.out.println("test1, result: " + val);
        list.printList();
        if(val == 3) System.out.println("test1: successful");
        else System.out.println("test1: failed");
    }

    private static void test2() {
        LinkedListTest list = new LinkedListTest();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        Integer val = getMiddleElement(list.head);
        System.out.println("test2, result: " + val);
        list.printList();
        if(val == 4) System.out.println("test1: successful");
        else System.out.println("test2: failed");
    }

    private static void test3() {
        LinkedListTest list = new LinkedListTest();

        Integer val = getMiddleElement(list.head);
        System.out.println("test3, result: " + val);
        list.printList();
        if(val == null) System.out.println("test1: successful");
        else System.out.println("test3: failed");
    }
}
