package main;

import java.io.*;

/*This class shows how to handle FileNotFoundException.
* try/catch/finally blocks were used*/
public class FileNotFoundReader {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        boolean fileFound = true;
        try {
            reader = new FileReader("file.txt"); //exception in this line
            int c;
            while((c = reader.read())!=-1){
                System.out.print((char)c);
            }
        } catch(FileNotFoundException ex) {
            fileFound = false;
            System.out.println(ex.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(fileFound) {
                reader.close();
            }
        }
        System.out.println("rest of the code");
    }
}
