
package com.mygdx.game.staticEntities;
import com.mygdx.game.RadScape;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.hud.hudCards.menu.saveGameCard;
public class savePoint extends StaticEntity{
    public savePoint(){
        lookDescription = "A large book, seemingly a journal, meant to record, or save, the events of a person's life.";
        aspect = new VisualAspect(Reader.staticTexture20,18*20,0,20);
        updateColBox();
    }
    
    public void interact(){
    	RadScape.hudCards.add(new saveGameCard());
    	RadScape.active=RadScape.hudCards.size()-1;
    }
}
