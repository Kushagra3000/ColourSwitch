import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleObs extends Obstacles implements ActionListener {

    @FXML
    public  Arc arc1;

    @FXML
    public Arc arc2;

    @FXML
    public Arc arc3;

    @FXML
    public Arc arc4;

    @FXML
    public Circle innerpart;

    public static Bounds a1,a2,a3,a4;

    @FXML
    public void initialize() {
        Timeline animation = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(6), new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(6), new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(6), new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(6), new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle() - 360, Interpolator.LINEAR))
        );

        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();


    }



    public void actionPerformed(ActionEvent e){
        a1 = arc1.getBoundsInLocal();
        a2 = arc2.getBoundsInLocal();
        a3 = arc3.getBoundsInLocal();
        a4 = arc4.getBoundsInLocal();
    }

    @Override
    boolean cannotPass(Ball playingBall){
        if(playingBall.ball.getFill().equals(arc1.getStroke())){
            if(arc2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
                return true;
            if(arc3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            if(arc4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }

        if(playingBall.ball.getFill().equals(arc2.getStroke())){
            if(arc1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
                return true;
            if(arc3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            if(arc4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }

        if(playingBall.ball.getFill().equals(arc3.getStroke())){
            if(arc1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
                return true;
            if(arc2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            if(arc4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }

        else {
            if(arc1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
                return true;
            if(arc2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            if(arc3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()) && !innerpart.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }
    }

    @Override
    void MoveDown(double length) {
        length = arc1.getLayoutY();
        if(length > 750)
            length = -1500;
        length++;
        arc1.setLayoutY(length);
        arc2.setLayoutY(length);
        arc3.setLayoutY(length);
        arc4.setLayoutY(length);
        innerpart.setLayoutY(length);

    }

    @Override
    void MoveToFrame() {
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(arc1.layoutYProperty(), 209)));
        t1.setCycleCount(1);
        t1.play();

        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(arc2.layoutYProperty(), 209)));
        t2.setCycleCount(1);
        t2.play();

        Timeline t3 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(arc3.layoutYProperty(), 209)));
        t3.setCycleCount(1);
        t3.play();

        Timeline t4 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(arc4.layoutYProperty(), 209)));
        t4.setCycleCount(1);
        t4.play();

        Obstacles.wait = false;
    }


}