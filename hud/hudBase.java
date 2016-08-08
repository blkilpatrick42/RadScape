
package com.mygdx.game.hud;
import com.mygdx.game.HudEntity;
import com.mygdx.game.VisualAspect;
public class hudBase extends HudEntity{
    public hudBase(){
        setVisible(true);
        aspect = new VisualAspect("hud/hudBase.png");
    }
}
