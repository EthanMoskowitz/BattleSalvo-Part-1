package cs3500.pa03.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.AiModel;
import cs3500.pa03.model.PlayerModel;
import java.io.StringReader;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for controller
 */
class SalvoControllerTest {

  /**
   * Tests generic run with some invalid inputs for a game which draws
   */
  @Test
  void run() {
    PlayerModel player1 = new PlayerModel("Your", new Random(1));
    AiModel player2 = new AiModel("Opponent", new Random(1));
    String input = """
        1
        hi 2
        3 hello
        1 1
        1 8
        1 17
        8 1
        17 1
        17 8
        8 17
        6 6
        1
        hi 2
        3 hello
        4 5 hola
        6 7 8 adios
        4 2 1 2
        0 1 1 1
        1 0 1 1
        1 1 0 1
        1 1 1 0
        3 1 1 1
        0 0
        0 3
        2 1
        2 3
        3 1
        3 5
        1 0
        1 2
        2 2
        3 2
        3 4
        5 4
        0 4
        2 5
        3 0
        4 1
        4 2
        5 3
        0 1
        0 2
        0 5
        1 1
        4 0
        5 5
        1 3
        1 4
        2 4
        4 3
        5 2
        2 0
        1 5
        3 3
        4 5
        5 0
        5 1
        4 4
        """;

    StringBuilder builder = new StringBuilder();
    SalvoController controller = new SalvoController(new StringReader(input),
        builder, player1, player2);
    assertDoesNotThrow(() -> controller.run());

    String output = """
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Uh Oh! You've entered invalid dimensions. Please remember that the height and width
        of the game must be in the range (6, 15), inclusive. Try again!
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Uh Oh! You've entered invalid fleet sizes.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Opponent Board:
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
        Your Board:
          [34m0 [0m[31mC [0m[34m0 [0m[31mC [0m[31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[34m0 [0m[31mC [0m[31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[34m0 [0m[31mC [0m[31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[32mS [0m[31mC [0m[31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[32mS [0m[31mC [0m[31mC [0m[34m0 [0m
          [35mB [0m[31mC [0m[32mS [0m[31mC [0m[31mC [0m[34m0 [0m
        Please Enter 6 Shots:
        Opponent Board:
          [37mM [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[37mM [0m[41m[30mH[0m [34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [41m[30mH[0m [34m0 [0m[41m[30mH[0m [34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[41m[30mH[0m [34m0 [0m[34m0 [0m
        Your Board:
          [37mM [0m[31mC [0m[34m0 [0m[31mC [0m[31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[37mM [0m[41m[30mH[0m [31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[34m0 [0m[31mC [0m[31mC [0m[33mD [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [31mC [0m[31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[32mS [0m[31mC [0m[31mC [0m[34m0 [0m
          [35mB [0m[31mC [0m[32mS [0m[41m[30mH[0m [31mC [0m[34m0 [0m
        Please Enter 6 Shots:
        Opponent Board:
          [37mM [0m[41m[30mH[0m [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[37mM [0m[41m[30mH[0m [34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [34m0 [0m[34m0 [0m
          [41m[30mH[0m [34m0 [0m[41m[30mH[0m [34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[41m[30mH[0m [34m0 [0m[37mM [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[41m[30mH[0m [34m0 [0m[34m0 [0m
        Your Board:
          [37mM [0m[41m[30mH[0m [34m0 [0m[31mC [0m[31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[37mM [0m[41m[30mH[0m [31mC [0m[33mD [0m
          [35mB [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [31mC [0m[33mD [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [31mC [0m[31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[32mS [0m[41m[30mH[0m [31mC [0m[37mM [0m
          [35mB [0m[31mC [0m[32mS [0m[41m[30mH[0m [31mC [0m[34m0 [0m
        Please Enter 6 Shots:
        Opponent Board:
          [37mM [0m[41m[30mH[0m [34m0 [0m[41m[30mH[0m [34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [34m0 [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [34m0 [0m[41m[30mH[0m [34m0 [0m[34m0 [0m[41m[30mH[0m\s
          [41m[30mH[0m [34m0 [0m[34m0 [0m[41m[30mH[0m [34m0 [0m[37mM [0m
          [34m0 [0m[34m0 [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
        Your Board:
          [37mM [0m[41m[30mH[0m [34m0 [0m[41m[30mH[0m [31mC [0m[33mD [0m
          [35mB [0m[31mC [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [35mB [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [31mC [0m[31mC [0m[41m[30mH[0m\s
          [41m[30mH[0m [31mC [0m[32mS [0m[41m[30mH[0m [31mC [0m[37mM [0m
          [35mB [0m[31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[34m0 [0m
        Please Enter 6 Shots:
        Opponent Board:
          [37mM [0m[41m[30mH[0m [34m0 [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [34m0 [0m[41m[30mH[0m [34m0 [0m[34m0 [0m[41m[30mH[0m\s
          [41m[30mH[0m [34m0 [0m[34m0 [0m[41m[30mH[0m [34m0 [0m[37mM [0m
          [41m[30mH[0m [34m0 [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
        Your Board:
          [37mM [0m[41m[30mH[0m [34m0 [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [31mC [0m[31mC [0m[41m[30mH[0m\s
          [41m[30mH[0m [31mC [0m[32mS [0m[41m[30mH[0m [31mC [0m[37mM [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[37mM [0m
        Please Enter 5 Shots:
        Opponent Board:
          [37mM [0m[41m[30mH[0m [34m0 [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m\s"""
        + """
        [41m[30mH[0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m"""
        + """
        [41m[30mH[0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
          [41m[30mH[0m [34m0 [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
        Your Board:
          [37mM [0m[41m[30mH[0m [34m0 [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [31mC [0m[41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [31mC [0m[37mM [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[37mM [0m
        Please Enter 4 Shots:
        Opponent Board:
          [37mM [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [37mM [0m
        Your Board:
          [37mM [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [33mD [0m
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [31mC [0m[37mM [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
        Please Enter 2 Shots:
        Opponent Board:
          [37mM [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m"""
        + """
        [37mM [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
        Your Board:
          [37mM [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [31mC [0m[37mM [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
        Please Enter 1 Shots:
        Opponent Board:
          [37mM [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
        Your Board:
          [37mM [0m[41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [37mM [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
        YOU DRAW""";

    assertEquals(output, builder.toString());
  }

  /**
   * Tests a game where the user wins
   */
  @Test
  void userWin() {
    PlayerModel player1 = new PlayerModel("Your", new Random(2));
    AiModel player2 = new AiModel("Opponent", new Random(3));
    String input = """
        6 6
        3 1 1 1
        Wrong 1
        2 3
        4 10
        3 4
        2 3
        0 0
        1 5
        2 5
        3 5
        1 2
        2 2
        3 2
        4 2
        1 4
        2 4
        3 4
        4 4
        5 4
        0 0
        1 0
        2 0
        3 0
        4 0
        5 0
        0 1
        1 1
        2 1
        3 1
        4 1
        5 1
        0 3
        1 3
        2 3
        3 3
        4 3
        5 3
        """;

    StringBuilder builder = new StringBuilder();
    SalvoController controller = new SalvoController(new StringReader(input),
        builder, player1, player2);
    assertDoesNotThrow(() -> controller.run());

    String output = """
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Opponent Board:
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
        Your Board:
          [34m0 [0m[33mD [0m[33mD [0m[33mD [0m[33mD [0m[34m0 [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [34m0 [0m[35mB [0m[35mB [0m[35mB [0m[35mB [0m[35mB [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [34m0 [0m[32mS [0m[32mS [0m[32mS [0m[34m0 [0m[34m0 [0m
        Please Enter 6 Shots:
        Opponent Board:
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
        Your Board:
          [34m0 [0m[33mD [0m[33mD [0m[33mD [0m[33mD [0m[34m0 [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [34m0 [0m[35mB [0m[35mB [0m[35mB [0m[35mB [0m[35mB [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [34m0 [0m[32mS [0m[32mS [0m[32mS [0m[34m0 [0m[34m0 [0m
        Please Enter 6 Shots:
        Opponent Board:
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
        Your Board:
          [34m0 [0m[33mD [0m[33mD [0m[33mD [0m[33mD [0m[34m0 [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [34m0 [0m[35mB [0m[35mB [0m[35mB [0m[41m[30mH[0m [41m[30mH[0m\s
          [31mC [0m[41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
          [31mC [0m[31mC [0m[41m[30mH[0m [31mC [0m[31mC [0m[31mC [0m
          [34m0 [0m[32mS [0m[32mS [0m[32mS [0m[34m0 [0m[34m0 [0m
        Please Enter 6 Shots:
        Opponent Board:
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
        Your Board:
          [37mM [0m[33mD [0m[33mD [0m[33mD [0m[33mD [0m[34m0 [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m
          [34m0 [0m[41m[30mH[0m [35mB [0m[35mB [0m[41m[30mH[0m [41m[30mH[0m\s
          [31mC [0m[41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
          [31mC [0m[31mC [0m[41m[30mH[0m [31mC [0m[31mC [0m[31mC [0m
          [34m0 [0m[32mS [0m[32mS [0m[32mS [0m[34m0 [0m[34m0 [0m
        Please Enter 6 Shots:
        Opponent Board:
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m"""
        + """
        [30mH[0m\s
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
        Your Board:
          [37mM [0m[33mD [0m[33mD [0m[33mD [0m[33mD [0m[34m0 [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m
          [34m0 [0m[41m[30mH[0m [35mB [0m[35mB [0m[41m[30mH[0m [41m[30mH[0m\s
          [31mC [0m[41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
          [31mC [0m[31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m
          [34m0 [0m[32mS [0m[41m[30mH[0m [32mS [0m[34m0 [0m[37mM [0m
        Please Enter 6 Shots:
        Opponent Board:
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m"""
        + """
        [30mH[0m\s
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
        Your Board:
          [37mM [0m[33mD [0m[33mD [0m[33mD [0m[41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [35mB [0m[41m[30mH[0m [41m[30mH[0m\s
          [31mC [0m[41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
          [31mC [0m[31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m
          [34m0 [0m[32mS [0m[41m[30mH[0m [32mS [0m[34m0 [0m[37mM [0m
        Please Enter 6 Shots:
        Opponent Board:
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [37mM [0m[37mM [0m[37mM [0m[37mM [0m[37mM [0m[37mM [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m"""
        + """
        [30mH[0m\s
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
        Your Board:
          [37mM [0m[33mD [0m[33mD [0m[33mD [0m[41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [35mB [0m[41m[30mH[0m [41m[30mH[0m\s
          [31mC [0m[41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
          [31mC [0m[31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m
          [34m0 [0m[32mS [0m[41m[30mH[0m [32mS [0m[37mM [0m[37mM [0m
        YOU WIN""";

    assertEquals(output, builder.toString());
  }

  /**
   * Tests a game where the user loses
   */
  @Test
  void userLose() {
    PlayerModel player1 = new PlayerModel("Your", new Random(4));
    AiModel player2 = new AiModel("Opponent", new Random(5));
    String input = """
        6 6
        3 1 1 1
        0 0
        0 1
        1 0
        1 1
        5 0
        5 5
        0 2
        0 3
        1 2
        1 3
        2 2
        2 3
        1 4
        1 5
        2 4
        2 5
        3 4
        3 5
        0 4
        0 5
        3 2
        3 3
        2 0
        2 1
        3 0
        3 1
        4 2
        4 3
        4 4
        4 0
        4 1
        """;

    StringBuilder builder = new StringBuilder();
    SalvoController controller = new SalvoController(new StringReader(input),
        builder, player1, player2);
    assertDoesNotThrow(() -> controller.run());

    String output = """
        Hello! Welcome to the OOD BattleSalvo Game!
        Please enter a valid height and width below:
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed size 6.
        Opponent Board:
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
        Your Board:
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [35mB [0m[35mB [0m[35mB [0m[35mB [0m[35mB [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[33mD [0m[33mD [0m[33mD [0m[33mD [0m
          [34m0 [0m[34m0 [0m[32mS [0m[32mS [0m[32mS [0m[34m0 [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
        Please Enter 6 Shots:
        Opponent Board:
          [37mM [0m[37mM [0m[34m0 [0m[34m0 [0m[34m0 [0m[37mM [0m
          [37mM [0m[37mM [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[37mM [0m
        Your Board:
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [31mC [0m[31mC [0m[31mC [0m
          [35mB [0m[41m[30mH[0m [35mB [0m[35mB [0m[35mB [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[33mD [0m[33mD [0m[41m[30mH[0m [33mD [0m
          [34m0 [0m[34m0 [0m[32mS [0m[32mS [0m[32mS [0m[34m0 [0m
          [31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m[31mC [0m
          [31mC [0m[31mC [0m[31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
        Please Enter 6 Shots:
        Opponent Board:
          [37mM [0m[37mM [0m[34m0 [0m[34m0 [0m[34m0 [0m[37mM [0m
          [37mM [0m[37mM [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m[37mM [0m
        Your Board:
          [41m[30mH[0m [31mC [0m[41m[30mH[0m [31mC [0m[31mC [0m[41m[30mH[0m\s
          [35mB [0m[41m[30mH[0m [35mB [0m[35mB [0m[35mB [0m[34m0 [0m
          [34m0 [0m[34m0 [0m[33mD [0m[33mD [0m[41m[30mH[0m [33mD [0m
          [34m0 [0m[34m0 [0m[32mS [0m[41m[30mH[0m [32mS [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
          [31mC [0m[31mC [0m[31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
        Please Enter 6 Shots:
        Opponent Board:
          [37mM [0m[37mM [0m[34m0 [0m[34m0 [0m[34m0 [0m[37mM [0m
          [37mM [0m[37mM [0m[34m0 [0m[34m0 [0m[34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
          [34m0 [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
        Your Board:
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m[41m[30mH[0m\s
          [35mB [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [35mB [0m[37mM [0m
          [34m0 [0m[34m0 [0m[33mD [0m[33mD [0m[41m[30mH[0m [33mD [0m
          [34m0 [0m[34m0 [0m[41m[30mH[0m [41m[30mH[0m [32mS [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
          [41m[30mH[0m [31mC [0m[31mC [0m[41m[30mH[0m [41m[30mH[0m [31mC [0m
        Please Enter 6 Shots:
        Opponent Board:
          [37mM [0m[37mM [0m[41m[30mH[0m [34m0 [0m[34m0 [0m[37mM [0m
          [37mM [0m[37mM [0m[41m[30mH[0m [34m0 [0m[34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
        Your Board:
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [31mC [0m[31mC [0m[41m[30mH[0m\s
          [35mB [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [35mB [0m[37mM [0m
          [34m0 [0m[34m0 [0m[41m[30mH[0m [33mD [0m[41m[30mH[0m [33mD [0m
          [34m0 [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
        Please Enter 5 Shots:
        Opponent Board:
          [37mM [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
          [37mM [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [34m0 [0m[34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
        Your Board:
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
          [34m0 [0m[34m0 [0m[41m[30mH[0m [33mD [0m[41m[30mH[0m [33mD [0m
          [34m0 [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [37mM [0m
          [41m[30mH[0m [41m[30mH[0m [31mC [0m[41m[30mH[0m [41m[30mH[0m\s"""
        + """
        [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
        Please Enter 2 Shots:
        Opponent Board:
          [37mM [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [37mM [0m
          [37mM [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [34m0 [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [34m0 [0m[37mM [0m
        Your Board:
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [37mM [0m
          [37mM [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m\s
          [37mM [0m[37mM [0m[41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [37mM [0m
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
          [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH[0m [41m[30mH"""
        + """
        [0m [41m[30mH[0m\s
        YOU LOSE""";

    assertEquals(output, builder.toString());
  }
}