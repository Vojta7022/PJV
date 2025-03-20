package cz.cvut.fel.pjv;

public class RoadBikeService extends BasicService{
    public void accept(Bicycle bike) {
        System.out.println("RBS fixing Bicycle: " + bike);

    }

    public void accept(MountainBike bike) {
        System.out.println("RBS fixing MBK: " + bike);

    }

    public void accept(RoadBike bike) {
        System.out.println("RBS fixing RBK: " + bike);

    }
}
