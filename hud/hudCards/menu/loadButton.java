package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.RadScape;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.HudEntity;
public class loadButton extends HudEntity{
	public loadButton(int inX, int inY){
		aspect = new VisualAspect("hud/hudCards/menuB/loadGameButton.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		RadScape.hudCards.add(new loadGameCard());
		RadScape.active=RadScape.hudCards.size()-1;
	}
}
