import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameRound {
    @FXML
    private AnchorPane gameplay;

    @FXML
    private ImageView pauseimg;

    @FXML
    private AnchorPane pause;

    static boolean now = true ;

    //private Pause pause;
    @FXML
    private Circle ball;

    @FXML
    private void initialize(){
        try {
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("squareObs.fxml"));
            AnchorPane pane3 = FXMLLoader.load(getClass().getResource("playBall.fxml"));
            AnchorPane pane4 = FXMLLoader.load(getClass().getResource("stars.fxml"));
            if(now) {
                gameplay.getChildren().addAll(pane2);
                gameplay.getChildren().addAll(pane3);
                gameplay.getChildren().addAll(pane4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void pauseMenu() throws IOException {
        now = false;
        Pane pausePane = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        gameplay.getChildren().addAll(pausePane);
    }

    @FXML
    void ResumeGame() throws IOException {
        now = true;
        AnchorPane pausePane = FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        gameplay.getChildren().setAll(pausePane);
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
        gameplay.getChildren().addAll(over);
    }

}
