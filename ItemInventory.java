package com.mygdx.game;

import java.io.Serializable;

public class ItemInventory implements Serializable{
	public Item items[];
	public int logSize = 0;
	public int logFull;
	
	public ItemInventory(int Size){
		items = new Item[Size];
		logFull = Size;
	}
	
	public Item get(int i){
		return items[i];
	}
	
	public boolean addItem(Item inItem){
		if(logSize == logFull){
			return false;
		}
		else{
			RadScape.overworld.getNode(inItem.gridX, inItem.gridY).remove(inItem);
			items[logSize] = inItem;
			logSize++;
			return true;
		}
		
	}
	
	public Item removeItem(int i){
		if(!(i>logFull||i>logSize)){
			Item temp = items[i];
			for(int x = i; x < logSize-1; x++){
				items[x] = items[x+1];
				
			}
			logSize--;
			return temp;
			
		}
		else
		return null;
	}
}
