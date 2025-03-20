package cz.cvut.fel.pjv;

public class MountainBike extends Bicycle {
    private final String suspension;

    public MountainBike(int startCadence, int startSpeed, int startGear, String suspension) {
        super(startCadence, startSpeed, startGear);
        this.suspension = suspension;
        this.color = BikeColor.BLUE;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("The " + "MountainBike has a" + this.suspension + " suspension.");
        System.out.println("The " + "MountainBike has a" + this.color + " color.");
    }

//    public void visit(BasicService service) {
//        service.acceptBike(this);
//    }
//
//    public void visit(Car car) {
//        car.accept(this);
//    }

    public void visit(BicycleVisitable visitable) {
        visitable.accept(this);
    }
}
