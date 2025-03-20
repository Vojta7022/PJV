package cz.cvut.fel.pjv;

public class BasicService implements BicycleVisitable {
    public void accept(Bicycle bike) {
        System.out.println("BS fixing Bicycle: " + bike);

    }

    public void accept(MountainBike bike) {
        System.out.println("BS fixing MBK: " + bike);

    }

    public void accept(RoadBike bike) {
        System.out.println("BS fixing RBK: " + bike);

    }
}
