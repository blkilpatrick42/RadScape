package com.mygdx.game.hud.hudCards.dev;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class devWorldDefButton extends HudEntity{
	public devWorldDefButton(int inX, int inY){
		aspect = new VisualAspect("worldDefButton.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		Reader.saveOverWorld(RadScape.overworld, "worldDef.bucket");
		RadScape.hudPrinter.type("Current world state output to worldDef.bucket");
	}
}
