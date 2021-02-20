package assignment2_part1;



public class DSArray
{
   public static void main(String[] args) {
      ChoresArrayImpl<Chores> chores_array = new ChoresArrayImpl<Chores>();

      chores_array.add(new Chores("Make bed", 10));
      chores_array.add(new Chores("Make dinner", 20));
      chores_array.add(new Chores("Exercise", 30));
      chores_array.add(new Chores("Walk the dog", 15));
      chores_array.add(new Chores("Watch movie", 120));
      chores_array.add(new Chores("Sleep", 480));
      
      print_chores(chores_array);

      chores_array.add(Where.FRONT, new Chores("Listen to music", 60));
      Chores c = new Chores("Read a book", 50);

      chores_array.add(Where.MIDDLE, 3, c);

      print_chores(chores_array);

      if (chores_array.contains(c))  {
          System.out.println(c + " is present");
      }
      else  {
          System.out.println(c + " is not present");
      }

      Chores c2 = new Chores("Jog", 20);
      if (chores_array.contains(c2))  {
          System.out.println(c2 + " is present");
      }
      else  {
          System.out.println(c2 + " is not present");
      }

      Chores c3 = chores_array.remove(3);
      if (c3 != null)  {
          System.out.println(c3 + " removed");
      }

      print_chores(chores_array);
   }

   private static void print_chores(ChoresArrayImpl<Chores> chores)  {

      System.out.println("There are " + chores.size() +
                         " chores to do today!");
      System.out.println("These are: ");
      for (int i = 0; i < chores.size(); i++)
      {
         Chores c = chores.get(i);
         System.out.println("  " + i + " " + c);
      }
   }
}
