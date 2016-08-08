package com.mygdx.game.hud.hudCards.dialogue;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class portrait extends HudEntity{
	public portrait(String inPort, int inX, int inY){
		aspect = new VisualAspect("worldArt/actors/portrait/"+inPort+".png", inX, inY);
		updateColBox();
	}
	public void changePortrait(String inPort){
		aspect = new VisualAspect("worldArt/actors/portrait/"+inPort+".png", (int)aspect.getSprite().getX(), (int)aspect.getSprite().getY());
	}
}
