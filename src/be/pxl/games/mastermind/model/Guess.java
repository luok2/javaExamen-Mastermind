package be.pxl.games.mastermind.model;

/**
 * Created by Gepe on 1/06/2015.
 */
public class Guess {
    private Color[] color;

    public Guess() {
        color = new Color[4];
    }

    public void setColor(int index, Color color) {
        this.color[index] = color;
    }

    public Color getColor(int index) {
        return color[index];
    }

    public Color[] getColor() {
        return color;
    }
}
