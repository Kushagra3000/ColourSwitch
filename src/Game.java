import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Game implements Initializable {
    @FXML
    public ImageView c3;

    @FXML
    public ImageView c2;

    @FXML
    public ImageView c1;

    @FXML
    private AnchorPane menuPage;

    @FXML
    void loadGame(MouseEvent event) throws IOException {
        GameElements.addMusic("audios/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("LoadGamePage.fxml"));
        menuPage.getChildren().setAll(pane);
    }

    @FXML
    void startNewGame(MouseEvent event) throws IOException {
        GameElements.addMusic("audios/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        menuPage.getChildren().setAll(pane);
    }

    @FXML
    void ExitGame(MouseEvent event){
        GameElements.addMusic("audios/button.wav");
        System.exit(0);
    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        setRotate(c1, 360,10);
        setRotate(c2, -360,18);
        setRotate(c3, 360,24);
    }

    private void setRotate(ImageView img, int ang, int duration){
        RotateTransition rt = new RotateTransition(Duration.seconds(duration),img);
        rt.setByAngle(ang);
        rt.setAutoReverse(false);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(20);
        rt.play();
    }

    public void showinstruction(MouseEvent mouseEvent) throws IOException {
        GameElements.addMusic("audios/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Instruction.fxml"));
        menuPage.getChildren().setAll(pane);
        
    }

    public void ShowSetting(MouseEvent mouseEvent) {
    }
}