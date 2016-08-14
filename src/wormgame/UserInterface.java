/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import wormgame.game.KeyboardListener;
import wormgame.game.WormGame;
import wormgame.gui.DrawingBoard;

/**
 *
 * @author Peter
 */
public class UserInterface implements Runnable{
    private JFrame frame;
    private WormGame wormgame;
    private DrawingBoard drawingboard;
    private int sideLength;
    
    public UserInterface(WormGame wormgame, int sideLength){
        this.wormgame = wormgame;
        this.sideLength = sideLength;
    }

    @Override
    public void run() {
        frame = new JFrame("Sna... worm");
        frame.setPreferredSize(new Dimension(500, 500));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.addKeyListener(new KeyboardListener(frame, wormgame));
        
        frame.pack();
        frame.setVisible(true);
        }
    
    private void createComponents(Container container){
        drawingboard = new DrawingBoard(wormgame, 20);
        container.add(drawingboard);
        
    }
    
    public Updatable getUpdatable(){
        return this.drawingboard;
    }
    
    public JFrame getFrame(){
        return frame;
    }
}
