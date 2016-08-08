package com.mygdx.game.hud.hudCards.dev;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class devStaticQuickPlace extends HudEntity{
	public devStaticQuickPlace(int inX, int inY){
		aspect = new VisualAspect("staticButtonB.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		RadScape.PLACEMODE = true;
		System.out.println(RadScape.STATICSTRING);
	}
}
