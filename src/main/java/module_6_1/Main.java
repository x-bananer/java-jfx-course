package module_6_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        DictionaryView dictionaryView = new DictionaryView();
        FlowPane flowPane = dictionaryView.create();

        Scene scene = new Scene(flowPane, 400, 400);

        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public  static void main(String[] args) {
        launch();
    }
}
