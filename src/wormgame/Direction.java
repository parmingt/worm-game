/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame;

/**
 *
 * @author Peter
 */
public enum Direction {
    LEFT("left"),
    RIGHT("right"), 
    UP("up"), 
    DOWN("down");
    
    private String name;
    
    private Direction(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
