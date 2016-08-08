package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
public class modelPortraitLeftScroller extends HudEntity{
	VisualAspect aspects[];
	newGameCardB parentCard;
	boolean counting = false;
	int counter = 0;
	public modelPortraitLeftScroller(newGameCardB inParentCard, int inx, int iny){
		parentCard = inParentCard;
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/leftArrow.png",inx,iny);
		aspects[1] = new VisualAspect("hud/leftArrowPress.png",inx,iny);
		aspect = aspects[0];
		updateColBox();
	}
	
	public void interact(){
		aspect = aspects[1];
		counting = true;
		if(parentCard.modelNumber>1){
			parentCard.modelNumber--;
			parentCard.portrait.changePortrait(parentCard.modelNumber);
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
