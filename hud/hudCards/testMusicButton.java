package com.mygdx.game.hud.hudCards;
import com.mygdx.game.Map;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
public class testMusicButton extends HudEntity{
	public testMusicButton(int inX, int inY){
		aspect = new VisualAspect("testButton.png", inX, inY);
		updateColBox();
	}
	
	public void interact(){
		if(Reader.musicIsPlaying){
			Reader.stopMusic();
		}
		else{
			Reader.setMusic("sound/music/testMusicA.wav",false);
		}
	}
}
