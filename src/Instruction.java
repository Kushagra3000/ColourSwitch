import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Instruction
{
    public AnchorPane Ins;
    //public ImageView homeBut;


    public void BackHome(MouseEvent mouseEvent) throws IOException {
        GameElements.addMusic("audios/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        Ins.getChildren().setAll(pane);
    }
}
