import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class LineObs extends Obstacles {

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line4;


    @FXML
    private void initialize(){
        addMotion(line1, -150, 1000);
        addMotion(line2, 150, 1000);
        addMotion(line3,150, 1000);
        addMotion(line4,450, 2000);
    }

    private void addMotion(Line line, int side, int time){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(time),
                new KeyValue(line.layoutXProperty(), line.getLayoutX() + side)));
        timeline.setCycleCount(600);
        timeline.setAutoReverse(true);
        timeline.play();
    }

}
