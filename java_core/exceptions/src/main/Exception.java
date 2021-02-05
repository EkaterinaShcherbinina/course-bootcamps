package main;

// This class shows exception handling for
// the ArithmeticException and for any other exceptions
public class Exception {

    public static void main(String[] args) {
        try
        {
            boolean temp = true;
            if(temp) {
                int data=50/0;
            } else {
                String nullPointer = null;
                nullPointer.length();
            }
            System.out.println("rest of the try block");
        }
        catch(ArithmeticException e)
        {
            System.out.println("divide by zero: " + e.getMessage());
        }
        catch(java.lang.Exception e)
        {
            System.out.println("another exception: " + e.getMessage());
        }
        System.out.println("rest of the code");
    }
}
