import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Stars extends GameElements{

    @FXML
    public ImageView star2;
    void MoveDown(double lengt){
        double length=star2.getLayoutY();
        if(length>750)
        {
            length=-250;
        }
        length++;
        star2.setLayoutY(length);

    }

}