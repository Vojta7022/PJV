package cz.cvut.fel.pjv.cars.model;

public class ServiceBook {
    private final String[] serviceRecords;
    private final Car car;
    private int numRecords;

    public ServiceBook(Car car) {
        serviceRecords = new String[10];
        this.car = car;
        this.car.setServiceBook(this);
    }

    public void addRecord(String s) {
        for (int i = 0; i < serviceRecords.length; i++) {
            if (serviceRecords[i] == null) {
                serviceRecords[i] = s;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String serviceRecord : serviceRecords) {
            if (serviceRecord != null) {
                s.append(serviceRecord);
                s.append("\n");
            }
        }
        return s.toString();
    }
}
