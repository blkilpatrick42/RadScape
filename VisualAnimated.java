package com.mygdx.game;
import java.io.Serializable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class VisualAnimated extends VisualAspect implements Serializable{
    int currentFrame = 0;
    int animateSpeed = 0;
    int width;
    int height;
    public int animateLine = 0;
    public boolean animate = false;
    public String recallString;
    
    
    //the number of sprites in the animation
    int length = 0;
    
    int updateCounter = 0;
    
    //constructor for loading a sprite from a sprite sheet
    //where x and y is the TOP LEFT corner of the sprite ( assumed to
    // be 0,0), size
    //is the length of one side of a square with x and y as a corner
    //and length is the number of sprites in the animation, and speed is the
    //speed of the animation
     public VisualAnimated(String texName, int size, int length, int speed){
    	 recallString = texName;
         animateSpeed = speed;
         this.length = length;
         width = size;
         height = size;
        localTexture = new Texture(texName);
        localSprite = new Sprite(localTexture);
        setPos(0,0,1);
        localSprite.setBounds(0, 0, width, height);
    }
     
     public VisualAnimated(String texName, int width, int height, int length, int speed){
    	 recallString = texName;
         animateSpeed = speed;
         this.length = length;
         this.width = width;
         this.height = height;
        localTexture = new Texture(texName);
        localSprite = new Sprite(localTexture);
        setPos(0,0,1);
        localSprite.setBounds(0, 0, width, height);
    }
     
     //update the local sprite
     //this includes animation
     public void update(){
    	 if(animate){
	         updateCounter++;
	         if(updateCounter>=animateSpeed){
	             updateCounter = 0;
	             currentFrame++;
	             if(currentFrame>=length){
	                 currentFrame = 0;
	             }
	         }
//	         localSprite.setBounds(0, 0, width, height);
	         localSprite.setRegion(currentFrame*width,animateLine*height,width,height);
	         
    	 }
     }
     
     //method for setting the line of animation
     //in the spritesheet
     public void setLine(int x){
    	 animateLine = x;
     }
     
     //method for pausing the sprite on a certain image
     //on the sprite sheet
     public void parkSprite(int frame, int line){
    	 localSprite.setRegion(frame*width,line*height,width,height);

     }
     
     public void animate(){
    	 animate = true;
     }
     
     public void stopAnimate(){
    	 animate = false;
     }
     
     //method stops the animation, and additionally
     //parks the sprite on a certain image in the
     //sprite sheet
     public void stopAnimate(int frame, int line){
    	 animate = false;
    	 parkSprite(frame,line);
     }
     
     public void setSpeed(int inS){
    	 animateSpeed = inS;
     }
}
