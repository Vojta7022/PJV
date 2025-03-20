package cz.cvut.fel.pjv;

public class RoadBike extends Bicycle {
    private final int tireWidth;

    public RoadBike(int startCadence, int startSpeed, int startGear, int tireWidth) {
        super(startCadence, startSpeed, startGear);
        this.tireWidth = tireWidth;
        this.color = BikeColor.GREEN;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("The RoadBike" + " has " + this.tireWidth + " MM tires.");
        System.out.println("The RoadBike has a" + this.color + " color.");
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
