package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAnimated;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class modelPortrait extends HudEntity{
	int counter = 0; 
	int counter2 = 0;
	int x;
	int y;
	public modelPortrait(int modelNumber, int inX, int inY){
		x = inX;
		y = inY;
		aspect = new VisualAnimated("worldArt/actors/playable/"+modelNumber+".png", 20,4,0 );
		((VisualAnimated) aspect).parkSprite(0, 0);
		aspect.setPos(x, y, 1);
	}
	public void changePortrait(int modelNumber){
		aspect = new VisualAnimated("worldArt/actors/playable/"+modelNumber+".png", 20,4,0 );
		((VisualAnimated) aspect).parkSprite(0, 0);
		aspect.setPos(x, y, 1);
	}
	public void update(){
		
		if(counter>20){
			if(counter2==3){
				counter2 = 0;
			}
			else{
				counter2++;
			}
			
			counter = 0;
			if(counter2 == 0){
				((VisualAnimated)aspect).parkSprite(0, 0);
			}
			else if(counter2 == 1){
				((VisualAnimated)aspect).parkSprite(0, 2);
			}
			else if(counter2 == 2){
				((VisualAnimated)aspect).parkSprite(0, 1);
			}
			else if(counter2 == 3){
				((VisualAnimated)aspect).parkSprite(0, 3);
			}
		}
		else{
			counter++;
		}
	}
}
