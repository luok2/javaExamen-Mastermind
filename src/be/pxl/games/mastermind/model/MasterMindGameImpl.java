package be.pxl.games.mastermind.model;

import java.util.Random;

/**
 * Created by Gepe on 1/06/2015.
 */
public class MasterMindGameImpl implements MasterMindGame {
    private Color[] combination;
    private State state;
    private Random randomColor;

    public MasterMindGameImpl() {
        this.state = State.IDLE;
        randomColor = new Random();
    }

    @Override
    public void start() {
        state = State.PLAYING;
        combination = new Color[4];
        Color[] colors = Color.values();
        for (int i = 0; i < combination.length; i++) {
            combination[i] = colors[randomColor.nextInt(colors.length)];
        }

    }

    @Override
    public Result guess(Guess guess) {
        if (state != State.PLAYING) {
            return null;
        }
        int correctColors = 0;
        int correctPlaces = 0;
        boolean[] colorGuess = new boolean[]{false, false, false, false};
        for (int i = 0; i < guess.getColor().length; i++) {
            if (guess.getColor(i).equals(combination[i])) {
                correctPlaces++;
            }
        }
        for (int i = 0; i < guess.getColor().length; i++) {
            for (int j = 0; j < combination.length; j++)
                if (guess.getColor(i).equals(combination[j]) && !colorGuess[j]) {
                    correctColors++;
                    colorGuess[j] = true;
                    break;
                }
        }

        if (correctPlaces == 4) state = State.FINISHED;
        return new Result(correctColors, correctPlaces);
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public Color[] getCombination() {
        if (state == State.PLAYING) state = State.FINISHED;
        return combination;
    }

    @Override
    public boolean isGuessed() {
        if (state == State.FINISHED) {
            return true;
        }
        return false;
    }
}
