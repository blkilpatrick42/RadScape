package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.RadScape;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Reader;
import com.mygdx.game.HudEntity;
public class newGameButton extends HudEntity{
	public newGameButton(int inX, int inY){
		aspect = new VisualAspect("hud/hudCards/menuB/newGameButton.png", inX, inY);
		
		updateColBox();
	}
	public void interact(){
		RadScape.hudCards.add(new newGameCard());
		RadScape.active=RadScape.hudCards.size()-1;
	}
}
