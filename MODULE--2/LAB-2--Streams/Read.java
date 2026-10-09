// Q1: Write a Java program to read the contents of a text file named input.txt using FileInputStream and display the contents on the console. Handle possible exceptions appropriately and ensure that the stream is closed after reading.
//FileInputStream – Reading a File
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
class Read{
    public static void main(String[] args) {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        String line;
        while((line=br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
        }
      catch(IOException e){
        System.out.println("Something wrong happened : "+e.getMessage());
      }
        }
}