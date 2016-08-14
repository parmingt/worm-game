/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame;

import javax.swing.SwingUtilities;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

/**
 *
 * @author Peter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WormGame game = new WormGame(500,500);

        UserInterface ui = new UserInterface(game, 20);
        SwingUtilities.invokeLater(ui);

        while (ui.getUpdatable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("The drawing board hasn't been created yet.");
            }
        }
        System.out.println("C");

        game.setUpdatable(ui.getUpdatable());
        game.start();
        System.out.println("E");
    }
    
}
