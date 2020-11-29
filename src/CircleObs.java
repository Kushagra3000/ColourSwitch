import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class CircleObs extends Obstacles  {

    @FXML
    private static Arc arc1;

    @FXML
    private static Arc arc2;

    @FXML
    private static Arc arc3;

    @FXML
    private static Arc arc4;


    public  static  Arc  getArc(int r)
    {

        if(r==1)
            return arc1;


        if(r==2)
            return arc2;


        if(r==3)
            return arc3;


        else
        return arc4;
    }


    @FXML
    private void initialize() {
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

}
