import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Stars {

    @FXML
    public ImageView star2;
    void moveDown()
    {
        double length=star2.getLayoutY();
        if(length>750)
        {
            length=-200;
        }
        length++;
        star2.setLayoutY(length);

    }

}