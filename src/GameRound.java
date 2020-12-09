import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.Random;

public class GameRound {

    @FXML
    public AnchorPane centre;
    AnimationTimer timer;
    @FXML
    public  Label score;

    @FXML
    private AnchorPane gameplay;

    @FXML
    private ImageView Gmo;

    private double t=0;
    AnchorPane pane4 ;
    AnchorPane pane5;
    Stars  star;
    Obstacles obstacle;
    SquareObs sqrObs;
    CircleObs circleObs;
    TriangleObs triangleObs;
    LineObs lineObs;
    Ball PlayingBall;
    int points;
    double temp;

    @FXML
    private void initialize(){
        try {
            FXMLLoader loadBall = new FXMLLoader(getClass().getResource("playBall.fxml"));
            AnchorPane pane3 = loadBall.load();
            PlayingBall = loadBall.getController();
            FXMLLoader load2 = new FXMLLoader(getClass().getResource("stars.fxml"));
            pane4=load2.load();
            star=load2.getController();
            Random random = new Random();
            //int obs = random.nextInt(4)+1;
            int obs = 2;
            FXMLLoader load = new FXMLLoader(getClass().getResource("LineObs.fxml"));
            pane5 = load.load();
            obstacle = load.getController();
            lineObs = load.getController();

            FXMLLoader load1 = new FXMLLoader(getClass().getResource("circleObs.fxml"));
            AnchorPane pane6 = load1.load();
            obstacle = load1.getController();
            circleObs = load1.getController();

            FXMLLoader load3 = new FXMLLoader(getClass().getResource("SquareObs.fxml"));
            AnchorPane pane7 = load3.load();
            obstacle = load.getController();
            sqrObs = load3.getController();

            FXMLLoader load4 = new FXMLLoader(getClass().getResource("TriangleObs.fxml"));
            AnchorPane pane8 = load4.load();
            triangleObs = load4.getController();

            ResetObstacle();

            pane4.setVisible(true);
            Gmo.setVisible(false);
            gameplay.getChildren().addAll(pane3);
            gameplay.getChildren().addAll(pane4);
            gameplay.getChildren().addAll(pane5);
            gameplay.getChildren().addAll(pane6);
            gameplay.getChildren().addAll(pane7);
            gameplay.getChildren().addAll(pane8);


        } catch (IOException e) {
            e.printStackTrace();
        }

         timer = new AnimationTimer() {@Override
            public void handle(long now) {
            try {
                ObstacleHandle();
                update();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        };
        timer.start();

    }

    @FXML
    void pauseMenu() throws IOException {
        Pane pausePane = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        gameplay.getChildren().setAll(pausePane);
    }

    @FXML
    void gameOver() throws IOException {
        AnchorPane over  = FXMLLoader.load(getClass().getResource("GameOverPage.fxml"));
        gameplay.getChildren().setAll(over);
    }

    private void update() throws IOException {
        t =+0.016;
        if(PlayingBall.ball.getBoundsInParent().intersects(star.star2.getBoundsInParent())) {
            points=+1;
            score.setText(points +"");
            gameplay.getChildren().removeAll(pane4);
            pane4.setVisible(false);
        }

        if(PlayingBall.ball.getLayoutY()-50 >= 550){
            timer.stop();
            Ball.posy=500;
            gameOver();
        }

        if(sqrObs.cannotPass(PlayingBall)){
            System.out.println("Game Should be Over");
             Gmo.setVisible(true);
            gameOver();
        }

        if(circleObs.cannotPass(PlayingBall)){
            System.out.println("Game Should be Over");
            Gmo.setVisible(true);
            gameOver();
        }

        if(triangleObs.cannotPass(PlayingBall)){
            System.out.println("Game Should be Over");
            Gmo.setVisible(true);
            gameOver();
        }

        if(lineObs.cannotPass(PlayingBall)){
            System.out.println("Game Should be Over");
            Gmo.setVisible(true);
            gameOver();
        }

        if (t > 2) {
            t = 0;
        }

    }

    void ObstacleHandle(){
        if(PlayingBall.ball.getLayoutY()<400){
            sqrObs.MoveDown(temp);
            triangleObs.MoveDown(temp);
            circleObs.MoveDown(temp);
            lineObs.MoveDown(temp);
        }
    }

    void ResetObstacle(){
        temp = -200;

        sqrObs.line1.setLayoutY(-200);
        sqrObs.line2.setLayoutY(-200);
        sqrObs.line3.setLayoutY(-200);
        sqrObs.line4.setLayoutY(-200);
        sqrObs.inside.setLayoutY(-200);

        triangleObs.line1.setLayoutY(-600);
        triangleObs.line2.setLayoutY(-600);
        triangleObs.line3.setLayoutY(-600);
        triangleObs.inside.setLayoutY(-600);

        circleObs.arc1.setLayoutY(-1000);
        circleObs.arc2.setLayoutY(-1000);
        circleObs.arc3.setLayoutY(-1000);
        circleObs.arc4.setLayoutY(-1000);
        circleObs.innerpart.setLayoutY(-1000);

        lineObs.line1.setLayoutY(-1400);
        lineObs.line2.setLayoutY(-1400);
        lineObs.line3.setLayoutY(-1400);
        lineObs.line4.setLayoutY(-1400);
    }
}
