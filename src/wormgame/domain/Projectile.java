/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import wormgame.Direction;

/**
 *
 * @author Peter
 */
public class Projectile extends Piece{
    private final Direction direction;
    private final int speed = 20;
    
    public Projectile(int x, int y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }
    
    public void move(){
        int dX = 0;
        int dY = 0;
        
        switch(this.direction.toString()){
            case "left": dX = -speed;
            break;
            case "right": dX = speed;
            break;
            case "up": dY = -speed;
            break;
            case "down": dY = speed;
            break;
        }
        
        super.x += dX;
        super.y += dY;
    }
}
