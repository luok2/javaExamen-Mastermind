package be.pxl.games.mastermind.controller;

import be.pxl.games.mastermind.model.Guess;
import be.pxl.games.mastermind.model.MasterMindGame;
import be.pxl.games.mastermind.model.MasterMindGameImpl;
import be.pxl.games.mastermind.model.Result;
import be.pxl.games.mastermind.view.MasterMindFrame;

public class MasterMindController {
    // Vraag 4: Voeg de nodige variabelen toe
    private MasterMindGame game;
    private MasterMindFrame view;
    private int guesses;

    public MasterMindController() {
        init();
    }

    private void init() {
        // Vraag 4: maak het model en de view aan.
        view = new MasterMindFrame(this);
        game = new MasterMindGameImpl();
        reset();

    }

    // public methods called by view
    public void guess(Guess guess) {
        // Vraag 4: handel het klikken op de knop Guess af.
        Result result = game.guess(guess);
        view.setResult(guesses, guess.getColor(), result.getCorrectCollors(), result.getCorrectPlaces());
        guesses++;
        if (result.getCorrectPlaces() == 4) view.disable();
    }

    public void reset() {

        view.reset();
        guesses = 0;
        game.start();
    }
}
