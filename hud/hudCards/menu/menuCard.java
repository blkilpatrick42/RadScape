package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.hud.*;
import com.mygdx.game.HudEntity;
public class menuCard extends hudCard{
	public menuCard(){
		cardEntities = new HudEntity[4];
		cardEntities[0] = new newGameButton(720+6,332);
		cardEntities[1] = new loadButton(720+6,292);
		cardEntities[3] = new optionsButton(720+6,250);
		cardEntities[2] = new quitButton(720+6,208);
		
		title = "Menu";
	}
}
