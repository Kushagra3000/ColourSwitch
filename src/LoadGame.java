import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadGame implements Initializable {

    @FXML
    public ListView<String> GameTable;

    @FXML
    public Label empty;

    @FXML
    private AnchorPane LoadGameRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        empty.setVisible(false);
        try {
            ShowTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backToMenu() throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        LoadGameRoot.getChildren().setAll(pane);
    }

    void ShowTable() throws Exception{
        File file = new File("GameDetailsTable.txt");
        if(file.length() == 0){
            empty.setVisible(true);
            return;
        }
        GameDetailsTable gdt;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("GameDetailsTable.txt"))) {
            gdt = (GameDetailsTable) in.readObject();
            for (int i = 0; i < gdt.table.size(); i++) {
                GameTable.getItems().add((i + 1) + " Game Played On :" + gdt.table.get(i).time);
            }
        }
    }

    @FXML
    void SelectGame() throws IOException, ClassNotFoundException {
        empty.setVisible(false);
        int selectedGame = GameTable.getSelectionModel().getSelectedIndex();
        if(selectedGame == -1){
            empty.setText("SELECT A VALID SAVED GAME");
            empty.setVisible(true);
            return;
        }

        FXMLLoader Game = new FXMLLoader(getClass().getResource("GamePlayPage.fxml"));
        AnchorPane Gplay = Game.load();
        GameRound Ggame = Game.getController();
        LoadGameRoot.getChildren().setAll(Gplay);
        Ggame.deserialize(selectedGame);
    }

}
