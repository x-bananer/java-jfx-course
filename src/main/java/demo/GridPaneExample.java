package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

    @Override
    public void start(Stage stage) {
        GridPane layout = new GridPane();

        Button button1 = new Button("TOP LEFT");
        Button button2 = new Button("TOP RIGHT");
        Button button3 = new Button("BOTTOM LEFT");
        Button button4 = new Button("BOTTOM RIGHT");
        Button button5 = new Button("MIDDLE (with long textith long textith long textith long textith long textith long textith long textith long textith long text)");

        layout.add(button1, 0, 0);
        layout.add(button2, 1, 0);
        layout.add(button3, 0, 1);
        layout.add(button4, 1, 1);
        layout.add(button5, 0, 2, 8, 1);

        Scene view = new Scene(layout);

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.DEEPPINK,
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        layout.setBackground(background);

        stage.setScene(view);
        stage.show();
    }
}
