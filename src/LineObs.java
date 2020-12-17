import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;

public class LineObs extends Obstacles  {

    @FXML
    public Line line1;

    @FXML
    public Line line2;

    @FXML
    public Line line3;

    @FXML
    public Line line4;

    public int time=2000;



    @FXML
    private void initialize() {
        //System.out.println(time);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(time),
                new KeyValue(line1.layoutXProperty(), line1.getLayoutX() + 360)));
        timeline.setAutoReverse(true);
        timeline.setCycleCount(2);

        Timeline timeline1= new Timeline(new KeyFrame(Duration.millis(time),
                new KeyValue(line2.layoutXProperty(), line2.getLayoutX() + 360)));
        timeline1.setAutoReverse(true);
        timeline1.setCycleCount(2);

        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(time),
                new KeyValue(line3.layoutXProperty(), line3.getLayoutX() + 360)));
        timeline2.setAutoReverse(true);
        timeline2.setCycleCount(2);

        Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(time),
                new KeyValue(line4.layoutXProperty(), line4.getLayoutX() + 360)));
        timeline3.setAutoReverse(true);
        timeline3.setCycleCount(2);

        timeline.setOnFinished(actionEvent -> timeline1.play());
        timeline1.setOnFinished(actionEvent -> timeline2.play());
        timeline2.setOnFinished(actionEvent -> timeline3.play());
        timeline3.setOnFinished(actionEvent -> timeline.play());
        timeline.play();
    }

    @Override
    boolean cannotPass(Ball playingBall) {
        if(line1.getStroke().equals(playingBall.ball.getFill()))
        {
            if(line2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }
            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }

            if(line4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }

        if(line2.getStroke().equals(playingBall.ball.getFill()))
        {

            //System.out.println("----->>>>>>>>>>>>>>int the lin2");
            if(line1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }
            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }
            if(line4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }else
                return false;
        }
        if(line3.getStroke().equals(playingBall.ball.getFill()))
        {

            if(line1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }
            if(line2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }
            if(line4.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }else
                return false;
        }

        else
        {

            if(line3.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }

            if(line2.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
                return true;
            }

            if(line1.getBoundsInParent().intersects(playingBall.ball.getBoundsInParent()))
            {
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
        line4.setLayoutY(length);
    }

    @Override
    void MoveToFrame() {
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(line1.layoutYProperty(), 209)));
        t1.setCycleCount(1);
        t1.play();

        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(line2.layoutYProperty(), 209)));
        t2.setCycleCount(1);
        t2.play();

        Timeline t3 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(line3.layoutYProperty(), 209)));
        t3.setCycleCount(1);
        t3.play();

        Timeline t4 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(line4.layoutYProperty(), 209)));
        t4.setCycleCount(1);
        t4.play();
    }

}
