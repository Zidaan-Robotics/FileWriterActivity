import java.io.IOException;



public class Tester {

    public static void testHashFileEmptyFiles() {
        try {
            System.out.println(MyFileWriter.hashFile("emptyFile.txt"));
            System.out.println("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
        } catch (IOException e) {
            System.out.println("IO Exception thrown :( make better inputs");
        }
    }

    public static void testHashFileLargeFiles() {
        try {
            System.out.println(MyFileWriter.hashFile("largeFile.txt"));
            System.out.println("475fde3795133ec4a0317a68ff79c2a8f7c62b34d0b194730fcc27cbf1ab267d");
        } catch (IOException e) {
            System.out.println("IO Exception thrown :( make better inputs");
        }
    }

    public static void testHashFileSpecialChars() {
        try {
            System.out.println(MyFileWriter.hashFile("specialChars.txt"));
            System.out.println("9171ffb56226ce2454d39434e91e395c1a2952f0cbee23088a941096a8303cc7");
        } catch (IOException e) {
            System.out.println("IO Exception thrown :( make better inputs");
        }
    }

    public static void testHashFileNonExistent() {
        try {
            System.out.println(MyFileWriter.hashFile("fakeFile.txt"));
        } catch (IOException e) {
            System.out.println("IO Exception thrown :( make better inputs");
        }
    }

    public static void main(String[] args) {
        // https://tools.keycdn.com/sha256-online-generator
        // Sha-256 generator used to compare with
        System.out.println("Empty Files:");
        testHashFileEmptyFiles();
        System.out.println("\nLarge Files:");
        testHashFileLargeFiles();
        System.out.println("\nSpecial Chars:");
        testHashFileSpecialChars();
        System.out.println("\n");
        testHashFileNonExistent();
    }
}
