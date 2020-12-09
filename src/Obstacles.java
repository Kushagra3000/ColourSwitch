public abstract class Obstacles extends GameElements  {

    static boolean wait = false;
    abstract boolean cannotPass(Ball playingBall);
    abstract void MoveDown(double length);
    abstract void MoveToFrame();
}
