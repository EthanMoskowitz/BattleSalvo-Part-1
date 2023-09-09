package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a player playing the game
 */
public class PlayerModel extends AbstractPlayer {

  /**
   * Instantiates an abstract player
   *
   * @param s name of player
   * @param r random variable for setting up ships
   */
  public PlayerModel(String s, Random r) {
    super(s, r);
  }

  /**
   * Takes the shots
   *
   * @return input shots from user
   */
  @Override
  public List<Coord> takeShots() {
    return inputs;
  }

  /**
   * Validates the user's inputs as shot
   *
   * @param input string array of users shots
   * @return true or false depending on if the shots are valid
   */
  public boolean validateInputs(String[] input) {
    List<Coord> tempInput = new ArrayList<>();
    for (String s : input) {
      String[] coords = s.split(" ");
      int x;
      int y;
      Coord c;
      try {
        x = Integer.parseInt(coords[0]);
        y = Integer.parseInt(coords[1]);
        c = opponentBoard[y][x];
      } catch (Exception e) {
        return false;
      }
      if (!c.getType().equals(CoordType.OCEAN) || tempInput.contains(c)) {
        return false;
      }
      tempInput.add(c);
    }
    takeInputs(input);
    return true;
  }

  /**
   * Takes the user input
   *
   * @param input string array of users shots
   */
  public void takeInputs(String[] input) {
    inputs = new ArrayList<>();
    for (String s : input) {
      String[] coords = s.split(" ");
      int x = Integer.parseInt(coords[0]);
      int y = Integer.parseInt(coords[1]);
      Coord c = opponentBoard[y][x];
      inputs.add(c);
    }
  }

}
