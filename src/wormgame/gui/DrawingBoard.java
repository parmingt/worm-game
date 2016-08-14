/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import wormgame.Updatable;
import wormgame.domain.Apple;
import wormgame.game.*;
import wormgame.domain.Piece;
import wormgame.domain.Projectile;
import wormgame.domain.Projectiles;
import wormgame.domain.Worm;

/**
 *
 * @author Peter
 */
public class DrawingBoard extends JPanel implements Updatable{
    WormGame wormgame;
    Apple apple;
    int pieceLength;
    Timer timer;
    Projectiles projectiles;
    
    public DrawingBoard(WormGame wormgame, int pieceLength){
        super.setBackground(Color.WHITE);
        this.wormgame = wormgame;
        this.pieceLength = pieceLength;
        this.projectiles = wormgame.getProjectiles();
    }
    
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        wormgame.getVisibles().draw(g, pieceLength);
    }

    @Override
    public void update() {
        //System.out.println("Painting");
        repaint();
    }


}
