import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Pause {

    private GameRound currGame;

//    Pause(GameRound game){
//        currGame = game;
//    }


    //@FXML
 //   void SaveMenu() throws IOException{
   //     AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
       // gameplay.getChildren().setAll(menu);
   // }
    void resumeGame() throws IOException {
        currGame.ResumeGame();
    }

    void SaveGame(){

    }

    void BackToMenu(){}


}
