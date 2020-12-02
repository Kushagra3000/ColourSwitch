import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
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
    private AnchorPane LoadGameRoot;

    @FXML
    private ImageView loadBtn;

    @FXML
    void loadGame(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("LoadGamePage.fxml"));
        menuPage.getChildren().setAll(pane);
    }

    @FXML
    void startNewGame(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        menuPage.getChildren().setAll(pane);
    }

    @FXML
    void ExitGame(MouseEvent event){
        System.exit(0);
    }

    @FXML
    void backToMenu() throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        LoadGameRoot.getChildren().setAll(pane);
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
//        RotateTransition tr = new RotateTransition(Duration.seconds(10),c1);
//        tr.setByAngle(180);
//        RotateTransition tr2 = new RotateTransition(Duration.seconds(1),c1);
//        tr2.setFromAngle(0);
//        tr2.setByAngle(180);
//        tr.play();
//        tr.setOnFinished(actionEvent -> tr2.play());
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

}

// TO COMBINE MENUPAGE CONTROLLER AND LOAD GAME PAGE CONTROLLER