package cz.cvut.fel.pjv.cars.model;

import java.util.Objects;
import java.util.UUID;

public class Car {
    private final String manufacturer;
    private final String modelName;
    private final int year;
    private Engine engine;
    private final UUID vinCode;
    private ServiceBook serviceBook;
    private int speed;

    private static int numCars = 0;

    public Car(String manufacturer, String modelName, int year) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.year = year;
        vinCode = UUID.randomUUID();
        serviceBook = new ServiceBook(this);
        numCars++;
    }

    public Car(String manufacturer, String modelName, int year, String engine) {
        this(manufacturer, modelName, year);
        this.engine = new Engine(engine);
    }

    public Car(String manufacturer, String modelName, int year, String engine, int speed) {
        this(manufacturer, modelName, year, engine);
        this.speed = speed;
    }

    public static int getNumberOfExistingCars() {
        return numCars;
    }

    @Override
    public String toString() {
        return manufacturer + " " + modelName + " " + year + " VIN: " + vinCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(manufacturer, car.manufacturer) &&
                Objects.equals(modelName, car.modelName) &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(vinCode, car.vinCode) &&
                Objects.equals(serviceBook, car.serviceBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vinCode, modelName);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setServiceBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

    public ServiceBook getServiceBook() {
        return serviceBook;
    }

    public int getSpeed() {
        return speed;
    }
}
