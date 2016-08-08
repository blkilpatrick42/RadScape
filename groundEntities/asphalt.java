
package com.mygdx.game.groundEntities;
import com.mygdx.game.GroundEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class asphalt extends GroundEntity{
    public asphalt(){
        lookDescription = "";
        aspect = new VisualAspect(Reader.groundTexture,6*20,0,20);
    }
}
