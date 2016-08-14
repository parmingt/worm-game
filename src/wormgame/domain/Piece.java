/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import static java.lang.Math.abs;

/**
 *
 * @author Peter
 */
public class Piece {
    protected int x;
    protected int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean runsInto(Piece piece){
        return abs(piece.getX() - x) <= 20 && abs(piece.getY() - y) <= 20;
    }
    
    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
    
}
