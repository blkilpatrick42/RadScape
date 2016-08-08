package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class musicVolUp extends HudEntity{
	VisualAspect aspects[];
	int counter = 0;
	boolean count = false;
	public musicVolUp(int inx, int iny){
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/upArrow.png",inx,iny);
		aspects[1] = new VisualAspect("hud/upArrowPress.png",inx,iny);
		aspect = aspects[0];
		updateColBox();
	}
	
	public void interact(){
		aspect = aspects[1];
		count = true;
		Reader.musicVolume(true);
		
	}
	
	public void update(){
		if(count){
			counter++;
			if(counter > 5){
				count = false;
				counter = 0;
				aspect = aspects[0];
			}
		}
	}
}
