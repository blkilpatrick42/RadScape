package com.mygdx.game.hud.hudCards.dev;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class devStaticDoorButton extends HudEntity{
	public devStaticDoorButton(int inX, int inY){
		aspect = new VisualAspect("staticDoorButtonA.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		RadScape.PLACEMODE = true;
		RadScape.DOORMODE = true;
		System.out.println("STATIC DOOR: ");
		String a = Reader.getInputString();
		RadScape.setStaticString(a);
		System.out.println(RadScape.STATICSTRING);
		System.out.println("MAP TO TELEPORT: ");
		a = Reader.getInputString();
		RadScape.setDoorTeleString(a);
		System.out.println(RadScape.DOORTELESTRING);
		System.out.println("TELEPORT X: ");
		int b = Reader.getInt();
		RadScape.setDoorTeleX(b);
		System.out.println("TELEPORT Y: ");
		int c = Reader.getInt();
		RadScape.setDoorTeleY(c);
	}
}
