package cz.cvut.fel.pjv.cv6_2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("BMI Calc!");
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #ffcc99;");
        root.setSpacing(20);

        Scene scene = new Scene(root);

        Label weightLabel = new Label("Weight:");
        TextField weightField = new TextField();

        Label heightLabel = new Label("Height:");
        TextField heightField = new TextField();

        TextField bmiField = new TextField();
        bmiField.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-max-width: 150px;");
        bmiField.setAlignment(Pos.CENTER);
        bmiField.setEditable(false);

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> {
            try {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                double bmi = weight / (height * height);
                bmi = Math.round(bmi * 100) / 100.0;
                bmiField.setText(String.valueOf(bmi));

                if (bmi < 18.5) {
                    bmiField.setStyle(bmiField.getStyle() + "-fx-background-color: yellow");
                } else if (bmi < 25) {
                    bmiField.setStyle(bmiField.getStyle() + "-fx-background-color: green");
                } else if (bmi < 30) {
                    bmiField.setStyle(bmiField.getStyle() + "-fx-background-color: yellow");
                } else {
                    bmiField.setStyle(bmiField.getStyle() + "-fx-background-color: red");
                }

            } catch (NumberFormatException ex) {
                bmiField.setText("Invalid");
                bmiField.setStyle(bmiField.getStyle() + "-fx-background-color: red");
            }
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(weightLabel, 0, 0);
        grid.add(weightField, 1, 0);
        grid.add(heightLabel, 0, 1);
        grid.add(heightField, 1, 1);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(grid, calculateButton, bmiField);

        stage.setScene(scene);
        stage.show();

        weightField.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                System.out.println(scrollEvent);
                if (scrollEvent.getDeltaY() > 0) {
                    weightField.setText(String.valueOf(Double.parseDouble(weightField.getText()) + 1));
                } else {
                    weightField.setText(String.valueOf(Double.parseDouble(weightField.getText()) - 1));
                }
            }
        });

        heightField.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent scrollEvent) {
                System.out.println(scrollEvent);
                if (scrollEvent.getDeltaY() > 0) {
                    heightField.setText(String.valueOf(Math.round((Double.parseDouble(heightField.getText()) + 0.01) * 100) / 100.0));
                } else {
                    heightField.setText(String.valueOf(Math.round((Double.parseDouble(heightField.getText()) - 0.01) * 100) / 100.0));
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}