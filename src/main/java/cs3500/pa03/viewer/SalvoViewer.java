package cs3500.pa03.viewer;

import cs3500.pa03.model.AbstractPlayer;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a viewer for Salvo
 */
public class SalvoViewer implements Viewer {
  private Appendable appendable;
  private Scanner scanner;

  /**
   * Instantiates the viewer
   *
   * @param i input readable
   * @param o output appendable
   */
  public SalvoViewer(Readable i, Appendable o) {
    appendable = o;
    scanner = new Scanner(i);
  }

  /**
   * Welcomes the user
   */
  @Override
  public void welcome() {
    try {
      appendable.append("Hello! Welcome to the OOD BattleSalvo Game!\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Prompts the user for board size
   */
  @Override
  public void promptBoardSize() {
    try {
      appendable.append("Please enter a valid height and width below:\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Tells the user if they input an invalid size
   */
  @Override
  public void invalidSize() {
    try {
      appendable.append(
          """
              Uh Oh! You've entered invalid dimensions. Please remember that the height and width
              of the game must be in the range (6, 15), inclusive. Try again!
              """);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Prompts the user for amount of ships
   *
   * @param size total amount of ships they can have
   */
  @Override
  public void promptShips(int size) {
    try {
      appendable.append(
          "Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].\n"
              + "Remember, your fleet may not exceed size ").append(String.valueOf(size))
          .append(".\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Tells the user if they have entered an invalid number of ships
   */
  @Override
  public void invalidShips() {
    try {
      appendable.append("Uh Oh! You've entered invalid fleet sizes.\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Displays the boards of the user and opponent
   *
   * @param player person's board to display
   * @param board player or opponent boards
   */
  @Override
  public void displayBoard(AbstractPlayer player, Coord[][] board) {
    StringBuilder builder = new StringBuilder();
    builder.append(player.name()).append(" Board:");
    makeBoard(builder, board);
    try {
      appendable.append(builder.toString());
      appendable.append("\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Makes the board
   *
   * @param builder builder to append the board to
   * @param board which board to make
   */
  private void makeBoard(StringBuilder builder, Coord[][] board) {
    String reset = "\u001B[0m";
    for (Coord[] coords : board) {
      builder.append("\n");
      builder.append("\s\s");
      for (Coord c : coords) {
        switch (c.getType()) {
          case OCEAN -> builder.append("\u001B[34m" + "0 ").append(reset);
          case SHIP -> {
            switch (c.getShipType()) {
              case CARRIER -> builder.append("\u001B[31m" + "C ").append(reset);
              case BATTLESHIP -> builder.append("\u001B[35m" + "B ").append(reset);
              case DESTROYER -> builder.append("\u001B[33m" + "D ").append(reset);
              default -> builder.append("\u001B[32m" + "S ").append(reset);
            }
          }
          case MISS -> builder.append("\u001B[37m" + "M ").append(reset);
          default -> builder.append("\u001B[41m" + "\u001B[30m" + "H").append(reset).append(" ");
        }
      }
    }
  }

  /**
   * Prompts the user for their shots
   *
   * @param shots amount of shots they can take
   */
  @Override
  public void promptShot(int shots) {
    try {
      appendable.append("Please Enter ").append(String.valueOf(shots)).append(" Shots:\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Tells the user the end result
   *
   * @param result result of the game
   */
  @Override
  public void endGame(GameResult result) {
    try {
      appendable.append("YOU ").append(result.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Gets the input from the user
   *
   * @return string of the users input
   */
  @Override
  public String getInput() {
    return scanner.nextLine();
  }
}
