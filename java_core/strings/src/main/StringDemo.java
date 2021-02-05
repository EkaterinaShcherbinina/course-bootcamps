package main;

public class StringDemo {

    public static void main(String[] args) {
        String nameObj= new String("KateShcherbinina");
        String firstName = "James";
        String lastName = "Smith";

        System.out.println("character value is>>:" + nameObj.charAt(4));

        System.out.println("character value is>>:" + nameObj.charAt(3));

        int length = nameObj.length();

        System.out.println("Length of name is>>:" + length);

        System.out.println("SubString of name is>>:" + nameObj.substring(6));

        System.out.println("SubString of name is>>:" + nameObj.substring(0,6));

        System.out.println("Contains of name is>>:" + nameObj.contains("MAMA"));

        System.out.println("format is >>:" + String.format("first name is %s, last name is %s, age is %d",
                firstName, lastName, 27));

        System.out.println("Object equals literal>>:" + nameObj.equals("KateShcherbinina"));
        System.out.println("Object == literal>>:" + (nameObj == "KateShcherbinina"));
    }
}
