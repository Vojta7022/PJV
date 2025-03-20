package cz.cvut.fel.pjv;

public enum BikeColor {
    RED (1000, "dark red"),
    GREEN (1001, "light green"),
    BLUE (1002, "sky blue");

    public final int colorCode;
    public final String colorName;

    private BikeColor(int colorCode, String colorName) {
        this.colorCode = colorCode;
        this.colorName = colorName;
    }
}
