package com.mygdx.game;
import com.mygdx.game.VisualAspect;
public abstract class HudEntity extends Entity{
    boolean visible = true;
    
    //Sets the hudEntity as either
    //VISIBLE or INVISIBLE
    //@param boolean representing visibility where true=visible
    public void setVisible(Boolean isVisible){
        visible = isVisible;
    }
    
    //returns whether the hudEntity is visible
    public Boolean isVisible(){
        return visible;
    }
    
    //general method for interacting with the given hudentity
    //ie what should happen when it is clicked on
    public void interact(){
        return;
    }
}
