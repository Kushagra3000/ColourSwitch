import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class GameOver implements Initializable {

    @FXML
    public Label currentscore;

    @FXML
    public Label usedstar;

    @FXML
    public Label highscore;

    @FXML
    public ImageView Message;
    public Label dm;

    @FXML
    private AnchorPane gameOverPage;

    static int Cscore;
    static int Hscore = 0;
    static int Uscore = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Message.setVisible(false);
        dm.setVisible(false);
        currentscore.setText(Cscore + "");
        usedstar.setText(Uscore + "");
        highscore.setText(Hscore + "");
        if(Cscore < Uscore)
            Message.setVisible(true);
    }

    @FXML
    void returnTomenu() throws IOException, ClassNotFoundException {
        GameElements.addMusic("audios/button.wav");
        ObjectInputStream tbl = null;
        GameDetailsTable gdt;
        GameDetails gd;
        try{
            tbl = new ObjectInputStream(new FileInputStream("GameDetailsTable.txt"));
            gdt = (GameDetailsTable) tbl.readObject();
        }
        finally {
            tbl.close();
        }
        gd = gdt.table.get(gdt.table.size() - 1);
        gdt.table.remove(gd);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("GameDetailsTable.txt"))) {
            out.writeObject(gdt);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        gameOverPage.getChildren().setAll(pane);
        System.out.println("GOING MENU");
    }

    @FXML
    void revive() throws IOException, ClassNotFoundException, InterruptedException {
        if(Cscore >= Uscore){
            GameElements.addMusic("audios/button.wav");
            FXMLLoader gameRound = new FXMLLoader(getClass().getResource("GamePlayPage.fxml"));
            AnchorPane setGame = gameRound.load();
            GameRound GR = gameRound.getController();
            gameOverPage.getChildren().setAll(setGame);
            GR.deserialize(-1);
            return;
        }

        System.out.println("STUCK HERE");
        //Message.setVisible(true);
        //TimeUnit.SECONDS.sleep(2);
        returnTomenu();
    }

    @FXML
    void restart() throws IOException, ClassNotFoundException {
        GameElements.addMusic("audios/button.wav");
        ObjectInputStream tbl = null;
        GameDetailsTable gdt;
        GameDetails gd;
        try{
            tbl = new ObjectInputStream(new FileInputStream("GameDetailsTable.txt"));
            gdt = (GameDetailsTable) tbl.readObject();
        }
        finally {
            tbl.close();
        }
        gd = gdt.table.get(gdt.table.size() - 1);
        gdt.table.remove(gd);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("GameDetailsTable.txt"))) {
            out.writeObject(gdt);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        gameOverPage.getChildren().setAll(pane);
    }
}