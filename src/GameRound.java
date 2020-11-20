import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameRound {
    @FXML
    private AnchorPane gameplay;

    //private Pause pause;

    @FXML
    private void initialize(){
        try {
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("squareObs.fxml"));
            gameplay.getChildren().addAll(pane2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pauseMenu() throws IOException {
        AnchorPane pausePane = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        gameplay.getChildren().add(pausePane);
    }

    @FXML
    void ResumeGame() throws IOException {
        AnchorPane pausePane = FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        gameplay.getChildren().setAll(pausePane);
        //gameplay.getChildren();
    }

    @FXML
    void backToMenu() throws IOException {
        AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        gameplay.getChildren().setAll(menu);
    }

    @FXML
    void SaveMenu() throws IOException{
        AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        gameplay.getChildren().setAll(menu);
    }

    @FXML
    void gameOver() throws IOException {
        AnchorPane over  = FXMLLoader.load(getClass().getResource("GameOverPage.fxml"));
        gameplay.getChildren().setAll(over);
    }
}
