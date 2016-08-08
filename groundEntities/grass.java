
package com.mygdx.game.groundEntities;
import com.mygdx.game.GroundEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class grass extends GroundEntity{
    public grass(){
        lookDescription = "A stretch of green grass.";
        aspect = new VisualAspect(Reader.groundTexture,0,0,20);
    }
}
