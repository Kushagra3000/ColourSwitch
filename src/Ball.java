import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.event.ActionListener;
import java.io.IOException;

public class Ball implements ActionListener {
    static double posy=500;
    static double posx = 500;
    @FXML
    public  Circle ball;

   public static Bounds bound;

    @FXML
    private AnchorPane root;



    @FXML
    private void initialize(){
    }

    @FXML
    private void jumpBall(ActionEvent k) throws IOException {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
                    new KeyValue(ball.layoutYProperty(), ball.getLayoutY() - 50)));
            posy=ball.getLayoutY()-50;
            posx= ball.getLayoutX();
            bound= ball.getBoundsInParent();

            timeline.setCycleCount(1);
            Timeline t2 = new Timeline(new KeyFrame(Duration.millis(1100),
                    new KeyValue(ball.layoutYProperty(), 600)));

            t2.setCycleCount(1);
            timeline.play();
            timeline.setOnFinished(actionEvent -> t2.play());
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
        bound = ball.getBoundsInLocal();
    }
}
