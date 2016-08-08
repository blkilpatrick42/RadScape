
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class billBoard extends StaticEntity{
    public billBoard(int wallType){
    	solid = false;
        lookDescription = "An advertising billboard.";
        	aspect = new VisualAspect(Reader.staticTexture80,(wallType-1)*80,240,80);
        updateColBox();
    }
}
