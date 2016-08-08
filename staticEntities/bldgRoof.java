
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class bldgRoof extends StaticEntity{
    public bldgRoof(int wallType){
        lookDescription = "A city building.";

        	aspect = new VisualAspect(Reader.staticTexture80,8*80,80,80);
        
        updateColBox();
    }
}
