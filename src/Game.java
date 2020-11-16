import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Game implements Initializable {

//    Game(){
//        System.out.println("New try");
//    }

    
    @FXML
    private AnchorPane menuPage;

    @FXML
    private AnchorPane LoadGameRoot;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

// TO COMBINE MENUPAGE CONTROLLER AND LOAD GAME PAGE CONTROLLER