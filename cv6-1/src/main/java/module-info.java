module cz.cvut.fel.pjv.cv61 {
    requires javafx.controls;
    requires javafx.fxml;


    opens cz.cvut.fel.pjv.cv61 to javafx.fxml;
    exports cz.cvut.fel.pjv.cv61;
}