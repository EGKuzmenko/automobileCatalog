import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    Storage carStorage;

    public Console(final Storage carStorage) {
        this.carStorage = carStorage;
        help();
        parseCommand();
    }

    private void parseCommand() {
        boolean statement = true;
        while (statement) {
            String str = readCommand();
            switch (str) {
                case ("help"):
                    help();
                    break;
                case ("show"):
                    show();
                    break;
                case ("add"):
                    add();
                    break;
                case ("remove"):
                    remove();
                    break;
                case ("exit"):
                    statement = false;
                    break;
                    default:
                        System.out.println("Неправлиьная комманда");
            }
        }
    }

    private void clear() {
        System.out.flush();
    }

    private String readCommand() {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        return inputString;
    }

    private void add() {
        System.out.println("Введите данные для автомобиля");

        Car newCar = new Car();
        Scanner in = new Scanner(System.in);

        System.out.print("Производитель : ");
        newCar.setManufacturer(in.nextLine());

        System.out.print("Модель : ");
        newCar.setModel(in.nextLine());

        System.out.print("Тип кузова : ");
        newCar.setBodyType(in.nextLine());

        System.out.print("Год : ");
        newCar.setYear(in.nextInt());

        carStorage.addCar(newCar);
    }

    private void show() {
        System.out.print(carStorage.showCars());
    }

    private void remove() {
        System.out.print("Введите номер автомоблия, который нужно удалить: ");
        int i = Integer.parseInt(readCommand());
        carStorage.remove(i);
        System.out.print(carStorage.showCars());
    }

    private void help() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Справка");
        sb.append("\"add\" - добавить новый автомобиль\n")
                .append("\"remove\" - удалить автомобиль из списка\n")
                .append("\"show\" - показать все автомобили, внесенные в справочник\n")
                .append("\"exit\" - выйти из программы\n")
                .append("\"help\" - показать справку");
        System.out.println(sb.toString());
    }
//
//    private void edit() {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Введите номер автомобиля, который нужно отредактировать : ");
//        int index = in.nextInt();
//        Car car = carStorage.getCar(index);
//        System.out.print("Отредактировать всю запись?\nВведите \"да\" / \"нет\"");
//        if (in.nextLine().equals("да")) {
//
//            System.out.print("Новый производитель : ");
//            car.setManufacturer(in.nextLine());
//
//            System.out.print("Новая одель : ");
//            car.setModel(in.nextLine());
//
//            System.out.print("Новый тип кузова : ");
//            car.setBodyType(in.nextLine());
//
//            System.out.print("Новый год : ");
//            car.setYear(in.nextInt());
//        } else {
//            System.out.println("Что бы вы хотели изменить?");
//            System.out.printf("1 - %s\n2 - %s\n3 - %s\n4 - %s\n:", "Производитель", "Модель", "Тип кузова", "Год");
//            switch (in.nextInt()) {
//                case (1):
//                    car.setManufacturer(in.nextLine());
//            }
//        }
//    }


}
