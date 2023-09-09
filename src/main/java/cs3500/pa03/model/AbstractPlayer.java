package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents an abstract player for model classes
 */
public abstract class AbstractPlayer implements Player {
  protected final String name;
  protected List<Ship> ships;
  protected Coord[][] userBoard;
  protected Coord[][] opponentBoard;
  protected List<Coord> inputs;
  protected final Random rand;

  /**
   * Instantiates an abstract player
   *
   * @param s name of player
   * @param r random variable for creating ships
   */
  AbstractPlayer(String s, Random r) {
    name = s;
    rand = r;
  }

  /**
   * Gets the name of the player
   *
   * @return string name
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * Sets up the model for the game
   *
   * @param height         the height of the board, range: [6, 15] inclusive
   * @param width          the width of the board, range: [6, 15] inclusive
   * @param specifications a map of ship type to the number of occurrences each ship should
   *                       appear on the board
   * @return list of ships
   */
  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    setupBoard(height, width);
    List<Ship> carriers;
    carriers = setupShips(ShipType.CARRIER, specifications.get(ShipType.CARRIER));
    List<Ship> battleships;
    battleships = setupShips(ShipType.BATTLESHIP, specifications.get(ShipType.BATTLESHIP));
    List<Ship> destroyers;
    destroyers = setupShips(ShipType.DESTROYER, specifications.get(ShipType.DESTROYER));
    List<Ship> submarines;
    submarines = setupShips(ShipType.SUBMARINE, specifications.get(ShipType.SUBMARINE));

    ships = new ArrayList<>();
    ships.addAll(carriers);
    ships.addAll(battleships);
    ships.addAll(destroyers);
    ships.addAll(submarines);
    return ships;
  }

  /**
   * Initialize the player and opponent board
   *
   * @param height height of board
   * @param width width of board
   */
  protected void setupBoard(int height, int width) {
    userBoard = new Coord[height][width];
    opponentBoard = new Coord[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Coord c = new Coord(j, i, CoordType.OCEAN);
        Coord d = new Coord(j, i, CoordType.OCEAN);
        userBoard[i][j] = c;
        opponentBoard[i][j] = d;
      }
    }
  }

  /**
   * Sets up players ships
   *
   * @param type type of ship to make
   * @param number number of ships to make
   * @return list of ships to add
   */
  protected ArrayList<Ship> setupShips(ShipType type, int number) {
    ArrayList<Ship> createdShips = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      int r = rand.nextInt(0, 2);
      if (r == 0) {
        createdShips.add(createVertical(type));
      } else {
        createdShips.add(createHorizontal(type));
      }
    }
    return createdShips;
  }

  /**
   * Creates a randomly placed vertical ship
   *
   * @param type type of ship
   * @return vertical ship
   */
  protected Ship createVertical(ShipType type) {
    int size = type.getSize();
    List<Coord> coords;
    coords = new ArrayList<>();
    Coord start = generateRandom();
    coords.add(start);
    for (int i = 1; i < size; i++) {
      Coord c;
      try {
        c = userBoard[start.getY() + i][start.getX()];
      } catch (ArrayIndexOutOfBoundsException e) {
        return createHorizontal(type);
      }
      if (!c.getType().equals(CoordType.OCEAN)) {
        return createHorizontal(type);
      } else {
        coords.add(c);
      }
    }
    setShip(coords, type);
    return new Ship(type, coords);
  }

  /**
   * Creates a randomly placed horizontal ship
   *
   * @param type type of ship
   * @return horizontal ship
   */
  protected Ship createHorizontal(ShipType type) {
    int size = type.getSize();
    List<Coord> coords;
    coords = new ArrayList<>();
    Coord start = generateRandom();
    coords.add(start);
    for (int i = 1; i < size; i++) {
      Coord c;
      try {
        c = userBoard[start.getY()][start.getX() + i];
      } catch (ArrayIndexOutOfBoundsException e) {
        return createVertical(type);
      }
      if (!c.getType().equals(CoordType.OCEAN)) {
        return createVertical(type);
      } else {
        coords.add(c);
      }
    }
    setShip(coords, type);
    return new Ship(type, coords);
  }

  /**
   * Generates random coordinate from remaining ocean coordinates
   *
   * @return random coordinate
   */
  protected Coord generateRandom() {
    List<Coord> coords = getRemainingCoords(userBoard);
    int size = rand.nextInt(0, coords.size());
    return coords.get(size);
  }

  /**
   * Gets the remaining ocean coordinates
   *
   * @param board board to get goordinates from
   * @return list of remaining coordinates
   */
  protected List<Coord> getRemainingCoords(Coord[][] board) {
    List<Coord> coords = new ArrayList<>();
    for (Coord[] value : board) {
      for (Coord c : value) {
        if (c.getType().equals(CoordType.OCEAN)) {
          coords.add(c);
        }
      }
    }
    return coords;
  }

  /**
   * Sets coordinates to ship and sets their ship type
   *
   * @param coords list of coordinates to set
   * @param type ship type to set to
   */
  protected void setShip(List<Coord> coords, ShipType type) {
    for (Coord c : coords) {
      c.setType(CoordType.SHIP);
      c.setShipType(type);
    }
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  @Override
  public abstract List<Coord> takeShots();

  /**
   * Gets the number of shots depending on number of ships and remaining coordinates
   *
   * @return int of amount of shots
   */
  public int getShotNumber() {
    List<Coord> remaining = getRemainingCoords(opponentBoard);
    return Math.min(remaining.size(), ships.size());
  }

  /**
   * Reports the damage depending on the opponents shots and updates user board
   *
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return list of hit coordinates
   */
  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    List<Coord> hits = new ArrayList<>();
    for (Coord coord : opponentShotsOnBoard) {
      Coord c = userBoard[coord.getY()][coord.getX()];
      if (c.getType().equals(CoordType.SHIP)) {
        hits.add(coord);
        c.setType(CoordType.HIT);
      } else {
        c.setType(CoordType.MISS);
      }
    }
    return hits;
  }

  /**
   * Updates opponent board with list of coordinates that were hit
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    for (Coord coord : inputs) {
      Coord c = opponentBoard[coord.getY()][coord.getX()];
      if (shotsThatHitOpponentShips.contains(c)) {
        c.setType(CoordType.HIT);
      } else {
        c.setType(CoordType.MISS);
      }
    }
    checkSunk();
  }

  /**
   * Checks if any of the ships are sunk
   */
  protected void checkSunk() {
    ships.removeIf(Ship::isSunk);
  }

  /**
   * Checks if the game is over
   *
   * @return true or false if game is over
   */
  public boolean isOver() {
    return ships.size() == 0;
  }

  /**
   * Ends game (not used for PA03)
   *
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  @Override
  public void endGame(GameResult result, String reason) {

  }

  /**
   * Gets user board
   *
   * @return user board
   */
  public Coord[][] getUserBoard() {
    return userBoard;
  }

  /**
   * Gets opponent board
   *
   * @return opponent board
   */
  public Coord[][] getOpponentBoard() {
    return opponentBoard;
  }

}
