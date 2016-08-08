package com.mygdx.game.hud.hudCards.inventory;
import com.mygdx.game.hud.*;
import com.mygdx.game.HudEntity;
import com.mygdx.game.ItemInventory;
public class InventoryCard extends hudCard{
	public boolean lockClickAndDrag = false;
	
	public InventoryCard(String entityTitle, ItemInventory inventory){
		int startX = 732;
		int startY = 264;
		int spacing = 25;
		int i = 0;
		
		cardEntities = new HudEntity[40];
		for(int y = 0; y < 6; y++){
			for(int x =0; x < 10; x++){
				if(i<40){
					cardEntities[i] = new inventorySlot(startX + spacing*x,startY+spacing*y,i,this);
					i++;
				}
			}
			
		}
		title = "Inventory";
	}
	
	
}
