import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class LineObs extends Obstacles  {

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

}
