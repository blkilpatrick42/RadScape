package com.mygdx.game.hud.hudCards;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class testMapButton2 extends HudEntity{
	public testMapButton2(int inX, int inY){
		aspect = new VisualAspect("button2.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		RadScape.curMap = new Map("maps/map2");
	}
}
