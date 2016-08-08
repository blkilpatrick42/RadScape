package com.mygdx.game.hud.hudCards;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class backButton extends HudEntity{
	int setActive;
	VisualAspect aspects[];
	int counter = 0;
	boolean count = false;
	public backButton(int inSetActive, int inX, int inY){
		aspects = new VisualAspect[2];
		setActive = inSetActive;
		aspects[0] = new VisualAspect("hud/hudcards/backButton.png", inX, inY);
		aspects[1] = new VisualAspect("hud/hudcards/backButtonPressed.png", inX, inY);
		aspect = aspects[0];
		updateColBox();
	}
	public void interact(){
		count = true;
		aspect = aspects[1];
		if(setActive == -2){
			//NOTE THAT THE -2 CASE IS IDENTICAL TO -1 BUT DOES NOT REMOVE THE HUDCARD.
			//THIS IS FOR NAVIGATING GROUPS OF SCROLLLOCKED HUDCARDS.
			RadScape.active = RadScape.active-1;
		}
		if(setActive == -1){
			//THE -1 CASE BACKS UP INTO THE SECOND MOST RECENTLY ADDED CARD/
			//THIS IS MOSTLY FOR USE WITH GROUPS OF SCROLLLOCKED CARDS.
			RadScape.active = RadScape.hudCards.size()-2;
			RadScape.hudCards.remove(RadScape.hudCards.get(RadScape.hudCards.size()-1));
		}
		else{
			RadScape.active = setActive;
			RadScape.hudCards.remove(RadScape.hudCards.get(RadScape.hudCards.size()-1));
		}
		
	}
	
	public void update(){
		if(count){
			counter++;
			if(counter>5){
				aspect = aspects[0];
				counter = 0;
				count = false;
				
				//TODO can we get it so the button clicks and THEN backs out?
				//Come to think of it, doing this for buttons which dont remove
				//their own cards should be fairly easy. Low priority.
				
				return;
			}
		}
	}
}
