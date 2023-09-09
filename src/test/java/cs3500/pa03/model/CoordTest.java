package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for Coord class
 */
class CoordTest {
  Coord ocean;
  Coord ship;
  Coord hit;
  Coord miss;

  /**
   * Makes coords to test from
   */
  @BeforeEach
  void setup() {
    ocean = new Coord(10, 5, CoordType.OCEAN);
    ship = new Coord(4, 10000, CoordType.SHIP);
    hit = new Coord(5, 3, CoordType.HIT);
    miss = new Coord(1, 0, CoordType.MISS);
  }

  /**
   * Tests get x
   */
  @Test
  void getX() {
    assertEquals(10, ocean.getX());
    assertEquals(4, ship.getX());
    assertEquals(5, hit.getX());
    assertEquals(1, miss.getX());
  }

  /**
   * Tests get y
   */
  @Test
  void getY() {
    assertEquals(5, ocean.getY());
    assertEquals(10000, ship.getY());
    assertEquals(3, hit.getY());
    assertEquals(0, miss.getY());
  }

  /**
   * Tests get type
   */
  @Test
  void getType() {
    assertEquals(CoordType.OCEAN, ocean.getType());
    assertEquals(CoordType.SHIP, ship.getType());
    assertEquals(CoordType.HIT, hit.getType());
    assertEquals(CoordType.MISS, miss.getType());
  }

  /**
   * Test get ship type
   */
  @Test
  void getShipType() {
    assertEquals(ShipType.STANDBY, ocean.getShipType());
    assertEquals(ShipType.STANDBY, hit.getShipType());
    assertEquals(ShipType.STANDBY, miss.getShipType());

    assertEquals(ShipType.STANDBY, ship.getShipType());
    ship.setShipType(ShipType.CARRIER);
    assertEquals(ShipType.CARRIER, ship.getShipType());
    ship.setShipType(ShipType.BATTLESHIP);
    assertEquals(ShipType.BATTLESHIP, ship.getShipType());
    ship.setShipType(ShipType.DESTROYER);
    assertEquals(ShipType.DESTROYER, ship.getShipType());
    ship.setShipType(ShipType.SUBMARINE);
    assertEquals(ShipType.SUBMARINE, ship.getShipType());
  }

  /**
   * Tests set type
   */
  @Test
  void setType() {
    assertEquals(CoordType.OCEAN, ocean.getType());
    ocean.setType(CoordType.HIT);
    assertEquals(CoordType.HIT, ocean.getType());
  }

  /**
   * Tests set ship type
   */
  @Test
  void setShipType() {
    assertEquals(ShipType.STANDBY, ship.getShipType());
    ship.setShipType(ShipType.CARRIER);
    assertEquals(ShipType.CARRIER, ship.getShipType());
  }

  /**
   * Tests equals
   */
  @Test
  void equals() {
    Coord coord1;
    coord1 = new Coord(1, 2, CoordType.OCEAN);
    Coord coord2;
    coord2 = new Coord(1, 2, CoordType.OCEAN);
    Coord coord3;
    coord3 = new Coord(2, 2, CoordType.OCEAN);
    Coord coord4;
    coord4 = new Coord(1, 5, CoordType.OCEAN);
    Coord coord5;
    coord5 = new Coord(1, 2, CoordType.SHIP);

    assertNotEquals(coord1, new Object());

    assertEquals(coord1, coord2);

    assertNotEquals(coord1, coord3);

    assertNotEquals(coord1, coord4);

    assertNotEquals(coord1, coord5);

    coord2.setShipType(ShipType.CARRIER);
    assertNotEquals(coord1, coord2);
  }

  /**
   * Tests same coords
   */
  @Test
  void sameCoords() {
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

    List<Coord> coords2 = new ArrayList<>();

    assertFalse(Coord.sameCoords(coords, coords2));

    coords2.add(one);
    coords2.add(two);
    coords2.add(three);
    coords2.add(four);
    coords2.add(five);
    assertTrue(Coord.sameCoords(coords, coords2));

    coords2.remove(five);
    coords2.add(four);
    assertFalse(Coord.sameCoords(coords, coords2));

  }
}