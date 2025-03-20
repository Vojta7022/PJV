package cz.cvut.fel.pjv;

import java.util.ArrayList;
import java.util.List;

public class Car implements BicycleVisitable {
    private List<BicycleHolder> carHolders = new ArrayList<BicycleHolder>();

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (BicycleHolder bike : carHolders) {
            str.append(bike.toString());
            str.append("\n");
        }
        return str.toString();
    }

    public void accept(Bicycle bicycle) {
        carHolders.add(new BicycleHolder(bicycle));
        System.out.println("Car storing Bicycle: " + bicycle);
    }

    public void accept(MountainBike bicycle) {
        carHolders.add(new MountainBikeHolder(bicycle));
        System.out.println("Car storing MountainBike: " + bicycle);
    }

    public void accept(RoadBike bicycle) {
        carHolders.add(new RoadBikeHolder(bicycle));
        System.out.println("Car storing RoadBike: " + bicycle);
    }
}
