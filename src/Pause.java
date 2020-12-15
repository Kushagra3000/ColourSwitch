import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class Pause {

    @FXML
    public AnchorPane PausePage;

    @FXML
    void ResumeGame() throws IOException, ClassNotFoundException {

        FXMLLoader gameRound = new FXMLLoader(getClass().getResource("GamePlayPage.fxml"));
        AnchorPane setGame = gameRound.load();
        GameRound GR = gameRound.getController();
        PausePage.getChildren().setAll(setGame);
        GR.deserialize(-1);
    }

    @FXML
    void backToMenu() throws IOException, ClassNotFoundException {

        FXMLLoader gameRound = new FXMLLoader(getClass().getResource("GamePlayPage.fxml"));
        AnchorPane setGame = gameRound.load();
        GameRound GR = gameRound.getController();
        GR.deserialize(-1);

        AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        PausePage.getChildren().setAll(menu);
    }

    @FXML
    void SaveMenu() throws IOException {
        AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        PausePage.getChildren().setAll(menu);
    }



}
