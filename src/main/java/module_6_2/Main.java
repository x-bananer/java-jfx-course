package module_6_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        CurrencyView view = new CurrencyView();
        VBox root = view.create();

        Scene scene = new Scene(root, 550, 300);
        scene.getStylesheets().add(getClass().getResource("/currency.css").toExternalForm());

        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
