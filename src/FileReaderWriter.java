import java.io.*;

//Сериализация и десериализация
public class FileReaderWriter {

    public static void writeFile(final Storage carStorage) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("resources/car.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(carStorage);
        objectOutputStream.close();
    }

    public static Storage readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("resources/car.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Storage carStorage = (Storage) objectInputStream.readObject();
        objectInputStream.close();

        return carStorage;
    }
}
