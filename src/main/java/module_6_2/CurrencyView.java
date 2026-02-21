package module_6_2;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.TextAlignment;

public class CurrencyView {
    private final CurrencyController controller = new CurrencyController();

    public VBox create() {
        Label title = new Label("Currency Converter");

        Label instruction = new Label("How to use Currency Converter? \n Enter an amount, choose currencies, and press \"Convert\" \nto convert money from one currency to another. \n Please edit only the \"From\" field.");

        TextField fromAmountInput = new TextField();
        fromAmountInput.setTextFormatter(new TextFormatter<String>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[0-9.,]*")) {
                return change;
            }
            return null;
        }));

        Label fromCurrencyLabel = new Label("From");
        ChoiceBox<Currency> fromCurrencyChoiceBox = new ChoiceBox<>();
        fromCurrencyChoiceBox.getItems().addAll(controller.getCurrencies());
        fromCurrencyChoiceBox.getSelectionModel().select(0);

        TextField toAmountInput = new TextField();
        toAmountInput.setEditable(false);
        toAmountInput.setDisable(true);

        Label toCurrencyLabel = new Label("To");
        ChoiceBox<Currency> toCurrencyChoiceBox = new ChoiceBox<>();
        toCurrencyChoiceBox.getItems().addAll(controller.getCurrencies());
        toCurrencyChoiceBox.getSelectionModel().select(0);

        Label errorLabel = new Label("");

        Button button = new Button("Convert");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double result = controller.convertSafe(
                            fromAmountInput.getText(),
                            fromCurrencyChoiceBox.getValue(),
                            toCurrencyChoiceBox.getValue()
                    );

                    toAmountInput.setText(String.format("%.2f", result));
                    errorLabel.setText("");
                } catch (IllegalArgumentException ex) {
                    errorLabel.setText(ex.getMessage());
                }
            }
        });

        button.setMaxWidth(Double.MAX_VALUE);

        title.setAlignment(Pos.CENTER);
        title.setMaxWidth(Double.MAX_VALUE);
        title.getStyleClass().add("title");

        errorLabel.setMaxWidth(Double.MAX_VALUE);
        errorLabel.setAlignment(Pos.CENTER);
        errorLabel.getStyleClass().add("error");

        fromCurrencyLabel.getStyleClass().add("input-label");
        toCurrencyLabel.getStyleClass().add("input-label");

        toAmountInput.getStyleClass().add("text-field");

        instruction.setTextAlignment(TextAlignment.CENTER);
        instruction.setMaxWidth(Double.MAX_VALUE);
        instruction.setAlignment(Pos.CENTER);
        instruction.setWrapText(true);
        instruction.getStyleClass().add("instruction");

        HBox fromRow = new HBox(8);
        fromRow.getChildren().addAll(fromAmountInput, fromCurrencyChoiceBox);

        VBox leftCol = new VBox(6);
        leftCol.getChildren().addAll(fromCurrencyLabel, fromRow);

        HBox toRow = new HBox(8);
        toRow.getChildren().addAll(toAmountInput, toCurrencyChoiceBox);

        VBox rightCol = new VBox(6);
        rightCol.getChildren().addAll(toCurrencyLabel, toRow);

        HBox middle = new HBox(20);
        middle.getChildren().addAll(leftCol, rightCol);

        VBox layout = new VBox(12);
        layout.getChildren().addAll(title, middle, button, errorLabel, instruction);
        layout.getStyleClass().add("layout");

        return layout;
    }

}
