import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ColourSwitchingBall {
    @FXML
    ImageView colourball;
    void moveDown()
    {
        double length=colourball.getLayoutY();
        if(length>750) {
            length=-1000;
        }
        length++;
        colourball.setLayoutY(length);
    }

}