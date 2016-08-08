package com.mygdx.game;

public class Item extends DynamicEntity{
	//TODO add in hascodes, or otherwise figure out a good system for
	//determining if an item is in the inventory
	public int code;
	public String name;
	public Item(String inName, String lookDescrip, int inCode, int x, int y){
		code = inCode;
		lookDescription = lookDescrip;
		name = inName;
		aspect = new VisualAnimated("items/"+name+".png",20,2,0);
		initializeColBox();
		aspect.setPos(x, y, 20);
		aspect.parkSprite(0,0);
	}
	
	public Item(String inName, String lookDescrip, int inCode, int gridX, int gridY, int x, int y){
		code = inCode;
		name = inName;
		this.gridX = gridX;
		this.gridY = gridY;
		lookDescription = lookDescrip;
		aspect = new VisualAnimated("items/"+name+".png",20,1,0);
		initializeColBox();
		aspect.setPos(x, y, 20);
		RadScape.overworld.getNode(gridX, gridY).add(this);
		aspect.parkSprite(0,0);
		RadScape.overworld.getNode(gridX, gridY).add(this);
	}
	
	public void interact(){
		RadScape.PLAYER.inventory.addItem(this);
		RadScape.overworld.getNode(gridX, gridY).remove(this);
		Reader.playSound("sound/fx/bag.wav");
		Reader.STATUSLIST.add(code); //add the item's code to the status list
		RadScape.hudPrinter.print("You picked up "+lookDescription, true);
	}
	
	public void release(int gridX, int gridY, int x, int y, int align){
		this.gridX = gridX;
		this.gridY = gridY;
		aspect.setPos(x, y, align);
		Reader.playSound("sound/fx/bag.wav");
		Reader.STATUSLIST.remove((Integer)code); //remove the item's code to the status list
		RadScape.overworld.getNode(gridX, gridY).add(0,this);
	}
	
	public void update(){
		colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY(), aspect.getSprite().getWidth(), aspect.getSprite().getHeight());
	}
	
	
}
