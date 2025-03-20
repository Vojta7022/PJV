package cz.cvut.fel.pjv;

public class RoadBikeHolder extends BicycleHolder {
    public RoadBikeHolder(RoadBike bicycle) {
        super(bicycle);
    }

    @Override
    public String toString() {
        return "RoadBikeHolder holding " + bicycle;
    }
}
