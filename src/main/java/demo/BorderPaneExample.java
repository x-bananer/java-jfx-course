package demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();

        Button topButton = new Button("NORTH");
        Button rightButton = new Button("EAST");
        Button bottomButton = new Button("SOUTH");
        Button leftButton = new Button("WEST");
        Button centerButton = new Button("CENTER");

        layout.setTop(topButton);
        layout.setRight(rightButton);
        layout.setBottom(bottomButton);
        layout.setLeft(leftButton);

        // если добавить разные элементы в одно место, выберется последний
        layout.setCenter(new Button("NEW BUTTON"));

        // эта кнопочка посередине
        layout.setAlignment(topButton, Pos.TOP_CENTER);

        // инстанс можно добавить только 1 раз, иначе ошибка
        // layout.setCenter(leftButton);

        layout.setTop(topButton);

        Scene view = new Scene(layout);

        stage.setScene(view);
        stage.show();
    }
}
