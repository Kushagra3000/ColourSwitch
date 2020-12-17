import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public abstract class GameElements  {
    abstract void MoveDown(double length);
    public static MediaPlayer mediaPlayer;

    public static void addMusic(String MusicName) {
        Media sound = new Media(GameElements.class.getResource(MusicName).toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }
}
