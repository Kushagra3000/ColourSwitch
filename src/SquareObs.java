import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class SquareObs extends Obstacles {

    @FXML
    public Line line1;

    @FXML
    public Line line2;

    @FXML
    public Line line3;

    @FXML
    public Line line4;

    @FXML
    public Polygon inside;

    Rotate r1 = new Rotate();
    Rotate r2 = new Rotate();
    Rotate r3 = new Rotate();
    Rotate r4 = new Rotate();
    Rotate r5 = new Rotate();
    double time;

    @FXML
    private void initialize() {
        time=1000;
        line1.setLayoutY(-200);
        line2.setLayoutY(-200);
        line3.setLayoutY(-200);
        line4.setLayoutY(-200);

        r1.setPivotX(51);
        r1.setPivotY(51);
        line1.getTransforms().add(r1);

        r2.setPivotX(51);
        r2.setPivotY(51);
        line2.getTransforms().add(r2);

        r3.setPivotX(51);
        r3.setPivotY(51);
        line3.getTransforms().add(r3);

        r4.setPivotX(51);
        r4.setPivotY(51);
        line4.getTransforms().add(r4);

        r5.setPivotX(51);
        r5.setPivotY(51);
        inside.getTransforms().add(r5);

        addRota(r1,time);
        addRota(r2,time);
        addRota(r3,time);
        addRota(r4,time);
        addRota(r5,time);
    }

    private void addRota(Rotate rotation,double t) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(t), new KeyValue(rotation.angleProperty(), 36000)));
        timeline.play();
    }

    @Override
    boolean cannotPass(Ball playingBall) {

        if(line1.getStroke().equals(playingBall.ball.getFill())) {
            if(line2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }

            if(line4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }

        if(line2.getStroke().equals(playingBall.ball.getFill())) {

            if(line1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            if(line4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
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
            if(line4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }else
                return false;
        }

        else{

            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }

            if(line2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }

            if(line1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !inside.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            else

                return false;
        }
    }

    @Override
    void MoveDown(double length) {

//        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(600),
//                new KeyValue(line1.layoutYProperty(), 800)));
//        t1.setCycleCount(1);
//        t1.play();
//
//        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
//                new KeyValue(line2.layoutYProperty(), 800)));
//        t2.setCycleCount(1);
//        t2.play();
//
//        Timeline t3 = new Timeline(new KeyFrame(Duration.millis(600),
//                new KeyValue(line3.layoutYProperty(), 800)));
//        t3.setCycleCount(1);
//        t3.play();
//
//        Timeline t4 = new Timeline(new KeyFrame(Duration.millis(600),
//                new KeyValue(line4.layoutYProperty(), 800)));
//        t4.setCycleCount(1);
//        t4.play();
        length = line1.getLayoutY();
        if(length > 750)
            length = -1400;
        length++;
        line1.setLayoutY(length);
        line2.setLayoutY(length);
        line3.setLayoutY(length);
        line4.setLayoutY(length);
        inside.setLayoutY(length);
    }

    @Override
    void MoveToFrame() {
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(line1.layoutYProperty(), 124)));
        t1.setCycleCount(1);
        t1.play();

        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(line2.layoutYProperty(), 139)));
        t2.setCycleCount(1);
        t2.play();

        Timeline t3 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(line3.layoutYProperty(), 254)));
        t3.setCycleCount(1);
        t3.play();

        Timeline t4 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(line4.layoutYProperty(), 239)));
        t4.setCycleCount(1);
        t4.play();
        Obstacles.wait = false;
    }


}
