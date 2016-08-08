package com.mygdx.game;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.hud.hudCards.dialogue.dialogueCard;
public class Character extends Actor{
	public Dialogue dialogue;
	
	public Path path;
	//path variables
	int currentAct = 0;
	int counter = 0;
	boolean pathing = true;
	//integer for jank "return to pathing after dialogue" fix
	int sizeMinusDialogueCard = 0;
	
	public Character(String model, String dialogueString, String pathString, int gridX, int gridY, int locX, int locY){
		pathString = "characters/path/"+pathString;
		path = new Path(pathString);
		colBox = new Rectangle();
		solid = true;
		aspect = new VisualAnimated("worldArt/actors/"+model,20,4,12);
		colBox = new Rectangle();
		aspect.parkSprite(0,0);
		aspect.transformX(3, 16);
		aspect.transformY(3, 16);
		aspect.transformX(locX, 20);
		aspect.transformY(locY, 20);
		String tempString = Reader.readStringFromFile("characters/"+dialogueString);
		Scanner initScanner = new Scanner(tempString);
		String nameString = initScanner.nextLine();
		lookDescription = nameString;
		for (int i = 0; i < 12; i++){
			initScanner.nextLine();
		}
		String portraits[] = new String[10];
		for(int i = 0; i < 10; i++){
			portraits[i] = initScanner.nextLine();
			//System.out.println("portrait "+i+": "+portraits[i]);
		}
		//TODO add item interaction
		for (int i = 0; i < 5; i++){
			initScanner.nextLine();
			
		}
		//the following section of code reads in the potential start states,
		//and stores them as Strings into an arraylist until the terminator -1
		//is reached, after which it is transferred into an array.
		ArrayList<String> startStates = new ArrayList<String>();
		String tempA;
		do{
			tempA = initScanner.nextLine();
			if(!tempA.equals("-1")){
				startStates.add(tempA);
				//System.out.println("STATUSLINE: "+tempA);
			}
			
		}while(!tempA.equals("-1"));
		String inStates[] = new String[0];
		inStates = startStates.toArray(inStates);
		dialogue = new Dialogue(nameString,portraits, inStates, initScanner,0);
		initScanner.close();
		RadScape.overworld.addEntity(this, gridX, gridY);
		update();
	}
	
	public void walkRight(){
		if(!checkPlayerPointCollision((int)aspect.getSprite().getX()+21,(int)aspect.getSprite().getY()+2)&&!checkPlayerPointCollision((int)aspect.getSprite().getX()+21,(int)aspect.getSprite().getY()+18)){
			
			aspect.setLine(3);
			if(!aspect.animate){
				aspect.animate();
			}
			aspect.transformX(1,1);
		}
		else{
			counter--;
		}
	}
	public void walkLeft(){
		if(!checkPlayerPointCollision((int)aspect.getSprite().getX()-1,(int)aspect.getSprite().getY()+2)&&!checkPlayerPointCollision((int)aspect.getSprite().getX()-1,(int)aspect.getSprite().getY()+18)){
			aspect.setLine(2);
			if(!aspect.animate){
				aspect.animate();
			}
			aspect.transformX(-1,1);
		}
		else{
			counter--;
		}
	}
	public void walkUp(){
		if(!checkPlayerPointCollision((int)aspect.getSprite().getX()+2,(int)aspect.getSprite().getY()+21)&&!checkPlayerPointCollision((int)aspect.getSprite().getX()+18,(int)aspect.getSprite().getY()+21)){
			aspect.setLine(1);
			if(!aspect.animate){
				aspect.animate();
			}
			aspect.transformY(1,1);
		}
		else{
			counter--;
		}
	}
	public void walkDown(){
		if(!checkPlayerPointCollision((int)aspect.getSprite().getX()+2,(int)aspect.getSprite().getY()-1)&&!checkPlayerPointCollision((int)aspect.getSprite().getX()+18,(int)aspect.getSprite().getY()-1)){
			aspect.setLine(0);
			if(!aspect.animate){
				aspect.animate();
			}
			aspect.transformY(-1,1);
		}
		else{
			counter--;
		}
	}
	
	public void turnRight(){
		aspect.stopAnimate(0, 3);
	}
	public void turnLeft(){
		aspect.stopAnimate(0, 2);
	}
	public void turnUp(){
		//oh fuck it's lit
		aspect.stopAnimate(0, 1);
	}
	public void turnDown(){
		aspect.stopAnimate(0, 0);
	}
	
	
	public void stop(){
		aspect.stopAnimate(0, aspect.animateLine);
	}
	
	public void talk(){
		if(!RadScape.hudCards.contains(RadScape.dialogue)){
			
			RadScape.dialogue = new dialogueCard(this.dialogue);
			RadScape.hudCards.add(RadScape.dialogue);
	    	RadScape.active = RadScape.hudCards.size()-1;
	    	
		}
	}
	
	public void interact(){
		pathing = false;
		sizeMinusDialogueCard = RadScape.hudCards.size();
		if(RadScape.PLAYER.aspect.animateLine == 0){
			aspect.stopAnimate(0,1);
		}
		else if(RadScape.PLAYER.aspect.animateLine == 1){
			aspect.stopAnimate(0,0);
		}
		else if(RadScape.PLAYER.aspect.animateLine == 2){
			aspect.stopAnimate(0,3);
		}
		else if(RadScape.PLAYER.aspect.animateLine == 3){
			aspect.stopAnimate(0,2);
		}
		talk();
		
	}
	
	public void update(){
		if(pathing == false&&RadScape.hudCards.size()==sizeMinusDialogueCard){
			pathing = true;
		}
		colBox.set(aspect.getSprite().getX(), aspect.getSprite().getY(), aspect.getSprite().getWidth(), aspect.getSprite().getHeight());
		aspect.update();
		if(pathing){
			if(counter > path.pathNodes.get(currentAct).duration){
				counter = 0;
				currentAct++;
				if(!(currentAct < path.pathNodes.size())){
					currentAct = 0;
				}
			}
			else{
				counter++;
			}
			String action = path.pathNodes.get(currentAct).action;
			if(action.equals(" wu")){
				walkUp();
			}
			else if(action.equals(" wd")){
				walkDown();
			}
			else if(action.equals(" wr")){
				walkRight();
			}
			else if(action.equals(" wl")){
				walkLeft();
			}
			else if(action.equals(" tu")){
				turnUp();
			}
			else if(action.equals(" td")){
				turnDown();
			}
			else if(action.equals(" tr")){
				turnLeft();
			}
			else if(action.equals(" tl")){
				turnRight();
			}
			else if(action.equals(" wt")){
				stop();
			}
			
		}
		
	}
	
	public boolean checkPlayerPointCollision(int x, int y){
		if(RadScape.PLAYER!=null){
		if(RadScape.PLAYER.colBox.contains(x,y)){
			return true;
		}
		}
		return false;
	}
	
	public Character scanCharacter(){
		Scanner scan = new Scanner(System.in);
		String png;
		String chr;
		String wander;
		System.out.println("Character image: ");
		png = scan.nextLine();
		System.out.println("Charactr file: ");
		chr = scan.nextLine();
		System.out.println("Wander file: ");
		wander = scan.nextLine();
		scan.close();
		return new Character(png,chr,wander,RadScape.curMap.gridX,RadScape.curMap.gridX,RadScape.pointer.getGridLocation()[0],RadScape.pointer.getGridLocation()[1]);
	}
	
}
