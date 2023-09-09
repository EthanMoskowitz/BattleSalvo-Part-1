package cs3500.pa03.model;

import java.util.List;

/**
 * Represents a ship in the game
 */
public class Ship {
  private final ShipType shipType;
  private final List<Coord> coords;

  /**
   * Instantiates a ship
   *
   * @param t type of ship
   * @param c coordinates the ship inhabits
   */
  Ship(ShipType t, List<Coord> c) {
    shipType = t;
    coords = c;
  }

  /**
   * Checks if the ship is sunk
   *
   * @return sunk boolean
   */
  public boolean isSunk() {
    boolean sunk = true;
    for (Coord c : coords) {
      if (!c.getType().equals(CoordType.HIT)) {
        sunk = false;
        break;
      }
    }
    return sunk;
  }

  /**
   * Checks if two ships are the same
   *
   * @param obj obj to test
   * @return true if same and false if not
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Ship ship)) {
      return false;
    }

    return shipType.equals(ship.shipType) && Coord.sameCoords(coords, ship.coords);
  }
}
