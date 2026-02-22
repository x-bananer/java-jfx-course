package module_6_4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import module_6_4.view.NoteView;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        NoteView view = new NoteView();
        stage.setScene(new Scene(view.create()));
        stage.setTitle("Notebook");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}