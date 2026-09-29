package day1;

class Car {

    private int rcNumber;
    private String color;
    private String model;
    private String manufacturer;

    Car() {}

    Car(int rc) {
        this.rcNumber = rc;
    }
    Car(int rc, String color, String model, String manufacturer) {
        this.rcNumber = rc;
        this.color = color;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public int getRcNumber() {
        return this.rcNumber;
    }
    public void setRcNumber(int rc) {
        this.rcNumber = rc;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    // @Override
    // public String toString() {
    //     // return "{ rcNumber: " + Integer.toString(this.rcNumber) + "}";

    //     // make json string representation of the object
    //     return "{ \"rcNumber\": " + this.rcNumber + ", \"color\": \"" + this.color + "\", \"model\": \"" + this.model + "\", \"manufacturer\": \"" + this.manufacturer + "\" }";

    // }

}