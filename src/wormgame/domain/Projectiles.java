/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peter
 */
public class Projectiles implements Visible{
    List<Projectile> projectiles;
    
    public Projectiles(){
        projectiles = new ArrayList<>();
    }
    
    public void add(Projectile projectile){
        projectiles.add(projectile);
    }
    
    public void move(){
        for(Projectile projectile : projectiles){
            projectile.move();
        }
    }
    
    public List<Projectile> get(){
        return projectiles;
    }

    @Override
    public void draw(Graphics g, int pieceLength) {
        g.setColor(Color.yellow);
        for (Projectile projectile : projectiles){
            g.fillOval(projectile.getX(), projectile.getY(),
                    pieceLength / 3, pieceLength / 3);
        }
    }
    
}
