package assignment2_part1;

public class DSArrayTest {
public static void main(String[] args) {  
    ChoresArrayImpl<Integer> numbers = new ChoresArrayImpl<Integer>();
      numbers.add(100);
     numbers.add(200);     
     numbers.add(300);
     numbers.add(400);     
     numbers.add(500); 
     numbers.add(600);    
     numbers.add(700); 
    numbers.add(700);
      print_list(numbers);
      ChoresArrayImpl<Integer> sub = numbers.subList(1,4);
       print_list(sub);   }
   private static void print_list(ChoresArrayImpl<Integer> numbers)  {
      for (int i = 0; i < numbers.size(); i++)     
	 {      
	   System.out.print(numbers.get(i) + " ");   
	   }    
    System.out.println();   
	} 
}