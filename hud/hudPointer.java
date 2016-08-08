
package com.mygdx.game.hud;
import com.mygdx.game.HudEntity;
import com.mygdx.game.RadScape;
import com.mygdx.game.VisualAspect;
public class hudPointer extends HudEntity{
    public hudPointer(int startX, int startY){
        setVisible(false);
        aspect = new VisualAspect("hud/pointer.png", startX,startY);
        colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY()+10, aspect.getSprite().getWidth()/4, aspect.getSprite().getHeight()/4);
        //updateColBox();
    }
    
    //returns an array of ints where the
    //first int is the pointer x coordinates in
    //the 16/16 game grid and the second is the
    //coordinates in they grid
    public int[] getGridLocation(){
    	int[] retInt = new int[2];
    	retInt[0] = ((int)aspect.getSprite().getX()-(16*3))/20;
    	retInt[1] = ((int)aspect.getSprite().getY()-(16*3))/20;
    	
    	return retInt;
    }
    
    public boolean isOverWorldWindow(){
    	if(RadScape.pointer.getGridLocation()[0]<32&&RadScape.pointer.getGridLocation()[0]>0&&RadScape.pointer.getGridLocation()[1]<24&&RadScape.pointer.getGridLocation()[1]>0)
    		return true;
    	else
    		return false;
    }
    
    public void updateColBox(){
    	colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY()+10, aspect.getSprite().getWidth()/4, aspect.getSprite().getHeight()/4);
    }
}


