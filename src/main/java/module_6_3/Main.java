package module_6_3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) {
        PetController controller = new PetController();
        PetView view = new PetView(controller);

        Canvas canvas = view.create();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 820, 460);

        stage.setTitle("Virtual Pet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
