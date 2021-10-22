package my.game.logic;

public class gameCore {
    public static boolean isGreenLight = false;

    public static boolean isPlayerOut(int speed){
        boolean playerOut = false;
        if (!isGreenLight && (speed != 0)){
            playerOut = true;
        }
        return playerOut;
    }

    public static int numberOfPlayerOut(int[] playersSpeed){
        int counter =0;
        for (int speed: playersSpeed) {
            if (isPlayerOut(speed)){
                counter++;
            }
        }
        return counter;
    }

    public static int[] playersOut(int[] playersSpeed){
        int[] outers = new int[numberOfPlayerOut( playersSpeed)];
        int index = 0;
        for (int i = 0; i < playersSpeed.length; i++){
            if (isPlayerOut(playersSpeed[i])){
                outers[index] = playersSpeed[i];
                index++;
            }
        }
        return outers;
    }

    public static int[] playersRemain(int[] playersSpeed){
        int numberRemain =  playersSpeed.length - numberOfPlayerOut( playersSpeed);
        int[] remainers = new int[numberRemain];
        int index = 0;
        for (int i = 0; i < playersSpeed.length; i++){
            if (!isPlayerOut(playersSpeed[i])){
                remainers[index] = playersSpeed[i];
                index++;
            }
        }
        return remainers;
    }
}
