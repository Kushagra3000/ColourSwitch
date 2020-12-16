import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;

public class GameRound implements Serializable {
    @FXML
    public ImageView hand;
    @FXML
    ImageView LevelLine;
    @FXML
    public AnchorPane centre;
    AnimationTimer timer;
    @FXML
    public  Label score;

    @FXML
    private AnchorPane gameplay;

    @FXML
    private ImageView Gmo;

    public ColourSwitchingBall cball;

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

            FXMLLoader load5 = new FXMLLoader(getClass().getResource("colourSwitching.fxml"));
            AnchorPane pane9 = load5.load();
            cball=load5.getController();

            ResetObstacle();

            pane4.setVisible(true);
            //Gmo.setVisible(false);
            gameplay.getChildren().addAll(pane3);
            gameplay.getChildren().addAll(pane4);
            gameplay.getChildren().addAll(pane5);
            gameplay.getChildren().addAll(pane6);
            gameplay.getChildren().addAll(pane7);
            gameplay.getChildren().addAll(pane8);
            gameplay.getChildren().addAll(pane9);


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
    void pauseMenu() throws IOException, ClassNotFoundException {
        timer.stop();
        serialize();
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
            star.star2.setLayoutY(-200);
            points++;
            score.setText(points +"");
        }

        if(PlayingBall.ball.getBoundsInParent().intersects(cball.colourball.getBoundsInParent())) {
            Color [] arr= new Color[4];
            arr[0]=Color.valueOf("#900dff");
            arr[1]=Color.valueOf("#32dbf0");
            arr[2]= Color.valueOf("#fae100");
            arr[3]=Color.valueOf("#ff0181");

            Random rr= new Random();
            int a= rr.nextInt(4);

            PlayingBall.ball.setFill(arr[a]);
            cball.colourball.setLayoutY(-700);
        }


        if(PlayingBall.ball.getLayoutY()-50 >= 550){
            //timer.stop();
            //gameOver();
        }

//        if(sqrObs.cannotPass(PlayingBall)){
//            System.out.println("Game Should be Over 1");
//            Gmo.setVisible(true);
//            gameOver();
//        }
//
//        if(circleObs.cannotPass(PlayingBall)){
//            System.out.println("Game Should be Over 2");
//            Gmo.setVisible(true);
//            gameOver();
//        }

//        if(triangleObs.cannotPass(PlayingBall)){
//            System.out.println("Game Should be Over 3");
//            Gmo.setVisible(true);
//            gameOver();
//        }

//        if(lineObs.cannotPass(PlayingBall)){
//            System.out.println("Game Should be Over 4");
//            Gmo.setVisible(true);
//            gameOver();
//        }

        if (t > 2) {
            t = 0;
        }

    }
    void MoveLine()
    {
        System.out.println("in Linen");
        double l=LevelLine.getLayoutY();
        double m= hand.getLayoutY();
        LevelLine.setLayoutY(++l);
        hand.setLayoutY(++m);
        if(LevelLine.getLayoutY()>750)
        {
            LevelLine.setLayoutY(-2000);
        }

    }

    void ObstacleHandle(){
        if(PlayingBall.ball.getLayoutY()<400){
            sqrObs.MoveDown(temp);
            triangleObs.MoveDown(temp);
            circleObs.MoveDown(temp);
            lineObs.MoveDown(temp);
            cball.moveDown();
            star.moveDown();
            MoveLine();
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

    void ElementLoader( GameDetails gd){
        sqrObs.line1.setLayoutY(gd.obsLocation.get(0));
        sqrObs.line2.setLayoutY(gd.obsLocation.get(0));
        sqrObs.line3.setLayoutY(gd.obsLocation.get(0));
        sqrObs.line4.setLayoutY(gd.obsLocation.get(0));

        triangleObs.line1.setLayoutY(gd.obsLocation.get(1));
        triangleObs.line2.setLayoutY(gd.obsLocation.get(1));
        triangleObs.line3.setLayoutY(gd.obsLocation.get(1));

        circleObs.arc1.setLayoutY(gd.obsLocation.get(2));
        circleObs.arc2.setLayoutY(gd.obsLocation.get(2));
        circleObs.arc3.setLayoutY(gd.obsLocation.get(2));
        circleObs.arc4.setLayoutY(gd.obsLocation.get(2));

        lineObs.line1.setLayoutY(gd.obsLocation.get(3));
        lineObs.line2.setLayoutY(gd.obsLocation.get(3));
        lineObs.line3.setLayoutY(gd.obsLocation.get(3));
        lineObs.line4.setLayoutY(gd.obsLocation.get(3));

        star.star2.setLayoutY(gd.star);
        PlayingBall.ball.setLayoutY(gd.Pball);
        cball.colourball.setLayoutY(gd.Cball);
        score.setText("" + gd.Score);
    }

    void serialize() throws IOException, ClassNotFoundException {
        ArrayList<Double> locations = new ArrayList<>();
        locations.add(sqrObs.line1.getLayoutY());
        locations.add(triangleObs.line1.getLayoutY());
        locations.add(circleObs.arc1.getLayoutY());
        locations.add(lineObs.line1.getLayoutY());
        //PlayingBall.ball.setLayoutY(6000);

        GameDetails gd = new GameDetails(locations,star.star2.getLayoutY(),cball.colourball.getLayoutY(),PlayingBall.ball.getLayoutY(), points, "#fae100");
        ObjectInputStream tbl = null;
        GameDetailsTable gdt;
        try{
            tbl = new ObjectInputStream(new FileInputStream("GameDetailsTable.txt"));
            gdt = (GameDetailsTable) tbl.readObject();
        }
        finally {
            tbl.close();
        }

        gdt.table.add(gd);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("GameDetailsTable.txt"))) {
            out.writeObject(gdt);
        }
    }

    public void deserialize(int pos) throws IOException, ClassNotFoundException {
        ObjectInputStream tbl = null;
        GameDetailsTable gdt;
        GameDetails gd;
        try{
            tbl = new ObjectInputStream(new FileInputStream("GameDetailsTable.txt"));
            gdt = (GameDetailsTable) tbl.readObject();
        }
        finally {
            tbl.close();
        }

        if(pos == -1){
            gd = gdt.table.get(gdt.table.size() - 1);
        }

        else{
            gd = gdt.table.get(pos);
        }

        System.out.println("del");
        gdt.table.remove(gd);
        System.out.println(gdt.table);
        System.out.println(gdt.table.size());
        ElementLoader(gd);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("GameDetailsTable.txt"))) {
            out.writeObject(gdt);
        }
    }
}