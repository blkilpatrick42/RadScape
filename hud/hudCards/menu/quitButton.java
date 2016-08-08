package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.RadScape;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.HudEntity;
public class quitButton extends HudEntity{
	boolean areYouSureStop = false;
	int timer = 0;
	VisualAspect quitAsp = new VisualAspect("hud/hudCards/menuB/quitButton.png");
	VisualAspect reallyAsp = new VisualAspect("hud/hudCards/menuB/reallyQuitButton.png");
	
	public quitButton(int inX, int inY){
		aspect = quitAsp;
		aspect.setPos(inX, inY, 1);
		reallyAsp.setPos(inX, inY, 1);
		updateColBox();
	}
	public void interact(){
		if(areYouSureStop){
			Gdx.app.exit();
		}
		else{
			areYouSureStop = true;
			aspect = reallyAsp;
		}
	}
	
	public void update(){
		if(areYouSureStop == true){
			timer++;	
		}
		if(timer > 100){
			areYouSureStop = false;
			aspect = quitAsp;
			timer = 0;
		}
		updateColBox();
	}
}
