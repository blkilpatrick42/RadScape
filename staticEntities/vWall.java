
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class vWall extends StaticEntity{
    public vWall(int wallType){
        lookDescription = "A brick wall.";
        aspect = new VisualAspect(Reader.staticTexture20,(4+wallType)*20,0,20);
        updateColBox();
    }
}
