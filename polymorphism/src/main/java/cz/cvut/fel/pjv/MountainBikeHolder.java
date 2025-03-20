package cz.cvut.fel.pjv;

public class MountainBikeHolder extends BicycleHolder {

    public MountainBikeHolder(MountainBike bicycle) {
        super(bicycle);
    }

    @Override
    public String toString() {
        return "MountainBikeHolder holding " + bicycle;
    }
}
