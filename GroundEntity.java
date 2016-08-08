
package com.mygdx.game;

import com.mygdx.game.groundEntities.asphalt;
import com.mygdx.game.groundEntities.blackness;
import com.mygdx.game.groundEntities.caveFloor;
import com.mygdx.game.groundEntities.concrete;
import com.mygdx.game.groundEntities.dirt;
import com.mygdx.game.groundEntities.grass;
import com.mygdx.game.groundEntities.sideWalk;
import com.mygdx.game.groundEntities.stripeHor;
import com.mygdx.game.groundEntities.stripeUp;

public abstract class GroundEntity extends Entity{
    public String lookDescription;
    public static GroundEntity getGroundEntity(char inChar){
        switch(inChar){
        	case '#': return new blackness();
            case 'g': return new grass();
            case 'c': return new concrete();
            case 'd': return new dirt();
            case 'r': return new caveFloor();
            case 's': return new sideWalk();
            case 'A': return new asphalt();
            case '|': return new stripeUp();
            case '-': return new stripeHor();
        }
        return null;
    }
}
