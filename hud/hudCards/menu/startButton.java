package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.Player;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class startButton extends HudEntity{;
	VisualAspect aspects[];
	int counter = 0;
	boolean count = false;
	newGameCardB cardB;
	public startButton(newGameCardB inCardB, int inX, int inY){
		cardB = inCardB;
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/hudcards/startButton.png", inX, inY);
		aspects[1] = new VisualAspect("hud/hudcards/startButtonPressed.png", inX, inY);
		aspect = aspects[0];
		updateColBox();
	}
	public void interact(){
		aspect = aspects[1];
		count = true;
		String name = cardB.newPlayerName;
		int modelNo = cardB.modelNumber;
		RadScape.PLAYER = new Player(RadScape.playerBeginX, RadScape.playerBeginY, RadScape.playerBeginGridX, RadScape.playerBeginGridY, modelNo, name);
		RadScape.windowMode = 'w';
		RadScape.curMap = new Map("maps/map"+RadScape.PLAYER.gridX+RadScape.PLAYER.gridY);
		RadScape.loadPlayGameDeck();
		Reader.stopMusic();
	}
	
	public void update(){
		if(count){
			counter++;
			if(counter>5){
				aspect = aspects[0];
				counter = 0;
				count = false;				
				return;
			}
		}
	}
}
