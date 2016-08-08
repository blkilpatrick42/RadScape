package com.mygdx.game.hud.hudCards;
import com.mygdx.game.hud.*;
import com.mygdx.game.HudEntity;
public class testCardB extends hudCard{
	public testCardB(){
		cardEntities = new HudEntity[3];
		cardEntities[0] = new testMapButton1(720+32,208+128);
		cardEntities[1] = new testMapButton3(720+64,208+32);
		cardEntities[2] = new testMusicButton(720+64,208+128);
		title = "TestCardB";
	}
}
