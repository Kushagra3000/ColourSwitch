import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoadGamePageController {

    @FXML
    private AnchorPane LoadGameRoot;

    @FXML
    void backToMenu() throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        LoadGameRoot.getChildren().setAll(pane);
    }

}
