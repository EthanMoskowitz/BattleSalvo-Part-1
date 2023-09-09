package cs3500.pa03;

import cs3500.pa03.controller.Controller;
import cs3500.pa03.controller.SalvoController;
import cs3500.pa03.model.AiModel;
import cs3500.pa03.model.PlayerModel;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    PlayerModel player1 = new PlayerModel("Your", new Random());
    AiModel player2 = new AiModel("Opponent", new Random());
    Controller controller = new SalvoController(new InputStreamReader(System.in), System.out,
        player1, player2);
    controller.run();
  }
}