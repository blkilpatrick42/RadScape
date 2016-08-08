package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Actor{
	public String playerName;
	public int level;
	public ItemInventory inventory = new ItemInventory(40);
	public transient VisualAnimated aspect;
	public boolean canExitDoor = false;
	public boolean wL = false;
	public boolean wR = false;
	public boolean wU = false;
	public boolean wD = false;
	public int gridX;
	public int gridY;
	public Player(int locX, int locY, int inGridX, int inGridY, int image, String inName){
		gridX = inGridX;
		gridY = inGridY;
		aspect = new VisualAnimated("worldArt/actors/playable/"+image+".png",20,4,12);
		colBox = new Rectangle();
		aspect.parkSprite(0,0);
		aspect.transformX(3, 16);
		aspect.transformY(3, 16);
		aspect.transformX(locX, 20);
		aspect.transformY(locY, 20);
		
		

		
		 //Reader.setMusic("sound/music/exploreA.wav");
//	     Character	guy1 = new Character("guy1.png","guy1.chr","guy1.wander",1,1,12,14);
//	     Character	guy2 = new Character("guy1.png","guy2.chr","guy2.wander",1,1,7,11);
//	     Character	guy3 = new Character("girl1.png","guy3.chr","guy3.wander",1,1,15,1);
//	     Item item1 = new Item("pie", "a slice of pie", 0, 0,18,13);
//	     Item item2 = new Item("pie", "a slice of pie", 0, 0,18,20);
//	     Item item3 = new Item("bikeTire", "an old bike tire", 0, 1,8,9);
//	     Item item4 = new Item("bikeTire", "a bent bike tire", 0, 1,19,11);
//	     Item item5 = new Item("ball", "a big red ball", 1, 1,20,6);
//	     Reader.saveOverWorld(RadScape.overworld, "worldDef.bucket");
        playerName = inName;
        level = 1;
		
		//RadScape.overworld.getNode(0, 0).add(guy1);
	}
	
	public void walkRight(){
		aspect.setLine(3);
		aspect.animate();
		aspect.transformX(1,1);
		if(!canExitDoor){
			canExitDoor = true;
		}
		wR = true;
	}
	public void walkLeft(){
		aspect.setLine(2);
		aspect.animate();
		aspect.transformX(-1,1);
		if(!canExitDoor){
			canExitDoor = true;
		}
		wL = true;
	}
	public void walkUp(){
		aspect.setLine(1);
		aspect.animate();
		aspect.transformY(1,1);
		if(!canExitDoor){
			canExitDoor = true;
		}
		wU = true;
	}
	public void walkDown(){
		aspect.setLine(0);
		aspect.animate();
		aspect.transformY(-1,1);
		if(!canExitDoor){
			canExitDoor = true;
		}
		wD = true;
	}
	
	public void update(){
        colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY(), aspect.getSprite().getWidth(), aspect.getSprite().getHeight());
		aspect.update();
		if(!wR&&!wL&&!wD&&!wU&&aspect.animate){
			aspect.stopAnimate(0, aspect.animateLine);
		}
		
		//wrap screen and load map code
		if(getX()>640+(3*16)){
			aspect.setPos(0+(3*16),getY(),1);
			gridX++;
			RadScape.curMap.exit('e');
		}
		else if(getX()<-21+(3*16)){
			aspect.setPos(620+(3*16),getY(),1);
			gridX--;
			RadScape.curMap.exit('w');
		}
		else if(getY()>480+(3*16)){
			aspect.setPos(getX(),0+(3*16),1);
			gridY++;
			RadScape.curMap.exit('n');
		}
		else if(getY()<-21+(3*16)){
			aspect.setPos(getX(),460+(3*16),1);
			gridY--;
			RadScape.curMap.exit('s');
		}
	}
	
	public float getX(){
		return aspect.getSprite().getX();
	}
	public float getY(){
		return aspect.getSprite().getY();
	}
	
	public void setGridX(int x){
		gridX = x;
	}
	
	public void setGridY(int y){
		gridY = y;
	}
	
	public void snapShotAspect(){
    	aspectString = aspect.recallString;          
    	aspectX = (int)aspect.getSprite().getX();    
    	aspectY = (int)aspect.getSprite().getY();
    	aspectWidth = aspect.width;
    	aspectHeight = aspect.height;
    	aspectSpeed = aspect.animateSpeed;
    	aspectAnimateLine = aspect.animateLine;   //unused
    	aspectLength = aspect.length;    
    	aspectUpdateCounter = aspect.updateCounter;    //unused
    	aspectAnimate = aspect.animate;                //unused
    	for(int i = 0; i < inventory.logSize; i++){
    		inventory.items[i].snapShotAspect();
    	}
    }
    
    public void loadSnapshot(){
    	aspect = new VisualAnimated(aspectString,aspectWidth,aspectHeight,aspectLength,aspectSpeed);
    	aspect.setPos(aspectX, aspectY, 1);
    	aspect.parkSprite(0, 0);
    	for(int i = 0; i < inventory.logSize; i++){
    		inventory.items[i].loadSnapshot();
    	}
    }
}
