package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasExample extends Application {
    public void start(Stage stage) {
        Canvas canvas = new Canvas(200, 200);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillOval(10, 10, 30, 30);

        gc.moveTo(0, 0);
        gc.lineTo(20, 20);
        gc.stroke();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 200, 200);
        stage.setTitle("Canvas Demo");
        stage.setScene(scene);
        stage.show();
    }
}
