package com.mygdx.game.hud.hudCards.dev;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class devDeleteButton extends HudEntity{
	public devDeleteButton(int inX, int inY){
		aspect = new VisualAspect("deleteButton.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		if(!RadScape.DELETEMODE){
			RadScape.DELETEMODE = true;
			RadScape.hudPrinter.type("DELETE MODE");
		}
		else{
			 RadScape.DELETEMODE = false;
			 RadScape.hudPrinter.type("DELETE MODE OFF");
		}
	}
}
