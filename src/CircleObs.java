import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CircleObs extends GameElements implements ActionListener {

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
    public void initialize() throws IOException {
        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("playBall.fxml"));
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

}
