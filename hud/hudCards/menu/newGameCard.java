package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.hud.*;
import com.mygdx.game.hud.hudCards.backButton;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Player;
import com.mygdx.game.Reader;
public class newGameCard extends hudCard{
	public newGameCard(){
		lockScroll = true;
		cardEntities = new HudEntity[6];
		int yStart = 116;
		int yAlign = 32+22;
		cardEntities[0] = new slotBoxButton(true,1,722,yStart+4*yAlign);
		cardEntities[1] = new slotBoxButton(true,2,722,yStart+3*yAlign);
		cardEntities[2] = new slotBoxButton(true,3,722,yStart+2*yAlign);
		cardEntities[3] = new slotBoxButton(true,4,722,yStart+yAlign);
		cardEntities[4] = new slotBoxButton(true,5,722,yStart);
		cardEntities[5] = new backButton(0,720+6,60);
		title = "New Game";
		String temp;
		localText+="\n";
		Player tempPlayer;
		for(int i = 1; i < 6; i++){
			tempPlayer = Reader.loadPlayer("save/slot"+i+"/player.dat");
			if(tempPlayer == null){
				localText += "  <Empty>";
			}
			else{
				localText +="   "+tempPlayer.playerName+" LEVEL: "+tempPlayer.level;
			}
			localText +="\n\n\n";
		}
		tempPlayer = null;
	}
}
