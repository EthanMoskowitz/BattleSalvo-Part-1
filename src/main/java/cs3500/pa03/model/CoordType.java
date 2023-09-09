package cs3500.pa03.model;

/**
 * Represents types of coordinates
 */
public enum CoordType {

  /**
   * If the coordinate is open ocean
   */
  OCEAN,

  /**
   * If the coordinate is part of a ship
   */
  SHIP,

  /**
   * If there is a ship in the coordinate that has been shot
   */
  HIT,

  /**
   * If there is not a ship in the coordinate that has been shot
   */
  MISS
}
