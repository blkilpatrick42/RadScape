
package com.mygdx.game;
import com.badlogic.gdx.math.Rectangle;
public abstract class Entity {
     public VisualAspect aspect;
     public Rectangle colBox = new Rectangle();
     int Size;
     
     //updates the location of the objects collision box
     public void updateColBox(){
         colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY(), aspect.getSprite().getWidth(), aspect.getSprite().getHeight());
     }
     
     public void initializeColBox(){
    	 colBox = new Rectangle();
     }
     
     //determines if the colboxes of two entities are touching
     public boolean collidesWith(Entity e){
         return this.colBox.overlaps(e.colBox);
     }
     
     //update code that should occur every frame
     public void update(){
    	 if(aspect!=null){
    		 updateColBox();
    	 }
    }
}
