package my.game.logic;

public class gameCore {
    public static boolean isGreenLight = true;

    public static boolean isPlayerOut(int speed){
        boolean playerOut = false;
        if (!isGreenLight && (speed != 0)){
            playerOut = true;
        }
        return playerOut;
    }
}
