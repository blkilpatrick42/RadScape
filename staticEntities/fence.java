
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class fence extends StaticEntity{
    public fence(int wallType){
        lookDescription = "A wire fence.";
        aspect = new VisualAspect(Reader.staticTexture20,(9+wallType)*20,0,20);
        updateColBox();
    }
}
