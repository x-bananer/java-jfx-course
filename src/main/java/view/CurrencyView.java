package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import entity.Currency;
import controller.CurrencyController;

import java.util.List;

public class CurrencyView {
    private final CurrencyController controller = new CurrencyController();

    private final ChoiceBox<Currency> fromCurrencyChoiceBox = new ChoiceBox<>();
    private final ChoiceBox<Currency> toCurrencyChoiceBox = new ChoiceBox<>();
    private final Label errorLabel = new Label("");
    private final TextField fromAmountInput = new TextField();
    private final TextField toAmountInput = new TextField();

    public VBox create() {
        try {
            controller.createCurrencies();
        } catch (Exception e) {
            errorLabel.setText("Database not available");
        }

        Label title = new Label("Currency Converter");

        Label instruction = new Label("How to use Currency Converter? \n Enter an amount, choose currencies, and press \"Convert\" \nto convert money from one currency to another. \n Please edit only the \"From\" field.");

        fromAmountInput.setTextFormatter(new TextFormatter<String>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[0-9.,]*")) {
                return change;
            }
            return null;
        }));

        Label fromCurrencyLabel = new Label("From");
        updateCurrencies();

        toAmountInput.setEditable(false);
        toAmountInput.setDisable(true);

        Label toCurrencyLabel = new Label("To");

        Button button = new Button("Convert");
        button.setOnAction(event -> {
            try {
                double result = controller.convertAmount(
                        fromAmountInput.getText(),
                        fromCurrencyChoiceBox.getValue(),
                        toCurrencyChoiceBox.getValue()
                );

                toAmountInput.setText(String.format("%.2f", result));
                errorLabel.setText("");
            } catch (IllegalArgumentException ex) {
                errorLabel.setText(ex.getMessage());
            } catch (Exception ex) {
                errorLabel.setText("Database not available");
            }
        });

        Button addCurrencyButton = new Button("Add Currency");
        addCurrencyButton.setOnAction(event -> openAddCurrencyWindow(button));

        button.setMaxWidth(Double.MAX_VALUE);
        addCurrencyButton.setMaxWidth(Double.MAX_VALUE);

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
        HBox.setHgrow(leftCol, Priority.ALWAYS);
        HBox.setHgrow(rightCol, Priority.ALWAYS);

        VBox layout = new VBox(12);
        layout.getChildren().addAll(title, middle, button, addCurrencyButton, errorLabel, instruction);
        layout.getStyleClass().add("layout");

        return layout;
    }

    private void updateCurrencies() {
        try {
            List<Currency> currencies = controller.getCurrencies();
            fromCurrencyChoiceBox.getItems().setAll(currencies);
            toCurrencyChoiceBox.getItems().setAll(currencies);

            if (!currencies.isEmpty()) {
                fromCurrencyChoiceBox.getSelectionModel().selectFirst();
                toCurrencyChoiceBox.getSelectionModel().selectFirst();
            }
            errorLabel.setText("");
        } catch (Exception e) {
            fromCurrencyChoiceBox.getItems().clear();
            toCurrencyChoiceBox.getItems().clear();
            errorLabel.setText("Database not available");
        }
    }

    private void openAddCurrencyWindow(Button sourceButton) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initOwner(sourceButton.getScene().getWindow());
        newStage.setTitle("Add Currency");

        AddCurrencyView addCurrencyView = new AddCurrencyView(controller, newStage);
        Scene scene = new Scene(addCurrencyView.create(), 380, 260);
        scene.getStylesheets().add(getClass().getResource("/currency.css").toExternalForm());

        newStage.setScene(scene);
        newStage.showAndWait();
        updateCurrencies();
    }
}
