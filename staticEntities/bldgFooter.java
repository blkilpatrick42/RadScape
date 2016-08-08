
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class bldgFooter extends StaticEntity{
    public bldgFooter(int wallType){
        lookDescription = "A city building.";
        if(wallType>0){
        	aspect = new VisualAspect(Reader.staticTexture80,(6+wallType-1)*80,0,80);
        }
        else{
        	aspect = new VisualAspect(Reader.staticTexture80,6*80,80,80);
        }
        updateColBox();
    }
}
