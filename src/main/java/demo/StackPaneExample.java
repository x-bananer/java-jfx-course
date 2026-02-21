package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class StackPaneExample extends Application {

    public void start(Stage stage) {
        StackPane layout = new StackPane();

        Button button1 = new Button("[           ]");
        Label label = new Label("Hello!");

        label.setOpacity(0.5);

        layout.getChildren().add(button1);
        layout.getChildren().add(label);

        Scene view = new Scene(layout);

        stage.setScene(view);
        stage.show();
    }
}
