package com.mygdx.game;
import java.io.Serializable;
public class DynamicEntity extends Entity implements Serializable{
	public int gridX;
	public int gridY;
	public transient VisualAnimated aspect;
	boolean solid = false;
	public String lookDescription = "";
	
	
	//Variables used for snapshotting and instatiation visualAnimated aspect
	public String aspectString;
	public int aspectX;
	public int aspectY;
	public int aspectWidth;
	public int aspectHeight;
	public int aspectSpeed;
	public int aspectAnimateLine;
	public int aspectLength;
	public int aspectUpdateCounter;
	public boolean aspectAnimate;
	
	//general use 'interact' method to be overridden
    //by dynamicentities which inherit from this class.
    //method general represents what happens when
    //the player approaches the entity and 'interacts' with it
    public void interact(){
        return;
    }
    
    //takes a snapshot of all of the relevant information in the 
    //local visualAnimated object. This is so that one can
    //reduce the visualAnimated to purely serializable types,
    //which can later be used to re-instantiate the visualAnimated
    public void snapShotAspect(){
    	aspectString = aspect.recallString;          
    	aspectX = (int)aspect.getSprite().getX();    
    	aspectY = (int)aspect.getSprite().getY();
    	aspectWidth = aspect.width;
    	aspectHeight = aspect.height;
    	aspectSpeed = aspect.animateSpeed;
    	//aspectAnimateLine = aspect.animateLine;   //unused
    	aspectLength = aspect.length;    
    	//aspectUpdateCounter = aspect.updateCounter;    //unused
    	//aspectAnimate = aspect.animate;                //unused
    }
    
    public void loadSnapshot(){
    	aspect = new VisualAnimated(aspectString,aspectWidth,aspectHeight,aspectLength,aspectSpeed);
    	aspect.setPos(aspectX, aspectY, 1);
    	aspect.parkSprite(0, 0);
    }
    
    public void removeSelf(){
    	RadScape.overworld.getNode(gridX, gridY).remove(this);
    }
}
