import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 14L;

    private String year;

    private String manufacturer;

    private String model;

    private String bodyType;

    public Car(final String year, final String manufacturer, final String model, final String bodyType) {
        this.year = year;
        this.manufacturer = manufacturer;
        this.model = model;
        this.bodyType = bodyType;
    }

    public Car() {
        this.year = null;
        this.manufacturer = null;
        this.model = null;
        this.bodyType = null;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(final String year) {
        this.year = year;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public String getBodyType() {
        return this.bodyType;
    }

    public void setBodyType(final String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Car))
            return false;
        final Car that =(Car) obj;
        if (that.year.equals(this.year) && that.bodyType.equals(this.bodyType)
            && that.manufacturer.equals(this.manufacturer) && that.model.equals(this.model)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s ", this.getManufacturer()))
                .append(String.format("%s, ", this.getModel()))
                .append(String.format("%s, ", this.getBodyType()))
                .append(String.format("%s", this.getYear()));

        return sb.toString();
    }
}
