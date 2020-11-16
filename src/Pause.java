import java.io.IOException;

public class Pause {

    private GameRound currGame;

//    Pause(GameRound game){
//        currGame = game;
//    }

    void resumeGame() throws IOException {
        currGame.ResumeGame();
    }

    void SaveGame(){

    }

    void BackToMenu(){}


}
