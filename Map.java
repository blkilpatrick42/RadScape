
package com.mygdx.game;
import com.mygdx.game.staticEntities.*;
import com.mygdx.game.staticEntities.doors.*;
import com.mygdx.game.groundEntities.*;

import java.util.ArrayList;
import java.util.Scanner;
public class Map {
	String gridName;
	public int gridX;
	public int gridY;
	String ambient;
    GroundEntity groundMap[][] = new GroundEntity[40][30];
    ArrayList<StaticEntity> entityMap = new ArrayList();
    public String mapFileName;
    //where mapString is the name of the file
    public Map(String mapString){
    	mapFileName = mapString;
        //load in static entity list
        StaticEntity tempEnt;
        String temp;
        String doorTempMap;
        int doorxTemp;
        int dooryTemp;
        int xTemp;
        int yTemp;
        String entString = Reader.readStringFromFile(mapString+"ENT.txt");
        Scanner entScan = new Scanner(entString);
        gridName = entScan.next();
        gridX = entScan.nextInt();
        gridY = entScan.nextInt();
        ambient = entScan.next();
        while(entScan.hasNext()){
            temp = entScan.next();
            if(temp.charAt(0)=='d'){
            	doorTempMap = entScan.next();
            	doorxTemp = entScan.nextInt();
            	dooryTemp = entScan.nextInt();
            	tempEnt = StaticDoor.getDoor(temp,doorTempMap,doorxTemp,dooryTemp);
            }
            else{
            	tempEnt = StaticEntity.getStaticEntity(temp);
            }
            xTemp = entScan.nextInt();
            yTemp = entScan.nextInt();
            
            tempEnt.aspect.setPos(xTemp, yTemp, 20);
            tempEnt.aspect.transformX(16*3, 1);
            tempEnt.aspect.transformY(16*3, 1);
            tempEnt.updateColBox();
            entityMap.add(tempEnt);
            
        }
        entScan.close();
        //loag in ground entities
        mapString = Reader.readStringFromFile(mapString+".txt");
        char charMap[] = mapString.toCharArray();
        int i = 0;
        for(int y = 23; y >= 0; y--){
            for(int x = 0; x < 32; x++){
                groundMap[x][y] = GroundEntity.getGroundEntity(charMap[i]);
                if(groundMap[x][y] == null){
                    i++;
                    groundMap[x][y] = GroundEntity.getGroundEntity(charMap[i]);
                }
                groundMap[x][y].aspect.setPos(x, y, 20);
                groundMap[x][y].aspect.transformX(16*3, 1);
                groundMap[x][y].aspect.transformY(16*3, 1);
                i++;
            }
        }
    }
    
   public void exit(char exitDir){
    	String newMapString = "maps/";
    	switch(exitDir){
    	case 'n':  newMapString += gridName+gridX+(gridY+1);
    		break;
    	case 's':  newMapString += gridName+gridX+(gridY-1);
    		break;
    	case 'e':  newMapString += gridName+(gridX+1)+gridY;
    		break;
    	case 'w':  newMapString += gridName+(gridX-1)+gridY;
    		break;
    	}
    	RadScape.curMap = new Map(newMapString);
    }
}
