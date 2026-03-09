package view;

import controller.CurrencyController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddCurrencyView {

    private final CurrencyController controller;
    private final Stage stage;

    public AddCurrencyView(CurrencyController controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    public VBox create() {
        Label title = new Label("Add new currency");
        title.getStyleClass().add("title");
        title.setMaxWidth(Double.MAX_VALUE);
        title.setAlignment(Pos.CENTER);

        TextField abbreviationField = new TextField();
        abbreviationField.setPromptText("Currency abbreviation");

        TextField nameField = new TextField();
        nameField.setPromptText("Currency name");

        TextField rateField = new TextField();
        rateField.setPromptText("Rate to USD");
        rateField.setTextFormatter(new TextFormatter<String>(change -> {
            String newText = change.getControlNewText();
            return newText.matches("[0-9.,]*") ? change : null;
        }));

        Label errorLabel = new Label();
        errorLabel.getStyleClass().add("error");
        errorLabel.setWrapText(true);

        Button saveButton = new Button("Save");
        saveButton.setMaxWidth(Double.MAX_VALUE);
        saveButton.setOnAction(event -> {
            try {
                controller.addCurrency(
                        abbreviationField.getText(),
                        nameField.getText(),
                        rateField.getText()
                );
                stage.close();
            } catch (IllegalArgumentException ex) {
                errorLabel.setText(ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("Could not save currency");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                title,
                abbreviationField,
                nameField,
                rateField,
                saveButton,
                errorLabel
        );
        layout.getStyleClass().add("layout");
        return layout;
    }
}
