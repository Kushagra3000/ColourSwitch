import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ColourSwitchingBall extends GameElements {
    @FXML
    ImageView colourball;
    void MoveDown(double lengt) {
        double length=colourball.getLayoutY();
        if(length>750) {
            length=-1000;
        }
        length++;
        colourball.setLayoutY(length);
    }

}