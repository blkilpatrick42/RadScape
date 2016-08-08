package com.mygdx.game.hud.hudCards.dialogue;
import com.mygdx.game.hud.*;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Dialogue;
import com.mygdx.game.RadScape;
public class dialogueCard extends hudCard{
	public Dialogue cardDialogue;
	public dialogueCard(Dialogue inDialogue){

		cardDialogue = inDialogue;
		cardDialogue.getStartNode();
		lockScroll = true;
		lockPlayer = true;
		cardEntities = new HudEntity[5];
		updateResponses();
		title = cardDialogue.name;
	}
	
	
	public void updateResponses(){
		RadScape.hudPrinter.type(cardDialogue.curNode.nodeText);
		int yStart = 60;
		int align = 32+22;
		cardEntities[0] = new responseButton(cardDialogue.curNode.responses[0],722,yStart+3*align);
		cardEntities[1] = new responseButton(cardDialogue.curNode.responses[1],722,yStart+2*align);
		cardEntities[2] = new responseButton(cardDialogue.curNode.responses[2],722,yStart+align);
		cardEntities[3] = new responseButton(cardDialogue.curNode.responses[3],722,yStart);
		cardEntities[4] = new portrait(cardDialogue.portraits[cardDialogue.curNode.portrait],810,263);
		localText = "\n\n\n\n\n\n\n ";
		localText += cardDialogue.curNode.responses[0].responseText;
		localText +="\n\n\n "+ cardDialogue.curNode.responses[1].responseText;
		localText +="\n\n\n "+ cardDialogue.curNode.responses[2].responseText;
		localText +="\n\n\n "+ cardDialogue.curNode.responses[3].responseText;
		
	}
	
	public void exit(){
		RadScape.active -=1;
		RadScape.hudCards.remove(RadScape.hudCards.size()-1);
	}
	
	
}
