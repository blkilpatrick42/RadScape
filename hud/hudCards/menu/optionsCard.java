package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.hud.*;
import com.mygdx.game.hud.hudCards.backButton;
import com.mygdx.game.hud.hudCards.keyBoard;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Reader;
public class optionsCard extends hudCard{
	public optionsCard(){
		lockScroll = true;
		cardEntities = new HudEntity[7];
		int yStart = 116;
		int yAlign = 32+22;
		cardEntities[0] = new musicVolDown(720+248,315);
		cardEntities[1] = new musicVolUp(720+248,350);
		cardEntities[2] = new soundVolDown(720+248,247);
		cardEntities[3] = new soundVolUp(720+248,282);
		cardEntities[4] = new ambientVolDown(720+248,177);
		cardEntities[5] = new ambientVolUp(720+248,212);
		cardEntities[6] = new backButton(0,720+6,60);
		title = "Options";
		
	}
	
	public void update(){
		localText = "\n MUSIC VOLUME \n\n\n\n FX VOLUME \n\n\n\n AMBIENT VOLUME ";
	}
}
