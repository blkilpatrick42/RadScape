
package com.mygdx.game.hud;
import com.mygdx.game.hud.hudPointer;
import com.mygdx.game.HudEntity;
public abstract class hudCard extends HudEntity{
    public HudEntity cardEntities[];
    public String localText = "";
    public String title;
    public boolean lockScroll = false;
    public boolean lockPlayer = false;
    //method for checking if the given hudpointer
    //is interacting with any of the card's
    //hudentities, and, if so, triggering the interact
    //event for the hud entity the pointer is touching
    //at the time
    public void checkEntities(hudPointer pointer){
    	for(int i = 0; i < cardEntities.length; i++){
    		if(cardEntities[i].collidesWith(pointer)){
    			cardEntities[i].interact();
    			return;
    		}
    	}
    	
    }
    
    public void switchEnts(int a, int b){
		HudEntity temp = cardEntities[b];
		cardEntities[b] = cardEntities[a];
		cardEntities[a] = temp;
	}
}
