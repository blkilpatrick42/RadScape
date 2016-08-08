package com.mygdx.game.hud.hudCards.dev;
import com.mygdx.game.hud.*;
import com.mygdx.game.HudEntity;
import com.mygdx.game.RadScape;
public class devCard extends hudCard{
	public devCard(){
		cardEntities = new HudEntity[6];
		cardEntities[0] = new devStaticButton(720+32,208+32);
		cardEntities[1] = new devStaticQuickPlace(720+32,186);
		cardEntities[2] = new devMapChange(720+32,100);
		cardEntities[3] = new devStaticDoorButton(720+100,208+32);
		cardEntities[4] = new devWorldDefButton(720+100,186);
		cardEntities[5] = new devDeleteButton(720+100,140);
		title = "DevCard";
	}
	
	public void update(){
		localText = RadScape.STATICSTRING+" "+RadScape.pointer.getGridLocation()[0]+","+RadScape.pointer.getGridLocation()[1];
	}
}
