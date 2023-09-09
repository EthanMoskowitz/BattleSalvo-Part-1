package cs3500.pa03.controller;

import cs3500.pa03.model.AiModel;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.PlayerModel;
import cs3500.pa03.model.ShipType;
import cs3500.pa03.viewer.SalvoViewer;
import cs3500.pa03.viewer.Viewer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents controller for battle salvo
 */
public class SalvoController implements Controller {
  private Viewer viewer;
  private final PlayerModel player1;
  private final AiModel player2;
  private final Readable readable;
  private final Appendable appendable;

  /**
   * Instantiates the controller
   *
   * @param r readable for inputs
   * @param a appendable for outputs
   * @param p1 player-model for player 1 in game
   * @param p2 ai-model for player 2 in game
   */
  public SalvoController(Readable r, Appendable a, PlayerModel p1, AiModel p2) {
    readable = r;
    appendable = a;
    player1 = p1;
    player2 = p2;
  }

  /**
   * Runs the controller
   */
  @Override
  public void run() {
    viewer = new SalvoViewer(readable, appendable);
    viewer.welcome();
    setup();
    play();
    end();
  }

  /**
   * Sets up the game with user inputs
   */
  private void setup() {
    viewer.promptBoardSize();
    int[] sizes = boardSize();
    int height = sizes[0];
    int width = sizes[1];
    int size = Math.min(height, width);
    viewer.promptShips(size);
    Map<ShipType, Integer> map = takeShips(size);
    player1.setup(height, width, map);
    player2.setup(height, width, map);
  }

  /**
   * Gets the board size
   *
   * @return array of ints that make the board size
   */
  private int[] boardSize() {
    int height;
    int width;
    while (true) {
      String[] parts = viewer.getInput().split(" ");
      if (parts.length == 2) {
        try {
          height = Integer.parseInt(parts[0]);
          width = Integer.parseInt(parts[1]);
          if (height >= 6 && width >= 6 && height <= 15 && width <= 15) {
            return new int[] {height, width};
          }
        } catch (NumberFormatException ignored) {
          //do nothing
        }
      }
      viewer.invalidSize();
    }
  }

  /**
   * Makes the map for fleets
   *
   * @param size maximum amount of ships
   * @return map of ship-types to integer
   */
  private Map<ShipType, Integer> takeShips(int size) {
    int carrier;
    int battleship;
    int destroyer;
    int submarine;
    while (true) {
      String[] parts = viewer.getInput().split(" ");
      if (parts.length == 4) {
        try {
          carrier = Integer.parseInt(parts[0]);
          battleship = Integer.parseInt(parts[1]);
          destroyer = Integer.parseInt(parts[2]);
          submarine = Integer.parseInt(parts[3]);
          int sum = carrier + battleship + destroyer + submarine;
          if (sum <= size && carrier > 0 && battleship > 0 && destroyer > 0 && submarine > 0) {
            Map<ShipType, Integer> map = new HashMap<>();
            map.put(ShipType.CARRIER, carrier);
            map.put(ShipType.BATTLESHIP, battleship);
            map.put(ShipType.DESTROYER, destroyer);
            map.put(ShipType.SUBMARINE, submarine);
            return map;
          }
        } catch (NumberFormatException ignored) {
          //do nothing
        }
      }
      viewer.invalidShips();
      viewer.promptShips(size);
    }
  }

  /**
   * Plays the game
   */
  private void play() {
    while (!player1.isOver() && !player2.isOver()) {
      viewer.displayBoard(player2, player1.getOpponentBoard());
      viewer.displayBoard(player1, player1.getUserBoard());

      int shotNumber = player1.getShotNumber();
      viewer.promptShot(shotNumber);
      String[] shots = getPlayerShots(shotNumber);
      if (!player1.validateInputs(shots)) {
        play();
      }
      List<Coord> p1Damage = player1.reportDamage(player2.takeShots());
      List<Coord> p2Damage = player2.reportDamage(player1.takeShots());
      player1.successfulHits(p2Damage);
      player2.successfulHits(p1Damage);
    }
  }

  /**
   * Gets the users shots
   *
   * @param shotNumber number of shots they should take
   * @return array of strings of their shots
   */
  private String[] getPlayerShots(int shotNumber) {
    String[] shots = new String[shotNumber];
    for (int i = 0; i < shotNumber; i++) {
      shots[i] = viewer.getInput();
    }
    return shots;
  }

  /**
   * Ends the game by telling the user
   */
  private void end() {
    viewer.displayBoard(player2, player1.getOpponentBoard());
    viewer.displayBoard(player1, player1.getUserBoard());
    if (player1.isOver() && player2.isOver()) {
      viewer.endGame(GameResult.DRAW);
    } else if (player1.isOver() && !player2.isOver()) {
      viewer.endGame(GameResult.LOSE);
    } else if (!player1.isOver() && player2.isOver()) {
      viewer.endGame(GameResult.WIN);
    }
  }

}
