package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for ship
 */
class ShipTest {

  /**
   * Tests is sunk
   */
  @Test
  void isSunk() {
    Coord one = new Coord(0, 0, CoordType.SHIP);
    Coord two = new Coord(0, 1, CoordType.SHIP);
    Coord three = new Coord(0, 2, CoordType.SHIP);
    Coord four = new Coord(0, 3, CoordType.SHIP);
    Coord five = new Coord(0, 4, CoordType.SHIP);
    List<Coord> coords = new ArrayList<>();
    coords.add(one);
    coords.add(two);
    coords.add(three);
    coords.add(four);
    coords.add(five);

    Ship ship = new Ship(ShipType.BATTLESHIP, coords);
    assertFalse(ship.isSunk());

    for (Coord c : coords) {
      c.setType(CoordType.HIT);
    }

    assertTrue(ship.isSunk());
  }

  /**
   * Tests equals
   */
  @Test
  void equals() {
    Coord one = new Coord(0, 0, CoordType.SHIP);
    Coord two = new Coord(0, 1, CoordType.SHIP);
    Coord three = new Coord(0, 2, CoordType.SHIP);
    Coord four = new Coord(0, 3, CoordType.SHIP);
    Coord five = new Coord(0, 4, CoordType.SHIP);
    List<Coord> coords = new ArrayList<>();
    coords.add(one);
    coords.add(two);
    coords.add(three);
    coords.add(four);
    coords.add(five);

    Ship ship1;
    ship1 = new Ship(ShipType.CARRIER, coords);
    Ship ship2;
    ship2 = new Ship(ShipType.CARRIER, coords);
    Ship ship3;
    ship3 = new Ship(ShipType.BATTLESHIP, coords);
    List<Coord> coords2 = new ArrayList<>();
    Ship ship4;
    ship4 = new Ship(ShipType.CARRIER, coords2);

    assertNotEquals(ship1, new Object());

    assertEquals(ship1, ship2);

    assertNotEquals(ship1, ship3);

    assertNotEquals(ship1, ship4);

  }
}