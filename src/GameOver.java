import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GameOver {
    @FXML
    private AnchorPane gameOverPage;

    @FXML
    void returnTomenu() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        gameOverPage.getChildren().setAll(pane);
    }

    @FXML
    void revive() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        gameOverPage.getChildren().setAll(pane);
    }

    @FXML
    void restart() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        gameOverPage.getChildren().setAll(pane);
    }

}