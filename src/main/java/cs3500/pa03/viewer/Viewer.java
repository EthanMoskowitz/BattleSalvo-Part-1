package cs3500.pa03.viewer;

import cs3500.pa03.model.AbstractPlayer;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;

/**
 * Represents a viewer
 */
public interface Viewer {

  /**
   * Welcomes the user
   */
  void welcome();

  /**
   * Prompts the user for board size
   */
  void promptBoardSize();

  /**
   * Tells the user if they input an invalid size
   */
  void invalidSize();

  /**
   * Prompts the user for amount of ships
   *
   * @param size total amount of ships they can have
   */
  void promptShips(int size);

  /**
   * Tells the user if they have entered an invalid number of ships
   */
  void invalidShips();

  /**
   * Displays the boards of the user and opponent
   *
   * @param player person's board to display
   * @param board player or opponent board
   */
  void displayBoard(AbstractPlayer player, Coord[][] board);

  /**
   * Prompts the user for their shots
   *
   * @param shots amount of shots they can take
   */
  void promptShot(int shots);

  /**
   * Tells the user the end result
   *
   * @param result result of the game
   */
  void endGame(GameResult result);

  /**
   * Gets the input from the user
   *
   * @return string of the users input
   */
  String getInput();
}
