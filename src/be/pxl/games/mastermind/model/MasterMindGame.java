package be.pxl.games.mastermind.model;

/**
 * This interface defines a 'Master Mind' game. The game chooses a random
 * combination of 4 colors out of 6 possible colors: black, cyan, green, red,
 * yellow and white. The player has to guess this combination. After each guess
 * the game tells the player the number of correct colors and the number of
 * correct colors on the right place. The player has ten chances to guess the
 * combination. The game ends in case the player guesses the combination or the
 * maximum number of trials has been reached. This game should be used in the
 * following sequence:
 * <ol>
 * <li><code>{@link #start() start()}</code></li>
 * <li><code>{@link #guess(Guess) guess()}</code></li>
 * (several times until the combination is guessed or the maximum number of
 * trials (10) has been reached. Typically guessing is performed in the
 * following <i>while</i> loop: <br/>
 * <code>while(game.getState()== State.PLAYING) {<br/>
 * &nbsp;&nbsp;&nbsp;Guess guess = new Guess(); <br />
 * &nbsp;&nbsp;&nbsp;... // Set guess values <br />
 * &nbsp;&nbsp;&nbsp;Result result = game.guess(guess); <br />
 * &nbsp;&nbsp;&nbsp;... // Handle result <br />
 * } <br />
 * </code>
 * <li><code>{@link #getCombination() getCombination()}</code></li>
 * </ol>
 * You can check wether the combination was guessed by calling
 * {@link #isGuessed isGuessed()} < br />
 * Have a lot of fun!<br />
 * 
 * @author No&euml;l Vaes
 */
public interface MasterMindGame {

   /**
    * Starts the game. A new combination is calculated which the player has to
    * guess. If a previous game has not been finished, the game is reset.
    * 
    */
   public abstract void start();

   /**
    * Make a guess of the combination. The method {@link #start() start()}
    * should have been called first.
    * 
    * @return The result of the guess. null if the game hasn't been started yet or has already finished.
    * @param guess
    *           The guess.
    */
   public abstract Result guess(Guess guess);

   /**
    * Returns the state of the game.
    * 
    * @return The state
    */
   public abstract State getState();

   /**
    * Returns the right combination. If the game is still in the
    * {@link State#PLAYING PLAYING} state, the game will be finished and enter
    * the {@link State#FINISHED} state.
    * 
    * @return The right combination.
    */
   public abstract Color[] getCombination();

   /**
    * Returns the guess status.
    * 
    * @return true if combination is guessed.
    */
   public abstract boolean isGuessed();

}