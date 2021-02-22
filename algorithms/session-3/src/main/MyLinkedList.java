package main;

import java.util.Iterator;

public class MyLinkedList<Item extends Comparable<Item>> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    private int size = 0;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item > {
        private Node current = first;

        @Override
        public boolean hasNext() {
            boolean isNext = current != null;
            return isNext;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        if(first == null) {
            first = node;
        } else {
            Node temp = first;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        ++size;
    }

    public int size() {
        return size;
    }

    public Item get(int index) {
        int size = size();
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();

        if(first == null) return null;

        Node temp = first;
        int count = 0;
        while(temp.next != null) {
            if(count == index) break;
            temp = temp.next;
            count++;
        }
        return temp.item;
    }

    public boolean contains(Item item) {
        Node temp = first;
        while(temp != null) {
            if(item.compareTo(temp.item) == 0) return true;
            temp = temp.next;
        }
        return false;
    }

    public Item removeLast() {
        Item result = null;
        if(first == null) return null;
        if(first.next == null) {
            result = first.item;
            first = null;
        } else {
            Node temp = first;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            result = temp.next.item;
            temp.next = null;
        }
        --size;
        return result;
    }

    public Item remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        if(first == null) return null;

        Item result = null;
        int count = 0;
        if(first.next == null) {
            result = first.item;
            first = null;
        } else {
            Node temp = first;
            while(count != index - 1) {
                temp = temp.next;
                count++;
            }
            result = temp.next.item;
            temp.next = temp.next.next;
        }
        --size;
        return result;
    }
}
