package my.game.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class gameCoreTest {

    @Test
    public void positiveSpeedWithReLightPlayerMustOut(){
        gameCore.isGreenLight = false;
        int speed = 10;
        boolean actual = gameCore.isPlayerOut(speed);
                Assertions.assertTrue(actual, "Moving player must leave game, because GreenLight:" + gameCore.isGreenLight);
    }

    @Test
    public void negativeSpeedWithRedLightPlayerMustOut(){
        gameCore.isGreenLight = false;
        int speed = -10;
        boolean actual = gameCore.isPlayerOut(speed);
        Assertions.assertTrue(actual,
                    "Depends on logic, but negative speed can mean backward movement, which is prohibited, because GreenLight:" + gameCore.isGreenLight);

    }

    @Test
    public void zeroSpeedPlayerMustRemain(){
        gameCore.isGreenLight = false;
        int speed = 0;
        boolean actual = gameCore.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player who don't move continues game");
    }

    @Test
    public void movingWithGreenLight(){
        gameCore.isGreenLight = true;
        int speed = 666;
        boolean actual = gameCore.isPlayerOut(speed);
        Assertions.assertFalse(actual, "Player moving with green light continue game, with red light leave, now GreenLight:" + gameCore.isGreenLight);

    }

    @Test
    public void ultimativeMovingPlayerTest(){
        int speed = 10;
        boolean actual = gameCore.isPlayerOut(speed);
        boolean expected = !gameCore.isGreenLight;
        Assertions.assertEquals(actual, expected, "If light green player continue game, else - leave, now GreenLight: " + gameCore.isGreenLight);
    }

    @Test
    public void numberOfAllPlayersOut(){
        gameCore.isGreenLight = false;
        int[] players = {1, 2, 3, 4, 5};

        int actual = gameCore.numberOfPlayerOut(players);
        int expected = players.length;
        Assertions.assertEquals(actual, expected, "All players must out, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void numberOfANonePlayersOutRedLight(){
        gameCore.isGreenLight = false;
        int[] players = {0, 0, 0, 0, 0};

        int actual = gameCore.numberOfPlayerOut(players);
        int expected = 0;
        Assertions.assertEquals(actual, expected, "None players out, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void numberOfANonePlayersOutGreenLight(){
        gameCore.isGreenLight = true;
        int[] players = {0, 0, 0, 0, 0};

        int actual = gameCore.numberOfPlayerOut(players);
        int expected = 0;
        Assertions.assertEquals(actual, expected, "None players out, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void rightNumberPlayersOutRedLight(){
        gameCore.isGreenLight = false;
        int[] players = {1, 2, 0, 4, 0};

        int actual = gameCore.numberOfPlayerOut(players);
        int expected = 3;
        Assertions.assertEquals(actual, expected, "3 players must out, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void allPlayersOutRedLgiht(){
        gameCore.isGreenLight = false;
        int[] players = {1, 2, 3, 4, 5};

        int[] actual = gameCore.playersOut(players);
        int[] expected = players;

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is players array, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void nonePlayersOutGreenLgiht(){
        gameCore.isGreenLight = true;
        int[] players = {1, 2, 0, 4, 0};

        int[] actual = gameCore.playersOut(players);
        int[] expected = {};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is empty array, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void nonePlayersOutRedLgiht(){
        gameCore.isGreenLight = false;
        int[] players = {0, 0, 0, 0, 0};

        int[] actual = gameCore.playersOut(players);
        int[] expected = {};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is players array, greenLight: "+ gameCore.isGreenLight);
    }


    @Test
    public void rightPlayersOutRedLgiht(){
        gameCore.isGreenLight = false;
        int[] players = {1, 2, 0, 4, 0};

        int[] actual = gameCore.playersOut(players);
        int[] expected = {1, 2, 4};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result hard coded btw, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void rightPlayersRemainRedLight(){
        gameCore.isGreenLight = false;
        int[] players = {1, 2, 0, 4, 0};

        int[] actual = gameCore.playersRemain(players);
        int[] expected = {0, 0};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result hard coded btw, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void allPlayersRemainGreenLight(){
        gameCore.isGreenLight = true;
        int[] players = {1, 2, 0, 4, 0};

        int[] actual = gameCore.playersRemain(players);
        int[] expected = players;

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is players array, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void allPlayersRemainRedLight(){
        gameCore.isGreenLight = true;
        int[] players = {0, 0, 0, 0, 0};

        int[] actual = gameCore.playersRemain(players);
        int[] expected = players;

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is players array, greenLight: "+ gameCore.isGreenLight);
    }

    @Test
    public void nonePlayersRemainRedLight(){
        gameCore.isGreenLight = false;
        int[] players = {1, 2, 3, 4, 5};

        int[] actual = gameCore.playersRemain(players);
        int[] expected = {};

        boolean result = Arrays.equals(actual, expected);
        Assertions.assertTrue(result, "Expected result is empty array, greenLight: "+ gameCore.isGreenLight);
    }

}
