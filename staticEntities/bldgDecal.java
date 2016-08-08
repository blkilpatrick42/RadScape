
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class bldgDecal extends StaticEntity{
    public bldgDecal(int wallType){
    	solid = false;
        lookDescription = "A city building.";
        	aspect = new VisualAspect(Reader.staticTexture80,(wallType-1)*80,160,80);
        updateColBox();
    }
}
