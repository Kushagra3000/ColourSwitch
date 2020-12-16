import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TriangleObs extends Obstacles {

    @FXML
    public Line line1;

    @FXML
    public Line line2;

    @FXML
    public Line line3;

    @FXML
    public Polygon inside;

    Rotate r1 = new Rotate();
    Rotate r2 = new Rotate();
    Rotate r3 = new Rotate();
    Rotate r4 = new Rotate();

    @FXML
    private void initialize(){
        r1.setPivotX(100);
        r1.setPivotY(70);
        line1.getTransforms().add(r1);

        r2.setPivotX(100);
        r2.setPivotY(70);
        line2.getTransforms().add(r2);

        r3.setPivotX(100);
        r3.setPivotY(70);
        line3.getTransforms().add(r3);

        r4.setPivotX(100);
        r4.setPivotY(70);
        inside.getTransforms().add(r4);

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
    boolean cannotPass(Ball playingBall){

        if(line1.getStroke().equals(playingBall.ball.getFill())){
            System.out.println("IN tri line1");
            if(line2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }
            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }

            else
                return false;
        }

        if(line2.getStroke().equals(playingBall.ball.getFill()))
        {

            if(line1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }
            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }

            else
                return false;
        }
        if(line3.getStroke().equals(playingBall.ball.getFill())){

            if(line1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }
            if(line2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }

            else
                return false;
        }

        else {
            line1.setStroke(playingBall.ball.getFill());
            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }

            if(line2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())) {
                return true;
            }

            else
                return false;
        }
    }

    @Override
    void MoveDown(double length) {
        length = line1.getLayoutY();
        if(length > 750)
            length = -1500;
        length++;
        line1.setLayoutY(length);
        line2.setLayoutY(length);
        line3.setLayoutY(length);
        inside.setLayoutY(length);
    }

    @Override
    void MoveToFrame() {

    }
}
