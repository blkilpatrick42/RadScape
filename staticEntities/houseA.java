
package com.mygdx.game.staticEntities;
import com.mygdx.game.RadScape;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class houseA extends StaticEntity{
    public houseA(){
        lookDescription = "An old house.";
        aspect = new VisualAspect(Reader.staticTexture80,1*80,0,80);
        colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY(), aspect.getSprite().getWidth(), aspect.getSprite().getHeight()/2);
    }
    
    public void interact(){
    	RadScape.hudPrinter.print("No one is home...", true);
    }
    
    public void updateColBox(){
    	colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY(), aspect.getSprite().getWidth(), aspect.getSprite().getHeight()/2);
    }
}
