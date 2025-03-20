package cz.cvut.fel.pjv;

public class MountainBikeService extends BasicService{
    public void accept(Bicycle bike) {
        System.out.println("MBS fixing Bicycle: " + bike);

    }

    public void accept(MountainBike bike) {
        System.out.println("MBS fixing MBK: " + bike);

    }

    public void accept(RoadBike bike) {
        System.out.println("MBS fixing RBK: " + bike);

    }
}
