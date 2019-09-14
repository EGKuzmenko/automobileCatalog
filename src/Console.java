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
                case ("edit"):
                    edit();
                    break;
                case ("exit"):
                    statement = false;
                    break;
                    default:
                        System.out.println("Неправлиьная комманда");
            }
        }
    }

    private String readCommand() {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();

        return inputString.toLowerCase().trim();
    }

    public String readString() {
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
        newCar.setYear(this.readString());

        carStorage.addCar(newCar);
    }

    private void show() {
        System.out.print(carStorage.showCars());
    }

    private void remove() {
        System.out.print("Введите номер автомоблия, который нужно удалить: ");
        int i = Integer.parseInt(readCommand());
        carStorage.remove(i - 1);
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

    private void edit() {
        System.out.print("Выберите автомобиль по номеру в списке : ");
        final int index = Integer.parseInt(readCommand());
        final Car car = carStorage.getCar(index - 1);

        System.out.printf("Производитель : %s. Изменить?(Введите \"да\"/\"нет\")", car.getManufacturer());
        if (readCommand().equals("да"))
            car.setManufacturer(readString());

        System.out.printf("Модель : %s. Изменить?(Введите \"да\"/\"нет\")", car.getModel());
        if (readCommand().equals("да"))
            car.setModel(readString());

        System.out.printf("Типа кузова : %s. Изменить?(Введите \"да\"/\"нет\")", car.getBodyType());
        if (readCommand().equals("да"))
            car.setBodyType(readString());

        System.out.printf("Год : %s. Изменить?(Введите \"да\"/\"нет\")", car.getYear());
        if (readCommand().equals("да"))
            car.setYear(readString());
    }
}
