package assignment2_part1;


public class ChoresArrayImpl<E> implements ChoresCollectionInterface<E>
{
	private E[] elements;
	   private int num_elements;
	   private int capacity;

	   @SuppressWarnings("unchecked")
	   public ChoresArrayImpl(int size)
	   {
	      elements = (E[]) new Object[size];
	      num_elements = 0;
	      capacity = size;
	   }

	   @SuppressWarnings("unchecked")
	   public ChoresArrayImpl()
	   {
	      /**
	       * Call the c'tor that takes the 'size' parameter.  **/
	      this(5);
	   }

	   /**
	    * Methods inherited from ChoresCollectionInterface
	    */
	   public boolean is_full()
	   {
	      if (num_elements == capacity)
	          return true;
	      return false;
	   }

	   public boolean is_empty()
	   {
	      if (num_elements == 0) 
	          return true;
	      return false;
	   }

	   public int size() { return num_elements; }

	   public boolean add(E e)  {
	      add(Where.BACK, e);  // Add at the end
	      return true;
	   }

	   /*
	    * Remove element at index i.  If the element exists in the collection, 
	    * return that element back to the user.  If the index is out of bounds,
	    * return null.
	    */
	   public E remove(int i) {
	      /*
	       * Add code here.
	       * Remember to compact the array so there are no spaces in between
	       * if an element from the middle is removed or an element at the
	       * beginning of the array is removed.
	       */
		   if(i<=num_elements){
			   E removed_element= elements[i];
		   for(int r=i;r<num_elements;r++){
			   elements[r] = elements[r+1];
		   }
		   	num_elements --;
		    return removed_element;
		   }
	      return null;
	   }

	   /*
	    * Return true if e is in the collection class, false otherwise.
	    */
	   public boolean contains(E e) {
	       /*
	        * Add code here
	        */
		   for(int c=0;c<num_elements;c++){
			   if(elements[c]==e){
				   return true;
			   }
		   }
	       return false;
	   }

	   /**
	    * ---- Methods defined by this class 
	    * ----------------------------------------------------------
	    * Methods that are added by this class and not in the 
	    * ChoresCollectionInterface
	    */

	   /**
	    * Add element in middle.
	    * Preconditions: where == MIDDLE
	    *                index <= num_elements - 1
	    */
	   public boolean add(Where where, int index, E e) { 
	  
	      /* 
	       * If there is no space to add the new element, grow the array. */
	      if (is_full())  {
	          grow();
	      }
	      
	      /**
	       * Add code here 
	       */
	      
	      if((where == Where.MIDDLE)){
	    	  //System.out.println("Inserting element at index middle");
	    	  for(int k=num_elements+1;k>index;k--){
	    		  elements[k] = elements[k-1];
	    	  }
	    	  elements[index] = e;
	    	  num_elements++;
	      }
	      return true; 
	   }

	   /**
	    * Add element in front or at the end, as dictated by where.
	    * Preconditions: where != MIDDLE
	    */
	   public boolean add(Where where, E e) { 
	   
	      /* 
	       * If there is no space to add the new element, grow the array. */
	      if (is_full())  {
	          grow();
	      }

	      if (where == Where.BACK)  {
	          System.out.println("Inserting element at index " + num_elements);
	          elements[num_elements] = e;
	          num_elements++;
	      } 
	      else if (where == Where.FRONT)  {
	          System.out.println("Inserting element at index 0");
	          System.out.println("Compacting storage");
	          /*
	           * Add code here.
	           * You will add the new element at index 0, and shift all the
	           * elements down by one. */
	          
	          for(int j=num_elements+1;j>0;j--){
	        	  elements[j] = elements[j-1];
	          }
	          elements[0] = e;
	          num_elements++;
	      }

	      return true; 
	   }

	   /*
	    * Gets the element at index i (0 <= i <= num_elements-1)
	    */
	   public E get(int i)  {

	      if (i < 0 && i > num_elements)
	          return null;
	      
	      return(elements[i]);
	   }

	   /**
	    * ----------- Private methods
	    */
	   /*
	    * Grows elements array to hold more elements.  Copies old (existing)
	    * elements in the new array.
	    * 
	    * Postcondition: (a) elements must contain the contents of the old array
	    *                (b) elements must now have twice as much capacity as
	    *                    before
	    */
	   @SuppressWarnings("unchecked")
	   private boolean grow()  {

	      /* 
	       * Add code here 
	       * Expand capacity (double it) and copy old array contents to the
	       * new one. 
	       */
		   
		  capacity = (capacity*2);
		  E[] new_elements = elements;
		  elements = (E[])new Object[capacity];
		  for(int i=0; i<new_elements.length;i++){
			  elements[i] = new_elements[i];
		  }
	      System.out.println("Capacity reached.  Increasing storage...");
	      System.out.println("New capacity is " + capacity + " elements");

	      return true;
	   }

	   
	   /*subList(int from, int to): Returns the view of a portion of the list between the specified index from,    
	    *  inclusive, and index to, exclusive.  That is returns a sublist [from, to).    
	    *  Ensure that from and to are valid indices.    *  
	    *  The method returns a new ChoresArrayImpl<E> object.
	    */   
	   public ChoresArrayImpl<E> subList(int from, int to){
		   ChoresArrayImpl<E> sublist = new ChoresArrayImpl<E>();
		    for(int i=from; i<to;i++){
		     sublist.add(elements[i]);
		    }
		    for(int k=0;k<sublist.size();k++){
		     System.out.println("Sub list elements are "+sublist.get(k));
		     
		    }
		    return sublist;
		   }

}
