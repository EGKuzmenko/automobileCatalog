import java.io.*;

public class Main {
    public static void main(String[] args) {
        Initializer.checkFile();
        Storage carStorage = new Storage();
        try {
            carStorage = FileReaderWriter.readFile();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        Console console = new Console(carStorage);
    }
}
