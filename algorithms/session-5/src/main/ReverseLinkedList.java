package main;

public class ReverseLinkedList {

    public static void main(String[] args) {
        test1();
        System.out.println("========================");
        test2();
        System.out.println("========================");
        test3();
    }

    private static LinkedListTest.ListNode reverseLinkedList(LinkedListTest.ListNode head) {
        if(head == null) return null;
        LinkedListTest reverse = new LinkedListTest();
        LinkedListTest.ListNode temp = head;
        while(temp.next != null) {
            reverse.addFront(temp.val);
            temp = temp.next;
        }
        reverse.addFront(temp.val);
        return reverse.head;
    }

    private static void test1() {
        LinkedListTest list = new LinkedListTest();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.head = reverseLinkedList(list.head);
        System.out.print("test1, result: ");
        list.printList();
        if("5 4 3 2 1".equals(list.getString())) System.out.println("test1: successful");
        else System.out.println("test1: failed");
    }

    private static void test2() {
        LinkedListTest list = new LinkedListTest();
        list.add(1);
        list.head = reverseLinkedList(list.head);
        System.out.print("test2, result: ");
        list.printList();
        if("1".equals(list.getString())) System.out.println("test2: successful");
        else System.out.println("test2: failed");
    }

    private static void test3() {
        LinkedListTest list = new LinkedListTest();
        list.head = reverseLinkedList(list.head);
        System.out.print("test3, result: ");
        list.printList();
        if(list.head == null) System.out.println("test3 successful");
        else System.out.println("test3: failed");
    }
}
