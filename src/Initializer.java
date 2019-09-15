import java.io.File;
import java.io.IOException;

public class Initializer {

    public static void checkFile() {
        if (!(new File("resources/car.ser").exists()))
            init();
    }

    private static void init() {
        Storage carStorage = new Storage();

        carStorage.addCar(new Car("2010", "Suzuki", "Grand Vitara", "SUV"));
        carStorage.addCar(new Car("2008", "Toyota", "Camry", "Sedan"));
        carStorage.addCar(new Car("2019", "Tesla", "Model Y", "Crossover"));

        try {
            FileReaderWriter.writeFile(carStorage);
        } catch (IOException e) {}
    }

}
