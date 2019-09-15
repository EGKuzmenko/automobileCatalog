import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Класс Storage хранит ArrayList с автомобилями
public class Storage implements Serializable {

    private static final long serialVersionUID = 14L;

    private List<Car> listOfCars;

    public Storage() {
        listOfCars = new ArrayList<>();
    }

    public int size() {
        return listOfCars.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void addCar(final Car car) {
        listOfCars.add(car);
    }

    public Car remove(final int index) throws IndexOutOfBoundsException {
        return listOfCars.remove(index);
    }

    public String showCars() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (final Car cars : listOfCars) {
            sb.append(String.format("%d: ", i))
                    .append(cars.toString())
                    .append("\n");
            i++;
        }
        return sb.toString();
    }

    public Car getCar(final int index) {
        return listOfCars.get(index);
    }
}
