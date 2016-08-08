
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class bldgFacade extends StaticEntity{
    public bldgFacade(int wallType){
        lookDescription = "A city building.";
        if(wallType!=2){
        	aspect = new VisualAspect(Reader.staticTexture80,(4+wallType)*80,0,80);
        }
        else{
        	aspect = new VisualAspect(Reader.staticTexture80,9*80,80,80);
        }
        updateColBox();
    }
}
