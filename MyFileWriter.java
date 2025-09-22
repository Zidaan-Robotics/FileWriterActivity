import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MyFileWriter {
    public static void main(String[] args) {
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // makes a hidden file with a secret password inside
    public static void makeHiddenFile() throws IOException {
        File f = new File(".secret.txt");

        if (!f.exists()) {
            f.createNewFile();
        }

        try (FileWriter w = new FileWriter(f)) {
            w.write("supersecretpassword");
        }
    }

    // makes a file within a folder with some jibberish (the alphabet)
    public static void makeFolderFile() throws IOException {
        File f = new File(
                "//wsl.localhost/Ubuntu/home/zidaa/FileWriterActivity/.supersecretfolder/ultrahiddenfile");


        f.createNewFile();
        System.out.println("runs");
        try (FileWriter w = new FileWriter(
                "//wsl.localhost/Ubuntu/home/zidaa/FileWriterActivity/.supersecretfolder/ultrahiddenfile")) {
            w.write("abcdefghijklmnopqrstuv+1");
        }
    }

    // prints the size of the file, fileName
    private static void printFileSize(String fileName) {
        File f = new File(fileName);
        System.out.println(f.length());
    }

    public static String returnFileContents(String fileName)
            throws FileNotFoundException, IOException {
        File f = new File(fileName);
        FileReader r = new FileReader(f);
        StringBuilder s = new StringBuilder();
        while (r.ready()) {
            s.append((char) r.read());
        }
        return s.toString();

    }

    // calls printFileSize
    public static void fileSizeTester(String filename) {
        printFileSize(filename);
    }


    // sysouts some string
    public String toString() {
        return "dont even have a constructor yet :wilted_rose:";
    }


    // From:
    // Alexander Obregon
    public static String generateSHA256Hash(String input) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Perform the hash computation
            byte[] encodedhash = digest.digest(input.getBytes());

            // Convert byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hashFile(String file) throws FileNotFoundException, IOException {
        File f = new File(file);
        FileReader reader = new FileReader(file);
        StringBuilder s = new StringBuilder();
        while (reader.ready()) {
            s.append((char) reader.read());
        }
        return generateSHA256Hash(s.toString());


    }



}
