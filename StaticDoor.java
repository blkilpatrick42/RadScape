package com.mygdx.game;

import com.mygdx.game.staticEntities.doors.ladderA;
import com.mygdx.game.staticEntities.doors.trapDoorA;
import com.mygdx.game.staticEntities.doors.woodDoorA;

public class StaticDoor extends StaticEntity{
	public String teleportMap;
	public int telePosX;
	public int telePosY;
	
	public void interact(){
		if(RadScape.PLAYER.canExitDoor){
		RadScape.curMap = new Map(getTeleportMap());
		RadScape.PLAYER.aspect.parkSprite(0, 0);
		RadScape.PLAYER.aspect.setPos(telePosX, telePosY, 20);
		RadScape.PLAYER.aspect.transformX(3, 16);
		RadScape.PLAYER.aspect.transformY(3, 16);
		RadScape.PLAYER.canExitDoor = false;
		playOpenSound();
		}
		
	}
	public String getTeleportMap(){
		return teleportMap;
	}
	public int getTelePosX(){
		return telePosX;
	}
	public int getTelePosY(){
		return telePosY;
	}
	
	public void playOpenSound(){
		return;
	}
	
	public static StaticDoor getDoor(String temp, String doorTempMap,
			int doorxTemp, int dooryTemp) {
    	char p2 = temp.charAt(1);
    	char p3 = temp.charAt(2);
    	if(p2 == '0'){
    		if(p3 == '0'){
    			return new woodDoorA(doorTempMap,doorxTemp,dooryTemp);
    		}
    		if(p3 == '1'){
    			return new trapDoorA(doorTempMap,doorxTemp,dooryTemp);
    		}
    		if(p3 == '2'){
    			return new ladderA(doorTempMap,doorxTemp,dooryTemp);
    		}
    	}
		return null;
	}
}
