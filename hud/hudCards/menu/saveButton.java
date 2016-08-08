package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class saveButton extends HudEntity{;
	VisualAspect aspects[];
	int counter = 0;
	boolean count = false;
	public saveButton(int inX, int inY){
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/hudcards/saveButton.png", inX, inY);
		aspects[1] = new VisualAspect("hud/hudcards/saveButtonPressed.png", inX, inY);
		aspect = aspects[0];
		updateColBox();
	}
	public void interact(){
		aspect = aspects[1];
		count = true;
		Reader.saveGame();
	}
	
	public void update(){
		if(count){
			counter++;
			if(counter>5){
				aspect = aspects[0];
				counter = 0;
				count = false;
				
				return;
			}
		}
	}
}
