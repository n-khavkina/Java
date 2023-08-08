package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile() throws IOException {
        BufferedReader fin = new BufferedReader
                (new FileReader("C:\\Users1\\Loongik\\Desktop\\HomeWorkJava\\src\\Map\\Task2\\Test.java"));
        String line;
        while ((line = fin.readLine()) != null) System.out.println(line);
    }
}
