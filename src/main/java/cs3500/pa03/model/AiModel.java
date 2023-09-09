package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents an Ai playing the game
 */
public class AiModel extends AbstractPlayer {

  /**
   * Instantiates an abstract player
   *
   * @param s name of player
   * @param r random variable to use for taking shots
   */
  public AiModel(String s, Random r) {
    super(s, r);
  }

  /**
   * Takes a random but not repeated shot
   *
   * @return list of shot coordinates
   */
  @Override
  public List<Coord> takeShots() {
    inputs = new ArrayList<>();
    List<Coord> shots = new ArrayList<>();
    while (shots.size() < getShotNumber()) {
      int randRow = rand.nextInt(0, opponentBoard.length);
      int randCol = rand.nextInt(0, opponentBoard[randRow].length);
      Coord c = opponentBoard[randRow][randCol];
      if (c.getType().equals(CoordType.OCEAN) && !shots.contains(c)) {
        shots.add(c);
        inputs.add(c);
      }
    }
    return shots;
  }
}
