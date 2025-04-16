package cz.cvut.fel.pjv.cv61;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello!");
        FlowPane root = new FlowPane();
        root.setStyle("-fx-background-color: #ffcc99;");
        Scene scene = new Scene(root, 320, 240);

        Label label = new Label("Default text");
        BorderPane.setAlignment(label, Pos.CENTER);
        root.getChildren().add(label);

        Button button = new Button("Click here!");

        button.setOnAction(new EventHandler<ActionEvent>() { // Can be replaced with lambda or reference to a new EventHandler object
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(actionEvent);
                System.out.println(actionEvent.getSource());
                label.setText("Was clicked at " + System.currentTimeMillis());
                ((Button) actionEvent.getSource()).setText("Dont click anymore!");
            }
        });

        root.getChildren().add(button);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(20);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}