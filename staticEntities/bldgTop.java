
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class bldgTop extends StaticEntity{
    public bldgTop(int wallType){
    	solid = false;
        lookDescription = "A city building.";

        	aspect = new VisualAspect(Reader.staticTexture80,7*80,80,80);
        
        updateColBox();
    }
}
