import java.io.Serializable;
import java.util.ArrayList;

public class GameDetailsTable implements Serializable {
    ArrayList<GameDetails> table;
    static int highScore;

    GameDetailsTable(){
        table = new ArrayList<>();
        highScore = 0;
    }
}
