package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for a player model
 */
class PlayerModelTest {
  PlayerModel player;
  Map<ShipType, Integer> map;

  /**
   * Initializes the player model
   */
  @BeforeEach
  void start() {
    player = new PlayerModel("PLAYER", new Random(1));
    map = new HashMap<>();
    map.put(ShipType.CARRIER, 1);
    map.put(ShipType.BATTLESHIP, 1);
    map.put(ShipType.DESTROYER, 1);
    map.put(ShipType.SUBMARINE, 1);
  }

  /**
   * Tests name
   */
  @Test
  void name() {
    assertEquals("PLAYER", player.name());
  }

  /**
   * Tests setup
   */
  @Test
  void setup() {
    List<Ship> playerShips = player.setup(6, 6, map);

    List<Coord> carrierCoords = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      Coord c = new Coord(1, i, CoordType.SHIP);
      c.setShipType(ShipType.CARRIER);
      carrierCoords.add(c);
    }
    Ship carrier = new Ship(ShipType.CARRIER, carrierCoords);
    assertEquals(carrier, playerShips.get(0));

    List<Coord> battleshipCoords = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Coord c = new Coord(3, i, CoordType.SHIP);
      c.setShipType(ShipType.BATTLESHIP);
      battleshipCoords.add(c);
    }
    Ship battleship = new Ship(ShipType.BATTLESHIP, battleshipCoords);
    assertEquals(battleship, playerShips.get(1));

    List<Coord> destroyerCoords = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      Coord c = new Coord(2, i, CoordType.SHIP);
      c.setShipType(ShipType.DESTROYER);
      destroyerCoords.add(c);
    }
    Ship destroyer = new Ship(ShipType.DESTROYER, destroyerCoords);
    assertEquals(destroyer, playerShips.get(2));

    List<Coord> submarineCoords = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      Coord c = new Coord(4, i + 1, CoordType.SHIP);
      c.setShipType(ShipType.SUBMARINE);
      submarineCoords.add(c);
    }
    Ship submarine = new Ship(ShipType.SUBMARINE, submarineCoords);
    assertEquals(submarine, playerShips.get(3));

    assertEquals(4, player.getShotNumber());
    assertEquals(playerShips.size(), player.getShotNumber());
  }

  /**
   * Tests setup board
   */
  @Test
  void setupBoard() {
    player.setupBoard(6, 6);

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        Coord coord = new Coord(j, i, CoordType.OCEAN);
        assertEquals(coord, player.userBoard[i][j]);
        assertEquals(coord, player.opponentBoard[i][j]);
      }
    }
  }

  /**
   * Tests setup ships
   */
  @Test
  void setupShips() {
    player.setupBoard(6, 6);
    List<Ship> ships = player.setupShips(ShipType.DESTROYER, 3);

    List<Coord> destroyerCoords1 = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      Coord c = new Coord(2, i + 2, CoordType.SHIP);
      c.setShipType(ShipType.DESTROYER);
      destroyerCoords1.add(c);
    }
    Ship destroyer1 = new Ship(ShipType.DESTROYER, destroyerCoords1);
    assertEquals(destroyer1, ships.get(0));

    List<Coord> destroyerCoords2 = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      Coord c = new Coord(4, i, CoordType.SHIP);
      c.setShipType(ShipType.DESTROYER);
      destroyerCoords2.add(c);
    }
    Ship destroyer2 = new Ship(ShipType.DESTROYER, destroyerCoords2);
    assertEquals(destroyer2, ships.get(1));

    List<Coord> destroyerCoords3 = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      Coord c = new Coord(0, i, CoordType.SHIP);
      c.setShipType(ShipType.DESTROYER);
      destroyerCoords3.add(c);
    }
    Ship destroyer3 = new Ship(ShipType.DESTROYER, destroyerCoords3);
    assertEquals(destroyer3, ships.get(2));

  }

  /**
   * Tests create vertical
   */
  @Test
  void createVertical() {
    player.setupBoard(6, 6);
    Ship carrier = player.createVertical(ShipType.CARRIER);

    List<Coord> carrierCoords = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      Coord c = new Coord(1, i, CoordType.SHIP);
      c.setShipType(ShipType.CARRIER);
      carrierCoords.add(c);
    }
    Ship carrierTemp = new Ship(ShipType.CARRIER, carrierCoords);
    assertEquals(carrierTemp, carrier);

    player = new PlayerModel("PLAYER", new Random(1));
    player.setupBoard(6, 6);
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < player.userBoard[i].length; j++) {
        player.userBoard[i][j].setType(CoordType.SHIP);
      }
    }
    Ship carrier2 = player.createVertical(ShipType.CARRIER);
    List<Coord> carrierCoords2 = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      Coord c = new Coord(i, 3, CoordType.SHIP);
      c.setShipType(ShipType.CARRIER);
      carrierCoords2.add(c);
    }
    Ship carrierTemp2 = new Ship(ShipType.CARRIER, carrierCoords2);
    assertEquals(carrierTemp2, carrier2);
  }

  /**
   * Tests create horizontal
   */
  @Test
  void createHorizontal() {
    player.setupBoard(6, 6);
    Ship battleship = player.createHorizontal(ShipType.BATTLESHIP);

    List<Coord> battleCoords = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Coord c = new Coord(i + 1, 3, CoordType.SHIP);
      c.setShipType(ShipType.BATTLESHIP);
      battleCoords.add(c);
    }
    Ship battleTemp = new Ship(ShipType.BATTLESHIP, battleCoords);
    assertEquals(battleTemp, battleship);

    player = new PlayerModel("PLAYER", new Random(1));
    player.setupBoard(6, 6);
    for (int i = 0; i < player.userBoard.length; i++) {
      for (int j = 0; j < 2; j++) {
        player.userBoard[i][j].setType(CoordType.SHIP);
      }
    }
    Ship battleship2 = player.createHorizontal(ShipType.BATTLESHIP);

    List<Coord> battleCoords2 = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Coord c = new Coord(2, i + 1, CoordType.SHIP);
      c.setShipType(ShipType.BATTLESHIP);
      battleCoords2.add(c);
    }
    Ship battleTemp2 = new Ship(ShipType.BATTLESHIP, battleCoords2);
    assertEquals(battleTemp2, battleship2);
  }

  /**
   * Tests generate random
   */
  @Test
  void generateRandom() {
    player.setupBoard(6, 6);
    Coord random = player.generateRandom();
    Coord coord = new Coord(3, 5, CoordType.OCEAN);
    assertEquals(coord, random);

    Coord random2 = player.generateRandom();
    Coord coord2 = new Coord(4, 4, CoordType.OCEAN);
    assertEquals(coord2, random2);

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (i != 1 || j != 4) {
          player.userBoard[i][j].setType(CoordType.SHIP);
        }
      }
    }

    Coord randomFromLimited = player.generateRandom();
    Coord coordFromLimited = new Coord(4, 1, CoordType.OCEAN);
    assertEquals(coordFromLimited, randomFromLimited);
  }

  /**
   * Tests get remaining coords
   */
  @Test
  void getRemainingCoords() {
    player.setupBoard(6, 6);

    List<Coord> remaining = player.getRemainingCoords(player.userBoard);
    assertEquals(36, remaining.size());
    int index = 0;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        Coord c = new Coord(j, i, CoordType.OCEAN);
        assertEquals(c, remaining.get(index));
        index++;
      }
    }

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 5; j++) {
        player.userBoard[i][j].setType(CoordType.SHIP);
      }
    }

    remaining = player.getRemainingCoords(player.userBoard);
    assertEquals(6, remaining.size());
    for (int i = 0; i < 6; i++) {
      Coord c = new Coord(5, i, CoordType.OCEAN);
      assertEquals(c, remaining.get(i));
    }

  }

  /**
   * Tests set ship
   */
  @Test
  void setShip() {
    player.setupBoard(6, 6);
    List<Coord> remaining = player.getRemainingCoords(player.userBoard);
    assertEquals(36, remaining.size());

    List<Coord> setToShip = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      setToShip.add(remaining.get(i));
    }

    player.setShip(setToShip, ShipType.CARRIER);
    remaining = player.getRemainingCoords(player.userBoard);
    assertEquals(6, remaining.size());
  }

  /**
   * Tests get shot number
   */
  @Test
  void getShotNumber() {
    player.setup(6, 6, map);

    assertEquals(4, player.getShotNumber());

    List<Coord> remaining = player.getRemainingCoords(player.opponentBoard);
    List<Coord> setToShip = new ArrayList<>();
    for (int i = 0; i < 34; i++) {
      setToShip.add(remaining.get(i));
    }
    player.setShip(setToShip, ShipType.CARRIER);

    assertEquals(2, player.getShotNumber());

  }

  /**
   * Tests report damage
   */
  @Test
  void reportDamage() {
    player.setup(6, 6, map);

    List<Coord> shots = new ArrayList<>();
    List<Coord> hitShots = player.reportDamage(shots);
    assertEquals(0, hitShots.size());

    Coord hit1 = new Coord(1, 0, CoordType.OCEAN);
    Coord hit2 = new Coord(3, 4, CoordType.OCEAN);
    Coord miss1 = new Coord(0, 0, CoordType.OCEAN);
    Coord miss2 = new Coord(2, 5, CoordType.OCEAN);
    shots.add(hit1);
    shots.add(hit2);
    shots.add(miss1);
    shots.add(miss2);
    hitShots = player.reportDamage(shots);

    assertEquals(2, hitShots.size());
    assertEquals(CoordType.HIT, player.userBoard[hit1.getY()][hit1.getX()].getType());
    assertEquals(CoordType.HIT, player.userBoard[hit2.getY()][hit2.getX()].getType());
    assertEquals(CoordType.MISS, player.userBoard[miss1.getY()][miss1.getX()].getType());
    assertEquals(CoordType.MISS, player.userBoard[miss2.getY()][miss2.getX()].getType());
  }

  /**
   * Tests successful hits
   */
  @Test
  void successfulHits() {
    player.setup(6, 6, map);

    String[] inputs = new String[] {"1 0", "3 2", "0 0", "4 4"};
    player.takeInputs(inputs);

    List<Coord> successful;
    successful = new ArrayList<>();
    Coord hit1;
    hit1 = new Coord(1, 0, CoordType.OCEAN);
    Coord hit2;
    hit2 = new Coord(0, 0, CoordType.OCEAN);
    Coord miss1;
    miss1 = new Coord(3, 2, CoordType.OCEAN);
    Coord miss2;
    miss2 = new Coord(4, 4, CoordType.OCEAN);
    successful.add(hit1);
    successful.add(hit2);

    player.successfulHits(successful);
    assertEquals(CoordType.HIT, player.opponentBoard[hit1.getY()][hit1.getX()].getType());
    assertEquals(CoordType.HIT, player.opponentBoard[hit2.getY()][hit2.getX()].getType());
    assertEquals(CoordType.MISS, player.opponentBoard[miss1.getY()][miss1.getX()].getType());
    assertEquals(CoordType.MISS, player.opponentBoard[miss2.getY()][miss2.getX()].getType());
  }

  /**
   * Tests check sunk
   */
  @Test
  void checkSunk() {
    player.setup(6, 6, map);

    player.checkSunk();
    assertEquals(4, player.ships.size());

    for (int i = 0; i < 6; i++) {
      player.userBoard[i][1].setType(CoordType.HIT);
    }
    assertTrue(player.ships.get(0).isSunk());
    player.checkSunk();
    assertEquals(3, player.ships.size());

    for (int i = 0; i < 5; i++) {
      player.userBoard[i][3].setType(CoordType.HIT);
    }
    assertTrue(player.ships.get(0).isSunk());
    player.checkSunk();
    assertEquals(2, player.ships.size());
  }

  /**
   * Tests is over
   */
  @Test
  void isOver() {
    player.setup(6, 6, map);

    assertFalse(player.isOver());

    for (int i = 0; i < 6; i++) {
      player.userBoard[i][1].setType(CoordType.HIT);
    }
    for (int i = 0; i < 5; i++) {
      player.userBoard[i][3].setType(CoordType.HIT);
    }
    for (int i = 0; i < 4; i++) {
      player.userBoard[i][2].setType(CoordType.HIT);
    }
    for (int i = 0; i < 3; i++) {
      player.userBoard[i + 1][4].setType(CoordType.HIT);
    }
    player.checkSunk();

    assertTrue(player.isOver());
  }

  /**
   * Tests end game
   */
  @Test
  void endGame() {
    player.endGame(GameResult.WIN, "You win");
    // doesn't do anything yet
  }

  /**
   * Tests get user board
   */
  @Test
  void getUserBoard() {
    Coord[][] board = player.getUserBoard();
    assertEquals(board, player.userBoard);

    player.setupBoard(6, 6);
    Coord[][] newBoard = new Coord[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        newBoard[i][j] = new Coord(j, i, CoordType.OCEAN);
        assertEquals(newBoard[i][j], player.userBoard[i][j]);
      }
    }
  }

  /**
   * Tests get opponent board
   */
  @Test
  void getOpponentBoard() {
    Coord[][] board = player.getOpponentBoard();
    assertEquals(board, player.opponentBoard);

    player.setupBoard(6, 6);
    Coord[][] newBoard = new Coord[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        newBoard[i][j] = new Coord(j, i, CoordType.OCEAN);
        assertEquals(newBoard[i][j], player.opponentBoard[i][j]);
      }
    }
  }

  /**
   * Tests take shots
   */
  @Test
  void takeShots() {
    List<Coord> shots = player.takeShots();
    assertNull(shots);

    player.setup(6, 6, map);
    String[] inputs = new String[] {"0 0", "1 1", "2 2", "3 3"};
    player.takeInputs(inputs);
    shots = player.takeShots();
    assertEquals(4, shots.size());

    Coord first = new Coord(0, 0, CoordType.OCEAN);
    assertEquals(first, shots.get(0));
    Coord second = new Coord(1, 1, CoordType.OCEAN);
    assertEquals(second, shots.get(1));
    Coord third = new Coord(2, 2, CoordType.OCEAN);
    assertEquals(third, shots.get(2));
    Coord fourth = new Coord(3, 3, CoordType.OCEAN);
    assertEquals(fourth, shots.get(3));
  }

  /**
   * Tests validate inputs
   */
  @Test
  void validateInputs() {
    player.setup(6, 6, map);
    String[] inputs = new String[] {"0 0", "1 1", "2 2", "3 3"};
    assertTrue(player.validateInputs(inputs));

    inputs = new String[] {"-1 1"};
    assertFalse(player.validateInputs(inputs));

    inputs = new String[] {"1 1", "1 1"};
    assertFalse(player.validateInputs(inputs));

    player.opponentBoard[1][1].setType(CoordType.SHIP);
    inputs = new String[] {"1 1"};
    assertFalse(player.validateInputs(inputs));
  }

  /**
   * Tests take inputs
   */
  @Test
  void takeInputs() {
    player.setup(6, 6, map);

    String[] inputs = new String[] {"0 0", "1 1", "2 2", "3 3"};
    player.takeInputs(inputs);

    Coord first = new Coord(0, 0, CoordType.OCEAN);
    assertEquals(first, player.inputs.get(0));
    Coord second = new Coord(1, 1, CoordType.OCEAN);
    assertEquals(second, player.inputs.get(1));
    Coord third = new Coord(2, 2, CoordType.OCEAN);
    assertEquals(third, player.inputs.get(2));
    Coord fourth = new Coord(3, 3, CoordType.OCEAN);
    assertEquals(fourth, player.inputs.get(3));
  }
}