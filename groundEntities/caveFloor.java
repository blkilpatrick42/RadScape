
package com.mygdx.game.groundEntities;
import com.mygdx.game.GroundEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class caveFloor extends GroundEntity{
    public caveFloor(){
        lookDescription = "A cobbled cave flood..";
        aspect = new VisualAspect(Reader.groundTexture,3*20,0,20);
    }
}
