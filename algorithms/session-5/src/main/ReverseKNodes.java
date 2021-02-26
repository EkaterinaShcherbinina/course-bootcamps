package main;

public class ReverseKNodes {
    public static void main(String[] args) {
        test1();
        System.out.println("========================");
        test2();
        System.out.println("========================");
        test3();
        System.out.println("========================");
        test4();
        System.out.println("========================");
        test5();
    }

    private static LinkedListTest.ListNode reverseLinkedList(LinkedListTest.ListNode head, int k) {
        if(head == null) return null;

        LinkedListTest reverse = new LinkedListTest();
        LinkedListTest reverseKNode = new LinkedListTest();
        LinkedListTest.ListNode temp = head;
        int count = 0;
        while(temp.next != null) {
            reverseKNode.addFront(temp.val);
            count++;
            if(count == k) {
                reverse.addAll(reverseKNode);
                reverseKNode.head = null;
                count = 0;
            }
            temp = temp.next;
        }
        reverseKNode.addFront(temp.val);
        reverse.addAll(reverseKNode);
        return reverse.head;
    }

    private static void test1() {
        LinkedListTest list = new LinkedListTest();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        list.head = reverseLinkedList(list.head, 4);
        System.out.print("test1, result: ");
        list.printList();
        if("4 2 2 1 8 7 6 5".equals(list.getString())) System.out.println("test1: successful");
        else System.out.println("test1: failed");
    }

    private static void test2() {
        LinkedListTest list = new LinkedListTest();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        list.head = reverseLinkedList(list.head, 3);
        System.out.print("test2, result: ");
        list.printList();
        if("2 2 1 6 5 4 8 7".equals(list.getString())) System.out.println("test2: successful");
        else System.out.println("test2: failed");
    }

    private static void test3() {
        LinkedListTest list = new LinkedListTest();
        list.add(1);

        list.head = reverseLinkedList(list.head, 3);
        System.out.print("test3, result: ");
        list.printList();
        if("1".equals(list.getString())) System.out.println("test3: successful");
        else System.out.println("test3: failed");
    }

    private static void test4() {
        LinkedListTest list = new LinkedListTest();

        list.head = reverseLinkedList(list.head, 3);
        System.out.print("test4, result: ");
        list.printList();
        if(list.head == null) System.out.println("test4: successful");
        else System.out.println("test4: failed");
    }

    private static void test5() {
        LinkedListTest list = new LinkedListTest();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        list.head = reverseLinkedList(list.head, 1);
        System.out.print("test5, result: ");
        list.printList();
        if("1 2 2 4 5 6 7 8".equals(list.getString())) System.out.println("test5: successful");
        else System.out.println("test5: failed");
    }
}
