package cz.cvut.fel.pjv;

public interface BicycleVisitable {
    public void accept(Bicycle bicycle);
    public void accept(MountainBike bicycle);
    public void accept(RoadBike bicycle);
}
