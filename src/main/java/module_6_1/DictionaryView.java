package module_6_1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class DictionaryView {
    private DictionaryController dictionaryController = new DictionaryController();

    public FlowPane create() {
        FlowPane layout = new FlowPane();

        layout.getStyleClass().add("pane");

        layout.setHgap(10);
        layout.setVgap(10);

        TextField textField = new TextField();
        textField.getStyleClass().add("text-field");

        Button button = new Button("Search");
        button.getStyleClass().add("button");

        Label label = new Label();
        label.getStyleClass().add("label");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String word = textField.getText();
                String meaning = dictionaryController.search(word);

                label.setText(meaning);
            }
        });

        layout.getChildren().add(textField);
        layout.getChildren().add(button);
        layout.getChildren().add(label);

        return layout;
    }
}
