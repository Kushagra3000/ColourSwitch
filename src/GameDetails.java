import javafx.scene.paint.Color;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GameDetails implements Serializable {

    ArrayList<Double> obsLocation;
    double star;
    double specStar;
    double Cball;
    double Pball;
    double hand;
    double LevelLine;
    int Score;
    int color;
    String time;
    int CostS;
    int level;

    GameDetails(ArrayList<Double> o, double s, double c, double p, int Score, double l, double h,int color,int co, double spst,int le){
        this.obsLocation = o;
        this.star = s;
        this.Cball = c;
        this.Pball = p;
        this.Score = Score;
        this.color = color;
        this.hand = h;
        this.LevelLine = l;
        this.time = new SimpleDateFormat(" yyyy.MM.dd   HH.mm.ss").format(new java.util.Date());
        this.CostS = co;
        this.specStar = spst;
        this.level = le;
    }
}
