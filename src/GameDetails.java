import javafx.scene.paint.Color;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GameDetails implements Serializable {

    ArrayList<Double> obsLocation;
    double star;
    double Cball;
    double Pball;
    int Score;
    String color;
    String time;

    GameDetails(ArrayList<Double> o, double s, double c, double p, int Score, String color){
        this.obsLocation = o;
        this.star = s;
        this.Cball = c;
        this.Pball = p;
        this.Score = Score;
        this.color = color;
        this.time = new SimpleDateFormat(" yyyy.MM.dd   HH.mm.ss ").format(new java.util.Date());
    }
}
