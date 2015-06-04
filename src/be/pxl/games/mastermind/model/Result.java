package be.pxl.games.mastermind.model;

/**
 * Created by Gepe on 1/06/2015.
 */
public class Result {
    private int correctCollors;
    private int correctPlaces;

    public Result(int c, int p) {
        correctCollors = c;
        correctPlaces = p;
    }

    public int getCorrectCollors() {
        return correctCollors;
    }

    public int getCorrectPlaces() {
        return correctPlaces;
    }
}
