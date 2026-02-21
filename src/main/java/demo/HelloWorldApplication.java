package demo;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class ButtonBoy implements EventHandler<ActionEvent> {
    private final Label label;
    private final String message;

    public ButtonBoy(Label label, String message) {
        this.label = label;
        this.message = message;
    }

    @Override
    public void handle(ActionEvent event) {
        label.setText(message);
    }
}

public class HelloWorldApplication extends Application {
    @Override
    public void start(Stage window) {
        Label label1 = new Label("Hello World!");
        Button button1 = new Button("Click me!");
        Button button2 = new Button("Rosvonappi");
        Label label2 = new Label("Hei maailma!");

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label1.setText("Nappi hävisi");
            }
        });

        button2.setOnAction(new ButtonBoy(label2, "Klikattu"));

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().addAll(label1, button1, button2, label2);

        Scene view = new Scene(componentGroup, 300, 200);
        window.setTitle("My Greeting Application");
        window.setScene(view);
        window.show();
    }
}
