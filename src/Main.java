import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
    public static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        addMusic();
        Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(new Scene(root, 1024, 600));
        primaryStage.show();
    }

    public static void addMusic() {
        Media sound = new Media(Main.class.getResource("audios/background.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(50));
        mediaPlayer.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
