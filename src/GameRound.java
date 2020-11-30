import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Random;
//AnimationTimer timer;


public class GameRound {
    AnimationTimer timer;
    @FXML
    public  Label score;

    @FXML
    private AnchorPane gameplay;

    @FXML
    private ImageView pauseimg;

    @FXML
    private AnchorPane pause;

    @FXML
    private ImageView Gmo;

    static boolean now = true ;

    private double t=0;
    AnchorPane pane4 ;
    AnchorPane pane5;
    CircleObs con;
    Ball PlayingBall;

    @FXML
    private void initialize(){
        try {
            //AnchorPane pane3 = FXMLLoader.load(getClass().getResource("playBall.fxml"));
            FXMLLoader loadBall = new FXMLLoader(getClass().getResource("playBall.fxml"));
            AnchorPane pane3 = loadBall.load();
            PlayingBall = loadBall.getController();
            pane4 = FXMLLoader.load(getClass().getResource("stars.fxml"));
            Random random = new Random();
            //int obs = random.nextInt(4)+1;
            int obs = 2;
            FXMLLoader load5 = new FXMLLoader(getClass().getResource("circleObs.fxml"));
            if(obs == 1)
                pane5 = FXMLLoader.load(getClass().getResource("TriangleObs.fxml"));


            else if(obs == 2) {
                //pane5 = FXMLLoader.load(getClass().getResource("circleObs.fxml"));
                pane5 = load5.load();
                con = load5.getController();
            }

            else if(obs == 3) {
                pane5 = FXMLLoader.load(getClass().getResource("squareObs.fxml"));
            }

            else {
                pane5 = FXMLLoader.load(getClass().getResource("lineObs.fxml"));
            }

            if(now) {
                pane4.setVisible(true);
                Gmo.setVisible(false);
                gameplay.getChildren().addAll(pane3);
                gameplay.getChildren().addAll(pane4);
                gameplay.getChildren().addAll(pane5);
            }

            if(!now){
                //gameplay.getChildren().removeAll(pane3);
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

    boolean checkObsCollision(int obs){
        if(obs == 4){
            if(con.arc1.getBoundsInParent().intersects(PlayingBall.ball.getBoundsInParent()) && !con.innerpart.getBoundsInParent().intersects(PlayingBall.ball.getBoundsInParent()))
                return true;
            if(con.arc2.getBoundsInParent().intersects(PlayingBall.ball.getBoundsInParent()) && !con.innerpart.getBoundsInParent().intersects(PlayingBall.ball.getBoundsInParent())){
                return true;
            }
            if(con.arc3.getBoundsInParent().intersects(PlayingBall.ball.getBoundsInParent()) && !con.innerpart.getBoundsInParent().intersects(PlayingBall.ball.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }

        else
            return false;
    }

    private void update() throws IOException {
        t =+0.016;
        if(Ball.posy<=222)
        {
            Ball.points=+1;
            score.setText(Ball.points +"");
            gameplay.getChildren().removeAll(pane4);
            pane4.setVisible(false);
        }

        if(Ball.posy>=550){
            timer.stop();
            Ball.posy=500;
            gameOver();
        }

        if(checkObsCollision(4)){
            System.out.println("Game Should be Over");
            Gmo.setVisible(true);
        }

        if (t > 2) {
            t = 0;
        }
    }
}
