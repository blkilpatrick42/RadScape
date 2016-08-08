
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class tree extends StaticEntity{
    public tree(){
        lookDescription = "A spikey-looking pine tree.";
        aspect = new VisualAspect(Reader.staticTexture20,1*20,0,20);
        updateColBox();
    }
}
