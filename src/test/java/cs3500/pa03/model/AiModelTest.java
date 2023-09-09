package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for Ai model
 */
class AiModelTest {

  /**
   * Tests take shots
   */
  @Test
  void takeShots() {
    AiModel model;
    model = new AiModel("AI", new Random(1));
    Map<ShipType, Integer> map = new HashMap<>();
    map.put(ShipType.CARRIER, 1);
    map.put(ShipType.BATTLESHIP, 1);
    map.put(ShipType.DESTROYER, 1);
    map.put(ShipType.SUBMARINE, 1);
    model.setup(6, 6, map);

    List<Coord> shots = model.takeShots();
    assertEquals(4, shots.size());

    Coord coord1 = new Coord(2, 5, CoordType.OCEAN);
    assertEquals(coord1, shots.get(0));
    Coord coord2 = new Coord(4, 5, CoordType.OCEAN);
    assertEquals(coord2, shots.get(1));
    Coord coord3 = new Coord(3, 5, CoordType.OCEAN);
    assertEquals(coord3, shots.get(2));
    Coord coord4 = new Coord(1, 2, CoordType.OCEAN);
    assertEquals(coord4, shots.get(3));

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 5; j++) {
        model.opponentBoard[i][j].setType(CoordType.HIT);
      }
    }
    shots = model.takeShots();
    assertEquals(4, shots.size());

    coord1 = new Coord(5, 4, CoordType.OCEAN);
    assertEquals(coord1, shots.get(0));
    coord2 = new Coord(5, 0, CoordType.OCEAN);
    assertEquals(coord2, shots.get(1));
    coord3 = new Coord(5, 5, CoordType.OCEAN);
    assertEquals(coord3, shots.get(2));
    coord4 = new Coord(5, 2, CoordType.OCEAN);
    assertEquals(coord4, shots.get(3));
  }
}