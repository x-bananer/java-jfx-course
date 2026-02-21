package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HBoxExample extends Application {

    public void start(Stage stage) {
        HBox layout = new HBox();

        Button[] buttons = new Button[12];

        for (int i = 0; i < 12; i++) {
            buttons[i] = new Button("" + (i + 1));
            layout.getChildren().add(buttons[i]);
        }

        Scene view = new Scene(layout);

        stage.setScene(view);
        stage.show();
    }
}

