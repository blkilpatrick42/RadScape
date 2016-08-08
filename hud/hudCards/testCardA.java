package com.mygdx.game.hud.hudCards;
import com.mygdx.game.hud.*;
import com.mygdx.game.HudEntity;
public class testCardA extends hudCard{
	public testCardA(){
		cardEntities = new HudEntity[3];
		cardEntities[0] = new testMapButton1(720+32,208+32);
		cardEntities[1] = new testMapButton2(720+64,208+32);
		cardEntities[2] = new testMapButton3(720+32,208+64);
		title = "TestCardA";
		localText = "\n Here's some text to test.\n\n\n\n\n\n\n\n\n\n\n\n\n Hello again.";
	}
}
