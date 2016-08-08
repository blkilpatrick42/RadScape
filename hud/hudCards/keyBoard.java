package com.mygdx.game.hud.hudCards;

import com.mygdx.game.HudEntity;

public class keyBoard {
	public StringBuilder typeString;
	boolean capsMode = false;
	HudEntity board[];
	int xOffset = 30;
	int yOffset = 30;
	int textMax = 0;
	public keyBoard(int inx, int iny, int inTextMax){
		textMax = inTextMax;
		typeString = new StringBuilder();
		board = new HudEntity[29];
		int num = 0;
		for(int y = 0;y < 4; y++){
			for(int x = 0; x < 8; x++){
				if(num<29){
					board[num] = new keyBoardButton(inx+x*xOffset,iny-y*yOffset, num+1, this);
					num++;
				}
		}
		}
	}
	
	public HudEntity[] appendKeyboard(HudEntity inArray[]){
		HudEntity outArray[] = new HudEntity[inArray.length+board.length];
		for(int i = 0; i < inArray.length; i++){
			outArray[i] = inArray[i];
		}
		for(int i = 0; i < board.length; i++){
			outArray[inArray.length+i] = board[i];
		}
		return outArray;
	}
	
}
