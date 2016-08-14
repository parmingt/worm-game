/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.Updatable;
import wormgame.domain.Apple;
import wormgame.domain.Projectiles;
import wormgame.domain.Visibles;
import wormgame.domain.Worm;

/**
 *
 * @author Peter
 */
public class WormGame{
    private Worm worm;
    private Apple apple;
    private Projectiles projectiles;
    private Random rn;
    private int width;
    private int height;
    private Updatable drawingboard;
    Timer timer;
    Visibles visibles;

    public WormGame(int width, int height) {
        rn = new Random();
        
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        this.apple = new Apple(rn.nextInt(width), rn.nextInt(height));
        this.projectiles = new Projectiles();
        
        this.width = width;
        this.height = height;
        
        visibles = new Visibles();
        visibles.add(this.worm);
        visibles.add(this.apple);
        visibles.add(this.projectiles);
        
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                worm.move();

                if(worm.runsInto(apple)){
                    appleEaten();
                }
                
                projectiles.move();

                drawingboard.update();

                timer.setDelay(1000 / worm.getLength());
            }
        });
    }

  
    public Worm getWorm() {
        return worm;
    }

    public Apple getApple() {
        return apple;
    }
    
    public Projectiles getProjectiles(){
        return projectiles;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }
    
    public void setUpdatable(Updatable drawingBoard){
        this.drawingboard = drawingBoard;
    }
    
    public void start(){
        timer.start();
    }

    public void appleEaten(){
        worm.grow();
        visibles.remove(apple);
        apple = new Apple(rn.nextInt(width), rn.nextInt(height));
        visibles.add(apple);
    }
    
    public Visibles getVisibles(){
        return visibles;
    }
}
