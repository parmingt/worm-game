/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peter
 */
public class Visibles {
    List<Visible> visibles;
    
    public Visibles(){
        visibles = new ArrayList<>();
    }
    
    public void add(Visible visible){
        visibles.add(visible);
    }
    
    public List<Visible> getList(){
        return visibles;
    }
    
    public void remove(Visible visible){
        visibles.remove(visible);
    }
    
    public void draw(Graphics g, int piecelength){
        for(Visible visible : visibles){
            visible.draw(g, piecelength);
        }
    }
}
