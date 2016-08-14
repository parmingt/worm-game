/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Peter
 */
public class Apple extends Piece implements Visible{
    
    public Apple(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int pieceLength) {
        g.setColor(Color.green);
        g.fillOval(x, y, pieceLength, pieceLength);
    }
    
}
