package com.mygdx.game.hud;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
public class hudUpScroller extends HudEntity{
	VisualAspect aspects[];
	int counter = 0;
	boolean count = false;
	public hudUpScroller(int inx, int iny){
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/upArrow.png",inx,iny);
		aspects[1] = new VisualAspect("hud/upArrowPress.png",inx,iny);
		aspect = aspects[0];
		updateColBox();
	}
	
	public void interact(){
		aspect = aspects[1];
		count = true;
		if(RadScape.hudPrinterCurrent < 9){
			RadScape.hudPrinterCurrent++ ;
		}
		
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
