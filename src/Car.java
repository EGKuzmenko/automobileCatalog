public class Car {

    private Integer year;

    private String manufacturer;

    private String model;

    private String bodyType;

    public Car(final int year, final String manufacturer, final String model, final String bodyType) {
        this.year = year;
        this.manufacturer = manufacturer;
        this.model = model;
        this.bodyType = bodyType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car))
            return false;
        final Car that =(Car) obj;
        if (that.year.equals(this.year) && that.bodyType.equals(this.bodyType)
            && that.manufacturer.equals(this.manufacturer) && that.model.equals(this.model)) {
            return true;
        }
        return false;
    }
}
