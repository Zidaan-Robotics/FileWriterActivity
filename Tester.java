
import java.io.IOException;

public class Tester {
    public static void main(String[] args) {
        try {
            MyFileWriter.makeHiddenFile();
            MyFileWriter.makeFolderFile();
        } catch (IOException e) {
            System.out.println("rip ");
        }
        
    }
}
