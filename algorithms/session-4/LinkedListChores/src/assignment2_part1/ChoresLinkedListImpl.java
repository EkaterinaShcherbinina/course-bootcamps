package assignment2_part1;

import java.util.Iterator;

public class ChoresLinkedListImpl<E extends Comparable> implements ChoresCollectionInterface<E>
{
   protected LinkEntry<E> head;
   protected LinkEntry<E> tail;
   protected int num_elements = 0;

   public ChoresLinkedListImpl()
   {
      head = tail = null;
   }

   /**
    * Methods inherited from ChoresCollectionInterface
    */
   public boolean is_empty()
   {
      return head == null;
   }

   public boolean is_full() { return false; }

   public int size() { return num_elements; }

   /* 
    * Adds element e at the end of the linked list. */
   public boolean add(E e)
   {
      return add(Where.BACK, e);
   }

   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i)
   {
      if(i < 1 || i > size()) return null;
      E result = null;
      if(head == tail) {
         result = head.element;
         head = tail = null;
         --num_elements;
         return result;
      }

      if(i == 1) {
         result = head.element;
         head = head.next;
         --num_elements;
         return  result;
      }

      int count = 0;
      LinkEntry<E> temp = head;
      while (i - 1 != count) {
         temp = temp.next;
         count++;
      }
      result = temp.next.element;
      temp.next = temp.next.next;
      if(i == size()) tail = temp;
      --num_elements;
      return result;
   }

   /**
    * Determines if e is in the collection. 
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
      LinkEntry<E> temp = head;
      while(temp.next != null) {
         if(temp.element.compareTo(e) == 0) return true;
         temp = temp.next;
      }
      return false;
   }

   /**
    * Add e to either front of the linked list or the end of the linked
    * list, depending on the value of the parameter where.
    * If where == MIDDLE, return false.
    * Returns true if element added to back or front, or false if asked
    * to add in the middle. */
   public boolean add(Where where, E e)  {

      if (where == Where.MIDDLE) 
          return false;

      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
          head = tail = ne;
          num_elements++;
          return true;
      }

      if (where == Where.BACK) {
         tail.next = ne;
         tail = ne;
      }
      else if (where == Where.FRONT)  {
          ne.next = head;
          head = ne;
      }
      num_elements++;
      return true;
   }

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  
    * First element of the linked list is 1, second is 2, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)  {
      if(where != Where.MIDDLE) return false;
      if(index < 1 || index > size()) return false;
      if(index == size()) return add(Where.BACK, e);

      int count = 1;
      LinkEntry<E> temp = head;
      while(count != index) {
         temp = temp.next;
         count++;
      }
      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      ne.next = temp.next;
      temp.next = ne;

      num_elements++;
      return true;
   }

   /**
    * Print the collection class (linked list) by iterating over all of
    * the elements in the collection class and serializing them. 
    * Returns a Java String object that represents the serialization of
    * the collection class. */
   public String toString()  {

      StringBuilder result = new StringBuilder();

      for (E val : this) {
         result.append(val + "\n");
      }

      return result.toString();
   }

   @Override
   public Iterator<E> iterator() {
      return new ChoresIterator();
   }


   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
   }
   /* ------------------------------------------------------------------- */

   private class ChoresIterator implements Iterator<E> {
      private LinkEntry<E> current = head;

      @Override
      public boolean hasNext() {
         return current != null;
      }

      @Override
      public E next() {
         E result = current.element;
         current = current.next;
         return result;
      }
   }

} /* ChoresLinkedListImpl<E> */

