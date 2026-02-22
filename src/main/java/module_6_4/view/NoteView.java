package module_6_4.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class NoteView {

    public Parent create() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/notebook_view.fxml"));
        return loader.load();
    }
}
