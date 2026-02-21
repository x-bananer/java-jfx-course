package demo;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CSSExample extends Application {

    private double dx = 2.5;
    private double dy = 2.0;

    @Override
    public void start(Stage stage) {
        Pane layout = new Pane();

        Button button = new Button("DVD");
        layout.getChildren().add(button);

        Scene view = new Scene(layout, 600, 400);

        stage.setScene(view);
        stage.show();

        button.applyCss();
        button.layout();
        button.setLayoutX(view.getWidth() - button.getWidth() - 10);
        button.setLayoutY(view.getHeight() - button.getHeight() - 10);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double x = button.getLayoutX() + dx;
                double y = button.getLayoutY() + dy;

                if (x <= 0 || x + button.getWidth() >= view.getWidth()) {
                    dx = -dx;
                }
                if (y <= 0 || y + button.getHeight() >= view.getHeight()) {
                    dy = -dy;
                }

                button.setLayoutX(button.getLayoutX() + dx);
                button.setLayoutY(button.getLayoutY() + dy);
            }
        };

        button.setOnAction(e -> timer.start());
    }
}