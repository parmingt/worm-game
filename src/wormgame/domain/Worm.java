/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author Peter
 */
public class Worm implements Visible{
    int originalX;
    int originalY;
    Direction originalDirection;
    int length;
    List<Piece> pieces;
    Direction direction;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        this.direction = originalDirection;
        this.length = 1;
        pieces = new ArrayList<>();
        pieces.add(new Piece(originalX, originalY));
    }
    
    public Direction getDirection(){
        return direction;
    }
    
    public void setDirection(Direction dir){
        direction = dir;
    }
    
    public int getLength(){
        return length;
    }
    
    public List<Piece> getPieces(){
        return pieces;
    }
    
    public void move(){
        int dX = 0;
        int dY = 0;
        
        if(pieces.size() < 3){
            grow();
        }
        
        switch(this.direction.toString()){
            case "left": dX = -10;
            break;
            case "right": dX = 10;
            break;
            case "up": dY = -10;
            break;
            case "down": dY = 10;
            break;
        }
        
        int oldX = pieces.get(pieces.size()-1).getX();
        int oldY = pieces.get(pieces.size()-1).getY();
        Piece newPiece = new Piece(oldX + dX, oldY + dY);
        pieces.add(newPiece);
        
        for(int i = 0; i < pieces.size() - length; i++){
            pieces.remove(i);
        }
    
        
    }
    
    public void grow(){
        length++;
    }
    
    public boolean runsInto(Piece otherPiece){
        for(Piece piece : pieces){
            if(piece.runsInto(otherPiece)){
                System.out.println("Collision!");
                return true;
            } 
        }
        return false;
    }
    
    public boolean runsIntoItself(){
        
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                if(pieces.get(i).runsInto(pieces.get(j))){
                    return true;
                }
            }
        }
        return false;
    }
    
    public Projectile shoot(){
        int x = pieces.get(length - 1).getX();
        int y = pieces.get(length - 1).getY();
        Projectile projectile = new Projectile(x, y, this.direction);
        return projectile;
    }

    @Override
    public void draw(Graphics g, int pieceLength) {
        g.setColor(Color.black);
        for (Piece piece : pieces){
            g.fillRect(piece.getX() - pieceLength / 2, 
                    piece.getY() - pieceLength / 2,
                    pieceLength, 
                    pieceLength);
        }
    }
}
