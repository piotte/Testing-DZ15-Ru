package my.game.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class gameCoreTest {

    @Test
    public void positiveSpeedWithReLightPlayerMustOut(){
        int speed = 10;
        boolean actual = gameCore.isPlayerOut(speed);
        if (!gameCore.isGreenLight) {
                Assertions.assertTrue(actual, "Moving player must leave game, because GreenLight:" + gameCore.isGreenLight);
        }
    }

    @Test
    public void negativeSpeedWithRedLightPlayerMustOut(){
        int speed = -10;
        boolean actual = gameCore.isPlayerOut(speed);
        if (!gameCore.isGreenLight) {
            Assertions.assertTrue(actual,
                    "Depends on logic, but negative speed can mean backward movement, which is prohibited, because GreenLight:" + gameCore.isGreenLight);
        }
    }

    @Test
    public void zeroSpeedPlayerMustRemain(){
        int speed = 0;
        boolean actual = gameCore.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player who don't move continues game");
    }

    @Test
    public void movingWithGreenLight(){
        int speed = 666;
        boolean actual = gameCore.isPlayerOut(speed);
        if (gameCore.isGreenLight) {
            Assertions.assertFalse(actual, "Player moving with green light continue game, with red light leave, now GreenLight:" + gameCore.isGreenLight);
        }
    }

    @Test
    public void ultimativeMovingPlayerTest(){
        int speed = 10;
        boolean actual = gameCore.isPlayerOut(speed);
        boolean expected = !gameCore.isGreenLight;
        Assertions.assertEquals(actual, expected, "If light green player continue game, else - leave, now GreenLight:" + gameCore.isGreenLight);
    }



}
