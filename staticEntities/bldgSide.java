
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class bldgSide extends StaticEntity{
    public bldgSide(int wallType){
        lookDescription = "A city building.";

        	aspect = new VisualAspect(Reader.staticTexture80,(wallType)*80,80,80);
        
        updateColBox();
    }
}
