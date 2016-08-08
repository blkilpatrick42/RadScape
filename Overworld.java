
package com.mygdx.game;
import java.util.ArrayList;
import java.io.Serializable;
public class Overworld implements Serializable{
   public overworldNode worldList[][];
   public Overworld(){
	   worldList = new overworldNode[100][100];
	   for(int x = 0; x <100; x++){
		   for(int y = 0; y<100; y++){
			   worldList[x][y] = new overworldNode();
		   }
	   }
   }
   
   public ArrayList<DynamicEntity> getNode(int x, int y){
	   return worldList[x][y].dynList;
   }
   
   public void addEntity(DynamicEntity inEnt, int x, int y){
	   worldList[x][y].dynList.add(inEnt);
   }
   
   public void removeEntity(DynamicEntity inEnt, int x, int y){
	   worldList[x][y].dynList.remove(inEnt);
   }
}


