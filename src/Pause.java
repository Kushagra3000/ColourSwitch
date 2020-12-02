import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Pause {

    @FXML
    public AnchorPane PausePage;

    @FXML
    void ResumeGame() throws IOException {
        AnchorPane pausePane = FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        PausePage.getChildren().setAll(pausePane);
    }

    @FXML
    void backToMenu() throws IOException {
        AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        PausePage.getChildren().setAll(menu);
    }

    @FXML
    void SaveMenu() throws IOException{
        AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        PausePage.getChildren().setAll(menu);
    }

}
