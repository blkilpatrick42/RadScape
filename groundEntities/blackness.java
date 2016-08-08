
package com.mygdx.game.groundEntities;
import com.mygdx.game.GroundEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class blackness extends GroundEntity{
    public blackness(){
        lookDescription = "";
        aspect = new VisualAspect(Reader.groundTexture,4*20,0,20);
    }
}
