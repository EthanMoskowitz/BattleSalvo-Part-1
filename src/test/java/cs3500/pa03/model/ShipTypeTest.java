package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests ship type
 */
class ShipTypeTest {

  /**
   * Tests get size
   */
  @Test
  void getSize() {
    ShipType carrier = ShipType.CARRIER;
    assertEquals(6, carrier.getSize());

    ShipType battleship = ShipType.BATTLESHIP;
    assertEquals(5, battleship.getSize());

    ShipType destroyer = ShipType.DESTROYER;
    assertEquals(4, destroyer.getSize());

    ShipType submarine = ShipType.SUBMARINE;
    assertEquals(3, submarine.getSize());
  }
}