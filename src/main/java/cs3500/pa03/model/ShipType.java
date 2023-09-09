package cs3500.pa03.model;

/**
 * Represents ship types
 */
public enum ShipType {

  /**
   * Carrier ship with size 6
   */
  CARRIER(6),

  /**
   * Battleship with size 5
   */
  BATTLESHIP(5),

  /**
   * Destroyer ship with size 4
   */
  DESTROYER(4),

  /**
   * Submarine with size 3
   */
  SUBMARINE(3),

  /**
   * Standby ship type for coordinates that are not ship yet
   */
  STANDBY(0);

  private final int size;

  /**
   * Instantiates a ship type
   *
   * @param i size of ship
   */
  ShipType(int i) {
    size = i;
  }

  /**
   * Gives the ship size for each type
   *
   * @return int of ship size
   */
  public int getSize() {
    return size;
  }
}
