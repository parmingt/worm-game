/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.awt.Graphics;

/**
 *
 * @author Peter
 */
public interface Visible {
    public void draw(Graphics g, int pieceLength);
}
