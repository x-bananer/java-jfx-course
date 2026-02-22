package module_6_4.controller;

import module_6_4.model.Note;
import module_6_4.model.Notebook;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class NoteController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentField;

    @FXML
    private Label notes;

    private final Notebook notebook = new Notebook();

    @FXML
    private void addNote() {
        String title = titleField.getText();
        String content = contentField.getText();

        if (title.isBlank() || content.isBlank()) {
            return;
        }

        notebook.add(new Note(title, content));

        String text = "";

        for (Note note : notebook.getAll()) {
            text += note.getTitle() + ":\n" + note.getContent() + "\n\n";
        }

        notes.setText(text);

        titleField.clear();
        contentField.clear();
    }
}
