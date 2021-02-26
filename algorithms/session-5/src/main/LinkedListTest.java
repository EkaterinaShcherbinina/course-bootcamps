package main;

// Simple linked list for tasks
public class LinkedListTest<Integer> {
    //shouldn't be public, only for this example
    public ListNode head;

    public class ListNode {
        Integer val;
        ListNode next;

        public ListNode(Integer x) {
            val = x;
        }
    }

    public LinkedListTest() {
        head = null;
    }

    public void add(Integer item) {
        ListNode node = new ListNode(item);
        if (head == null) head = node;
        else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void addFront(Integer item) {
        ListNode node = new ListNode(item);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void addAll(LinkedListTest list) {
        if(head == null) head = list.head;
        else {
            LinkedListTest.ListNode temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = list.head;
        }
    }

    public void printList() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        LinkedListTest.ListNode temp = head;
        while(temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public String getString() {
        StringBuilder result = new StringBuilder();
        LinkedListTest.ListNode temp = head;
        while(temp.next != null) {
            result.append(temp.val).append(" ");
            temp = temp.next;
        }
        result.append(temp.val);
        return result.toString();
    }
}
