import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

import java.io.IOException;
import java.util.Random;
//AnimationTimer timer;


public class GameRound {
    @FXML
    private Arc arc1;

    @FXML
    private Arc arc2;

    @FXML
    private Arc arc3;

    @FXML
    private Arc arc4;

    AnimationTimer timer;
    @FXML
    public  Label score;

    @FXML
    private AnchorPane gameplay;

    @FXML
    private ImageView pauseimg;

    @FXML
    private AnchorPane pause;

    static boolean now = true ;

    private double t=0;
    AnchorPane pane4 ;

    @FXML
    private void initialize(){
        try {
            AnchorPane pane3 = FXMLLoader.load(getClass().getResource("playBall.fxml"));
             pane4 = FXMLLoader.load(getClass().getResource("stars.fxml"));

            Random random = new Random();
            int obs = random.nextInt(4)+1;

            AnchorPane pane5;
            if(obs == 1)
                pane5 = FXMLLoader.load(getClass().getResource("TriangleObs.fxml"));


            else if(obs == 2)
                pane5 = FXMLLoader.load(getClass().getResource("circleObs.fxml"));

            else if(obs == 3)
                pane5 = FXMLLoader.load(getClass().getResource("squareObs.fxml"));

            else
                pane5 = FXMLLoader.load(getClass().getResource("lineObs.fxml"));

            if(now) {
                gameplay.getChildren().addAll(pane3);
                gameplay.getChildren().addAll(pane4);
                gameplay.getChildren().addAll(pane5);
            }

            if(!now){
                gameplay.getChildren().removeAll(pane3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         timer = new AnimationTimer() {@Override
            public void handle(long now) {
            try {
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
        now = false;
        Pane pausePane = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        gameplay.getChildren().setAll(pausePane);
    }

    @FXML
    void ResumeGame() throws IOException {
        now = true;
        AnchorPane pausePane = FXMLLoader.load(getClass().getResource("GamePlayPage.fxml"));
        gameplay.getChildren().setAll(pausePane);
    }
    private void update() throws IOException {
        t =+0.016;


        //System.out.println(ball.getLayoutY());
        if(Ball.posy<=222)
        {
            System.out.println("inntersect");
            Ball.points=+1;
            score.setText(Ball.points+"");

            gameplay.getChildren().removeAll(pane4);
        }
        if(Ball.posy>=550)
        {
            System.out.println("gam over");
            timer.stop();
            Ball.posy=500;
            gameOver();
        }

        if (t > 2) {
            t = 0;
        }
    }




    @FXML
    void backToMenu() throws IOException {
        AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        gameplay.getChildren().setAll(menu);
    }

    @FXML
    void SaveMenu() throws IOException{
        AnchorPane menu = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        gameplay.getChildren().setAll(menu);
    }

    @FXML
    void gameOver() throws IOException {
        AnchorPane over  = FXMLLoader.load(getClass().getResource("GameOverPage.fxml"));
        gameplay.getChildren().setAll(over);
    }
}
