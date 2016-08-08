
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class caveWall extends StaticEntity{
    public caveWall(){
        lookDescription = "The wall of a cave.";
        aspect = new VisualAspect(Reader.staticTexture20,2*20,0,20);
        updateColBox();
    }
}
