
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class blackWall extends StaticEntity{
    public blackWall(){
        lookDescription = "A wall.";
        aspect = new VisualAspect(Reader.staticTexture20,3*20,0,20);
        updateColBox();
    }
}
