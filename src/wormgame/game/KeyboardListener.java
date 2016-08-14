/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.game;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wormgame.Direction;
import wormgame.domain.*;

/**
 *
 * @author Peter
 */
public class KeyboardListener implements KeyListener{
    Component component;
    Worm worm;
    Projectiles projectiles;

    public KeyboardListener(Component component, WormGame game) {
        this.component = component;
        this.worm = game.getWorm();
        this.projectiles = game.getProjectiles();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case KeyEvent.VK_LEFT: worm.setDirection(Direction.LEFT);
            break;
            case KeyEvent.VK_RIGHT: worm.setDirection(Direction.RIGHT);
            break;
            case KeyEvent.VK_UP: worm.setDirection(Direction.UP);
            break;
            case KeyEvent.VK_DOWN: worm.setDirection(Direction.DOWN);
            break;
            case KeyEvent.VK_SPACE: projectiles.add(worm.shoot());
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        }

    @Override
    public void keyTyped(KeyEvent ke) {
        }
    
}
