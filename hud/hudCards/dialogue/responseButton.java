package com.mygdx.game.hud.hudCards.dialogue;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Response;
import com.mygdx.game.Dialogue;
public class responseButton extends HudEntity{
	Response locResponse;
	public responseButton(Response response, int inX, int inY){
		locResponse = response;
		aspect = new VisualAspect("hud/hudCards/dialogue/responseBox.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		if(locResponse.nextAct==-2){
			return;
		}
		else if(locResponse.nextAct==-1){
			RadScape.dialogue.exit();
		}
		else if(locResponse.nextAct<-2){
			return;
			//TODO write exit into battle code
		}
		else{
			Reader.addToStatusList(locResponse.setCode);
			RadScape.dialogue.cardDialogue.setCurNode(locResponse.nextAct);
			RadScape.dialogue.updateResponses();
		}
	}
}
