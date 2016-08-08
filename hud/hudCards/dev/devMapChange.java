package com.mygdx.game.hud.hudCards.dev;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class devMapChange extends HudEntity{
	public devMapChange(int inX, int inY){
		aspect = new VisualAspect("changeMap.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		System.out.println("CHANGE MAP: ");
		String a = Reader.getInputString();
		String b = "maps/"+a;
		RadScape.curMap = new Map(b);
		RadScape.PLAYER.gridX = RadScape.curMap.gridX;
		RadScape.PLAYER.gridY = RadScape.curMap.gridY;
		System.out.println(RadScape.STATICSTRING);
	}
}
