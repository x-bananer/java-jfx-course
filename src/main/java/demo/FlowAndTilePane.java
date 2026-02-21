package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class FlowAndTilePane extends Application {

    @Override
    public void start(Stage stage) {
        FlowPane layout = new FlowPane();

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
