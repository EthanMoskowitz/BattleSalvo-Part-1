package cs3500.pa03.model;

import java.util.List;

/**
 * Represents a coordinate in the board
 */
public class Coord {
  private final int rowSpot;
  private final int colSpot;
  private CoordType type;
  private ShipType shipType;

  /**
   * Instantiates the coordinate
   *
   * @param r row of coordinate in board
   * @param c column of coordinate in board
   * @param t type of coordinate
   */
  Coord(int r, int c, CoordType t) {
    rowSpot = r;
    colSpot = c;
    type = t;
    shipType = ShipType.STANDBY;
  }

  /**
   * Gets the x position
   *
   * @return x position int
   */
  public int getX() {
    return rowSpot;
  }

  /**
   * Gets the y position
   *
   * @return y position int
   */
  public int getY() {
    return colSpot;
  }

  /**
   * Gets the coordinate type
   *
   * @return coordinate type
   */
  public CoordType getType() {
    return type;
  }

  /**
   * Gets ship type of coordinate
   *
   * @return ship type
   */
  public ShipType getShipType() {
    return shipType;
  }

  /**
   * Sets the coordinate type to given type
   *
   * @param t new coordinate type
   */
  public void setType(CoordType t) {
    type = t;
  }

  /**
   * Sets the ship type to given type
   *
   * @param s new ship type
   */
  public void setShipType(ShipType s) {
    shipType = s;
  }

  /**
   * Checks if coordinates are equal
   *
   * @param obj obj to test
   * @return true if same coordinate and false if otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Coord c)) {
      return false;
    }

    return rowSpot == c.rowSpot && colSpot == c.colSpot && type.equals(c.type)
        && shipType.equals(c.shipType);
  }

  /**
   * Checks if same list of coordinates
   *
   * @param first first list of coordinates
   * @param second second list of coordinates
   * @return true if they are same and false if otherwise
   */
  public static boolean sameCoords(List<Coord> first, List<Coord> second) {
    if (first.size() != second.size()) {
      return false;
    }
    for (int i = 0; i < first.size(); i++) {
      if (!first.get(i).equals(second.get(i))) {
        return false;
      }
    }
    return true;
  }
}
