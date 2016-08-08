package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.hud.*;
import com.mygdx.game.hud.hudCards.backButton;
import com.mygdx.game.HudEntity;
public class saveGameCard extends hudCard{
	public saveGameCard(){
		lockScroll = true;
		lockPlayer = true;
		cardEntities = new HudEntity[2];
		cardEntities[0] = new saveButton(830,300);
		cardEntities[1] = new backButton(-1,720+6,60);
		title = "Save Game";
		localText = " \n                      Save the game?";
	}
}
