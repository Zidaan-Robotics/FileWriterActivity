import java.io.IOException;



public class Tester {
    public static void main(String[] args) {
        try {
            System.out.println(MyFileWriter.hashFile("testfile2.txt"));
            System.out.println(MyFileWriter.returnFileContents("testfile2.txt"));
        } catch (IOException e) {
            System.out.println("IO Exception thrown :( make better inputs");
        }



    }
}
