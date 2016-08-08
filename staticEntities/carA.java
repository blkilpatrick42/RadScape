
package com.mygdx.game.staticEntities;
import com.mygdx.game.RadScape;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class carA extends StaticEntity{
    public carA(){
        lookDescription = "A blue car.";
        aspect = new VisualAspect(Reader.staticTexture80,3*80,0,80);
        updateColBox();
        colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY(), aspect.getSprite().getWidth()/2, aspect.getSprite().getHeight()/2);
    }
    
    public void interact(){
    	RadScape.hudPrinter.print("It's locked...", true);
    }
    
    public void updateColBox(){
    	colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY(), aspect.getSprite().getWidth()/2, aspect.getSprite().getHeight()/2);
    }
}
