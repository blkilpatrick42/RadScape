package com.mygdx.game.hud;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
public class hudRightScroller extends HudEntity{
	VisualAspect aspects[];
	boolean counting = false;
	int counter = 0;
	public hudRightScroller(int inx, int iny){
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/rightArrow.png",inx,iny);
		aspects[1] = new VisualAspect("hud/rightArrowPress.png",inx,iny);
		aspect = aspects[0];
		updateColBox();
	}
	
	public void interact(){
		aspect = aspects[1];
		counting = true;
		if(RadScape.active != RadScape.hudCards.size()-1){
			RadScape.active++ ;
		}
	}
	
	public void update(){
		if(counting){
			counter++;
		}
		if(counter>5){
			aspect = aspects[0];
			counter = 0;
			counting = false;
		}
	}
}
