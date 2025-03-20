package cz.cvut.fel.pjv;

public class TestBikes {
    public static void main(String[] args) {
        Bicycle bike01, bike02, bike03;

        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, "Dual");
        bike03 = new RoadBike(40, 20, 8, 23);

        bike01.printDescription();
        bike02.printDescription();
        bike03.printDescription();

        BasicService bs, mbs, rbs;
        bs = new BasicService();
        mbs = new MountainBikeService();
        rbs = new RoadBikeService();

        System.out.println("Single Dispatch:");
        System.out.println("BasicService:");
        bs.accept(bike01);
        bs.accept(bike02);
        bs.accept(bike03);

        System.out.println("MountainBikeService:");
        mbs.accept(bike01);
        mbs.accept(bike02);
        mbs.accept(bike03);

        System.out.println("RoadBikeService:");
        rbs.accept(bike01);
        rbs.accept(bike02);
        rbs.accept(bike03);

        System.out.println("Double Dispatch:");
        System.out.println("BasicService:");
        bike01.visit(bs);
        bike02.visit(bs);
        bike03.visit(bs);

        System.out.println("MountainBikeService:");
        bike01.visit(mbs);
        bike02.visit(mbs);
        bike03.visit(mbs);

        System.out.println("RoadBikeService:");
        bike01.visit(rbs);
        bike02.visit(rbs);
        bike03.visit(rbs);

        System.out.println("Single dispatch:");
        Car car1 = new Car();
        car1.accept(bike01);
        car1.accept(bike02);
        car1.accept(bike03);
        System.out.println(car1);

        System.out.println("Double dispatch:");
        Car car2 = new Car();
        bike01.visit(car2);
        bike02.visit(car2);
        bike03.visit(car2);
        System.out.println(car2);
    }
}
