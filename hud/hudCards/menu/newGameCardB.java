package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.hud.*;
import com.mygdx.game.hud.hudCards.backButton;
import com.mygdx.game.hud.hudCards.keyBoard;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Player;
import com.mygdx.game.Reader;
public class newGameCardB extends hudCard{
	public int modelNumber = 1;
	public String newPlayerName;
	public keyBoard kybd;
	public modelPortrait portrait;
	public newGameCardB(){
		portrait = new modelPortrait(modelNumber,845,104);
		lockScroll = true;
		cardEntities = new HudEntity[5];
		cardEntities[0] = portrait;
		cardEntities[1] = new modelPortraitLeftScroller(this,808,100);
		cardEntities[2] = new modelPortraitRightScroller(this,870,100);
		cardEntities[3] = new backButton(-1,720+6,60);
		cardEntities[4] = new startButton(this,720+212,60);
		kybd = new keyBoard(740, 280, 21);
		cardEntities = kybd.appendKeyboard(cardEntities);
		title = "New Game";
	}
	
	public void update(){
		localText="\n NAME: "+kybd.typeString.toString()+"\n\n\n\n\n\n\n\n\n\n PLAYER IMAGE:";
		newPlayerName = kybd.typeString.toString();
	}
}
