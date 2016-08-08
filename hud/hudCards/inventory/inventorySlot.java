package com.mygdx.game.hud.hudCards.inventory;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class inventorySlot extends HudEntity{
	boolean clickAndDragMode = false;
	boolean filled = false;
	int returnX;
	int returnY;
	int slotNumber;
	VisualAspect aspects[];
	InventoryCard card;
	public inventorySlot(int inX, int inY, int slot, InventoryCard inCard){
		card = inCard;
		returnX = inX;
		returnY = inY;
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/hudCards/inventory/box.png", inX, inY);
		aspect = aspects[0];
		slotNumber = slot;
		updateColBox();
	}
	public void interact(){
		if(clickAndDragMode){
			//drop code
			if(RadScape.pointer.isOverWorldWindow()){
				RadScape.PLAYER.inventory.removeItem(slotNumber).release((int)RadScape.curMap.gridX,(int)RadScape.curMap.gridY,(int)RadScape.PLAYER.getX(), (int)RadScape.PLAYER.getY(), 1);
				clickAndDragMode = false;
				card.lockClickAndDrag = false;
				card.switchEnts(slotNumber,39);
			}
			else{
				clickAndDragMode = false;
				card.lockClickAndDrag = false;
				card.switchEnts(slotNumber,39);
			}
		}
		else if(filled&&!card.lockClickAndDrag){
			clickAndDragMode = true;
			card.lockClickAndDrag = true;
			card.switchEnts(slotNumber,39);
			RadScape.hudPrinter.print(RadScape.PLAYER.inventory.items[slotNumber].lookDescription, true);
		}
	}
	
	public void update(){
		updateColBox();
		if(slotNumber >= RadScape.PLAYER.inventory.logSize){
			
			aspect = aspects[0];
			aspects[1] = null;
			filled = false;
		}
		else if(slotNumber < RadScape.PLAYER.inventory.logSize){
				
				aspects[1] = new VisualAspect("items/"+RadScape.PLAYER.inventory.items[slotNumber].name+"I.png",returnX,returnY);
				aspect = aspects[1];
				filled = true;
			
		}
		if(clickAndDragMode){
			aspect.setPos(RadScape.pointer.aspect.getSprite().getX()-10, RadScape.pointer.aspect.getSprite().getY()+10, 1);
		}
		else{
			aspect.setPos(returnX, returnY, 1);
		}
	}
}
