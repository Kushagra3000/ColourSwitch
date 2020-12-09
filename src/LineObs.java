import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class LineObs extends Obstacles  {

    @FXML
    public Line line1;

    @FXML
    public Line line2;

    @FXML
    public Line line3;

    @FXML
    public Line line4;


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

    @Override
    boolean cannotPass(Ball playingBall) {

        // System.out.println("in triangle");
        //System.out.println(line3.getStroke());
        //System.out.println(playingBall.ball.getFill());
        if(line1.getStroke().equals(playingBall.ball.getFill()))
        {
            //  System.out.println("----->>>>>>>>>>>>>>int the lin1");
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

            //System.out.println("in line 3" );
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

            ///System.out.println("----->>>>>>>>>>>>>>int the lin4");
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
//                new KeyValue(line1.layoutYProperty(), 800)));
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
