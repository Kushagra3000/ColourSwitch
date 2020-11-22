import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;

public class Ball extends GameElements {

    @FXML
    private Circle ball;

    @FXML
    private AnchorPane root;

    @FXML
    private void initialize(){

    }

    @FXML
    private void jumpBall(ActionEvent k) throws IOException {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
                    new KeyValue(ball.layoutYProperty(), ball.getLayoutY() - 50)));
            timeline.setCycleCount(1);
            Timeline t2 = new Timeline(new KeyFrame(Duration.millis(1100),
                    new KeyValue(ball.layoutYProperty(), 700)));
            t2.setCycleCount(1);
            timeline.play();
            timeline.setOnFinished(actionEvent -> t2.play());
    }
}
