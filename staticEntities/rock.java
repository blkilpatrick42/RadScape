
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class rock extends StaticEntity{
    public rock(){
        lookDescription = "A rock.";
        aspect = new VisualAspect(Reader.staticTexture20,0*20,0,20);
        updateColBox();
    }
}
