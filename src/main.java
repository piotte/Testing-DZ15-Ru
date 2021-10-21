import my.game.logic.gameCore;

class Main {
    public static void main(String[] args) {

        int speedOfPlayer1 = 5;
        int speedOfPlayer2 = 0;
        int speedOfPlayer3 = 2;

        // Допишите здесь логику так, что будет подсчитано и выведено
        // количество игроков, которые выбывают.
        // Если свет зелёный, то проходят все игроки (0 выбывают).
        // Если свет красный, то выбывает каждый, чья скорость не 0.

        int playersOutOfGame = 0;
        if (gameCore.isPlayerOut(speedOfPlayer1)) {
            playersOutOfGame++;
        }
        if (gameCore.isPlayerOut(speedOfPlayer2)) {
            playersOutOfGame++;
        }
        if (gameCore.isPlayerOut(speedOfPlayer3)) {
            playersOutOfGame++;
        }

        System.out.println("Количество выбывших игроков: " + playersOutOfGame);
    }
}