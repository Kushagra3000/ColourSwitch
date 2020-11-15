import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuPageController {

    @FXML
    private AnchorPane menuPage;

    void NewGame(MouseEvent event){

    }

    @FXML
    void loadGame(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("LoadGamePage.fxml"));
        menuPage.getChildren().setAll(pane);
    }

    @FXML
    void startNewGame(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        menuPage.getChildren().setAll(pane);
    }

    @FXML
    void ExitGame(MouseEvent event){
        System.exit(0);
    }
}

// TO COMBINE MENUPAGE CONTROLLER AND LOAD GAME PAGE CONTROLLER