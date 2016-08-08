package com.mygdx.game.hud;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
public class hudLeftScroller extends HudEntity{
	VisualAspect aspects[];
	boolean counting = false;
	int counter = 0;
	public hudLeftScroller(int inx, int iny){
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/leftArrow.png",inx,iny);
		aspects[1] = new VisualAspect("hud/leftArrowPress.png",inx,iny);
		aspect = aspects[0];
		updateColBox();
	}
	
	public void interact(){
		aspect = aspects[1];
		counting = true;
		if(RadScape.active != 0){
			RadScape.active -- ;
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
