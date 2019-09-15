import Exceptions.InvalidYearException;

import java.io.IOException;
import java.util.Scanner;

public class Console {

    Storage carStorage;

    public Console(final Storage carStorage) {
        this.carStorage = carStorage;
        startMenu();
        parseCommand();
    }

    private void parseCommand() {
        boolean state = true;
        while (state) {
            System.out.print("\nВведите команду --> ");
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
                case ("edit"):
                    edit();
                    break;
                case ("exit"):
                    state = false;
                    break;
                    default:
                        System.out.println("Команда введена неверно");
            }
        }
    }

    private void startMenu() {
        System.out.println("Автомобильный справочник");
        System.out.println("Для вызова справки введите \"help\"");
    }

    private String readCommand() {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        return inputString.toLowerCase().trim();
    }

    private String readString() {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        return inputString.trim();
    }

    private void add() {
        System.out.println("Введите данные для автомобиля");
        Car newCar = new Car();

        System.out.print("Производитель : ");
        newCar.setManufacturer(this.readString());

        System.out.print("Модель : ");
        newCar.setModel(this.readString());

        System.out.print("Тип кузова : ");
        newCar.setBodyType(this.readString());

        System.out.print("Год : ");
        try {
            newCar.setYear(this.readString());
        } catch (InvalidYearException | NumberFormatException | NullPointerException ex) {
            System.out.print("Год введен неверно");
        }

        carStorage.addCar(newCar);
        try {
            FileReaderWriter.writeFile(carStorage);
        } catch (IOException e) {}
    }

    private void show() {
        if (carStorage.isEmpty())
            System.out.print("Справочник пуст\n");
        System.out.print(carStorage.showCars());
    }

    private boolean remove() {
        if (carStorage.isEmpty()) {
            this.show();
            return false;
        }
        this.show();
        System.out.print("Введите номер автомобиля, который нужно удалить: ");

        try {
            int i = Integer.parseInt(readCommand());

            try {
                carStorage.remove(i - 1);
            } catch (IndexOutOfBoundsException ex) {
                System.out.printf("\nАвтомобиля под номером %d не сущетсвует\n", i);
            }

        } catch (NumberFormatException ex) {
            System.out.println("Необходимо ввести число");
        }

        try {
            FileReaderWriter.writeFile(carStorage);
        } catch (IOException e) {}
        return true;
    }

    private void help() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Список доступных команд");
        sb.append("\"add\" - добавить новый автомобиль\n")
                .append("\"remove\" - удалить автомобиль из списка\n")
                .append("\"edit\" - редактировать автомобиль\n")
                .append("\"show\" - показать все автомобили, внесенные в справочник\n")
                .append("\"exit\" - выйти из программы\n")
                .append("\"help\" - показать список команд");
        System.out.println(sb.toString());
    }

    private boolean edit() {
        if (carStorage.isEmpty()) {
            this.show();
            return false;
        }
        this.show();
        System.out.print("Выберите автомобиль по номеру в списке : ");

        try {

            final int index = Integer.parseInt(readCommand());

            try {

                final Car car = carStorage.getCar(index - 1);
                System.out.printf("Производитель : %s. Изменить?(\"да\" для изменения) : ", car.getManufacturer());
                if (readCommand().equals("да")) {
                    System.out.print("\nВведите производителя --> ");
                    car.setManufacturer(readString());
                }

                System.out.printf("Модель : %s. Изменить?(\"да\" для изменения) : ", car.getModel());
                if (readCommand().equals("да")) {
                    System.out.print("\nВведите модель --> ");
                    car.setModel(readString());
                }

                System.out.printf("Тип кузова : %s. Изменить?(\"да\" для изменения) : ", car.getBodyType());
                if (readCommand().equals("да")) {
                    System.out.print("\nВведите тип кузова --> ");
                    car.setBodyType(readString());
                }

                System.out.printf("Год : %s. Изменить?(\"да\" для изменения) : ", car.getYear());
                if (readCommand().equals("да")) {
                    System.out.print("\nВведите год --> ");
                    try {
                        car.setYear(readString());
                    } catch (InvalidYearException | NumberFormatException ex) {
                        System.out.println("Год введен неверно");
                    }
                }

            } catch (IndexOutOfBoundsException ex) {
                System.out.printf("Автомобиля под номером %d не существует\n", index);
            }

        } catch (NumberFormatException ex) {
            System.out.println("Необходимо ввести число");
        }

        try {
            FileReaderWriter.writeFile(carStorage);
        } catch (IOException e) {}

        return true;
    }
}
