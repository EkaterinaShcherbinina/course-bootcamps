package main;

import java.io.FileWriter;
import java.io.IOException;

// This class shows how to use "try with resources" instead try/catch/finally
public class FileNotFoundWriter {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("notes.txt")) {
            String hello = "Hello World";
            writer.write(hello);
            writer.append("\n");
            writer.flush();
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("rest of the code");
    }
}
