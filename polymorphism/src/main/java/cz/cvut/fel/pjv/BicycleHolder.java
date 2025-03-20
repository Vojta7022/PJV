package cz.cvut.fel.pjv;

public class BicycleHolder {
    protected Bicycle bicycle;

    public BicycleHolder(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public String toString() {
        return "BicycleHolder holding " + bicycle;
    }
}
