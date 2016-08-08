package com.mygdx.game.hud.hudCards;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
public class keyBoardButton extends HudEntity{
	VisualAspect aspects[];
	keyBoard parentBoard;
	boolean counting = false;
	int counter = 0;
	int buttonNum;
	public keyBoardButton(int inx, int iny, int inButtonNum, keyBoard inBoard){
		buttonNum = inButtonNum;
		parentBoard = inBoard;
		aspects = new VisualAspect[2];
		aspects[0] = new VisualAspect("hud/hudCards/keyBoard/"+buttonNum+".png",inx,iny);
		aspects[1] = new VisualAspect("hud/hudCards/keyBoard/"+buttonNum+"p.png",inx,iny);
		aspect = aspects[0];
		updateColBox();
	}
	
	public void interact(){
		if(buttonNum == 27){
			parentBoard.capsMode = true;
		}
		else if(buttonNum == 28){
			if(parentBoard.typeString.length()>0){
				parentBoard.typeString.deleteCharAt(parentBoard.typeString.length()-1);
			}
		}
		else if(buttonNum == 29){
			if(parentBoard.typeString.length()<parentBoard.textMax){
				parentBoard.typeString.append((char)32);
			}
			else{
				Reader.playSound("sound/fx/typeSound.wav");
			}
		}
		else if(!parentBoard.capsMode){
			if(parentBoard.typeString.length()<parentBoard.textMax){
				parentBoard.typeString.append((char)(96+buttonNum));
			}
			else{
				Reader.playSound("sound/fx/typeSound.wav");
			}
			
		}
		else{
			if(parentBoard.typeString.length()<parentBoard.textMax){
				parentBoard.typeString.append((char)(64+buttonNum));
			}
			parentBoard.capsMode = false;
		}
		aspect = aspects[1];
		counting = true;
	}
	
	public void update(){
		if(counting){
			counter++;
		}
		if(counter>5){
			aspect = aspects[0];
			counter = 0;
			counting = false;
		}
	}
}
