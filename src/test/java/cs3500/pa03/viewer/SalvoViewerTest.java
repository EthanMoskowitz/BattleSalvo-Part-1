package cs3500.pa03.viewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa03.model.AiModel;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.PlayerModel;
import cs3500.pa03.model.ShipType;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the salvo viewer
 */
class SalvoViewerTest {
  Viewer viewer;
  StringBuilder builder;
  Viewer failViewer;

  /**
   * Instantiates a viewer
   */
  @BeforeEach
  void setup() {
    String input = """
        Hello
        BattleSalvo is cool
        """;
    builder = new StringBuilder();
    viewer = new SalvoViewer(new StringReader(input), builder);
    failViewer = new SalvoViewer(new StringReader(input), new MockAppendable());
  }

  /**
   * Tests welcome
   */
  @Test
  void welcome() {
    viewer.welcome();
    assertEquals("Hello! Welcome to the OOD BattleSalvo Game!\n", builder.toString());

    assertThrows(RuntimeException.class,
        () -> failViewer.welcome());
  }

  /**
   * Tests prompt board size
   */
  @Test
  void promptBoardSize() {
    viewer.promptBoardSize();
    assertEquals("Please enter a valid height and width below:\n", builder.toString());

    assertThrows(RuntimeException.class,
        () -> failViewer.promptBoardSize());
  }

  /**
   * Tests invalid size
   */
  @Test
  void invalidSize() {
    viewer.invalidSize();
    assertEquals("""
              Uh Oh! You've entered invalid dimensions. Please remember that the height and width
              of the game must be in the range (6, 15), inclusive. Try again!
              """, builder.toString());

    assertThrows(RuntimeException.class,
        () -> failViewer.invalidSize());
  }

  /**
   * Tests prompt ships
   */
  @Test
  void promptShips() {
    viewer.promptShips(5);
    assertEquals("""
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 5.
        """, builder.toString());

    assertThrows(RuntimeException.class,
        () -> failViewer.promptShips(5));
  }

  /**
   * Tests invalid ships
   */
  @Test
  void invalidShips() {
    viewer.invalidShips();
    assertEquals("Uh Oh! You've entered invalid fleet sizes.\n", builder.toString());

    assertThrows(RuntimeException.class,
        () -> failViewer.invalidShips());
  }

  /**
   * Tests display boards
   */
  @Test
  void displayBoards() {
    PlayerModel playerModel;
    playerModel = new PlayerModel("Opponent", new Random(1));
    AiModel model;
    model = new AiModel("Your", new Random(1));
    Map<ShipType, Integer> map = new HashMap<>();
    map.put(ShipType.CARRIER, 1);
    map.put(ShipType.BATTLESHIP, 1);
    map.put(ShipType.DESTROYER, 1);
    map.put(ShipType.SUBMARINE, 1);
    model.setup(6, 6, map);
    viewer.displayBoard(playerModel, model.getOpponentBoard());
    viewer.displayBoard(model, model.getUserBoard());

    String boards = """
        Opponent Board:
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
        Your Board:
          [34m0 [0m[31mC [0m[33mD [0m[35mB [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[31mC [0m[33mD [0m[35mB [0m[32mS [0m[34m0 [0m
          [34m0 [0m[31mC [0m[33mD [0m[35mB [0m[32mS [0m[34m0 [0m
          [34m0 [0m[31mC [0m[33mD [0m[35mB [0m[32mS [0m[34m0 [0m
          [34m0 [0m[31mC [0m[34m0 [0m[35mB [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[31mC [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
        """;
    assertEquals(boards, builder.toString());

    builder.delete(0, builder.length());
    AiModel model2 = new AiModel("AI2", new Random(2));
    model2.setup(6, 6, map);
    List<Coord> modelDamage = model.reportDamage(model2.takeShots());
    List<Coord> model2Damage = model2.reportDamage(model.takeShots());
    model.successfulHits(model2Damage);
    model2.successfulHits(modelDamage);
    viewer.displayBoard(playerModel, model.getOpponentBoard());
    viewer.displayBoard(model, model.getUserBoard());

    boards = """
        Opponent Board:
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[37mM [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[37mM [0m[37mM [0m[37mM [0m[34m0 [0m
        Your Board:
          [34m0 [0m[31mC [0m[33mD [0m[35mB [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[31mC [0m[33mD [0m[35mB [0m[32mS [0m[34m0 [0m
          [34m0 [0m[31mC [0m[33mD [0m[35mB [0m[32mS [0m[34m0 [0m
          [34m0 [0m[31mC [0m[41m[30mH[0m [35mB [0m[32mS [0m[37mM [0m
          [34m0 [0m[31mC [0m[34m0 [0m[35mB [0m[37mM [0m[34m0 [0m
          [37mM [0m[31mC [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
        """;

    assertEquals(boards, builder.toString());

    assertThrows(RuntimeException.class,
        () -> failViewer.displayBoard(model, model.getUserBoard()));
  }

  /**
   * Tests prompt shot
   */
  @Test
  void promptShot() {
    viewer.promptShot(10);
    assertEquals("Please Enter 10 Shots:\n", builder.toString());

    assertThrows(RuntimeException.class,
        () -> failViewer.promptShot(10));
  }

  /**
   * Tests end game
   */
  @Test
  void endGame() {
    viewer.endGame(GameResult.WIN);
    assertEquals("YOU WIN", builder.toString());

    builder.delete(0, builder.length());
    viewer.endGame(GameResult.LOSE);
    assertEquals("YOU LOSE", builder.toString());

    builder.delete(0, builder.length());
    viewer.endGame(GameResult.DRAW);
    assertEquals("YOU DRAW", builder.toString());

    assertThrows(RuntimeException.class,
        () -> failViewer.endGame(GameResult.WIN));
  }

  /**
   * Tests get input
   */
  @Test
  void getInput() {
    String first = viewer.getInput();
    assertEquals("Hello", first);

    String second = viewer.getInput();
    assertEquals("BattleSalvo is cool", second);
  }
}