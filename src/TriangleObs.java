import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TriangleObs extends Obstacles {

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line4;

    Rotate r1 = new Rotate();
    Rotate r2 = new Rotate();
    Rotate r3 = new Rotate();
    Rotate r4 = new Rotate();

    @FXML
    private void initialize(){
        r1.setPivotX(-20);
        r1.setPivotY(5);
        line1.getTransforms().add(r1);

        r2.setPivotX(-20);
        r2.setPivotY(5);
        line2.getTransforms().add(r2);

        r3.setPivotX(-90);
        r3.setPivotY(110);
        line3.getTransforms().add(r3);

        r4.setPivotX(-80);
        r4.setPivotY(-48);
        line4.getTransforms().add(r4);

        addRota(r1);
        addRota(r2);
        addRota(r3);
        addRota(r4);
    }

    private void addRota(Rotate rotation){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(rotation.angleProperty(), 36000)));
        timeline.play();
    }

    @Override
    boolean cannotPass(Ball playingBall) {
        return false;
    }
}
