
package com.mygdx.game.staticEntities;
import com.mygdx.game.StaticEntity;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
public class hPowerLine extends StaticEntity{
    public hPowerLine(int type){
    	if(type>0){
    		solid = false;
    	}
        lookDescription = "Power lines.";
        aspect = new VisualAspect(Reader.staticTexture20,(7+type)*20,0,20);
        updateColBox();
    }
}
