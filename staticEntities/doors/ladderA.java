
package com.mygdx.game.staticEntities.doors;
import com.mygdx.game.StaticDoor;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class ladderA extends StaticDoor{
    public ladderA(String teleString,int teleX, int teleY){
        lookDescription = "A ladder.";
        aspect = new VisualAspect(Reader.doorTexture20,2*20,0,20);
        updateColBox();
        teleportMap = teleString;
        telePosX = teleX;
        telePosY = teleY;
    }
    public void playOpenSound(){
    	Reader.playSound("sound/fx/ladder.wav");
    }
}
