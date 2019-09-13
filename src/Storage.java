import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Car> listOfCars;

    public Storage() {
        listOfCars = new ArrayList<>();
    }

    public int size() {
        return listOfCars.size();
    }

    public void addCar(final Car car) {
        listOfCars.add(car);
    }

    public Car remove(final int index) {
        return listOfCars.remove(index);
    }

    public String showCars() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (final Car cars : listOfCars) {
            sb.append(String.format("%d: ", i))
                    .append(cars.toString())
                    .append("\n");
            i++;
        }
        return sb.toString();
    }

    public String showCarByIndex(final int index) {
        int i = index;
        return listOfCars.get(i).toString();
    }

    public void editYear(final int index, final int newYear) {
        listOfCars.get(index).setYear(newYear);
    }

    public void editManufacturer(final int index, final String newManufacturer) {
        listOfCars.get(index).setManufacturer(newManufacturer);
    }

    public void editModel(final int index, final String newModel) {
        listOfCars.get(index).setModel(newModel);
    }

    public void editBodyType(final int index, final String newBodyType) {
        listOfCars.get(index).setBodyType(newBodyType);
    }

    public Car getCar(final int index) {
        return listOfCars.get(index);
    }
}
