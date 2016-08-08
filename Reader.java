
package com.mygdx.game;
import java.util.Random;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Gdx;

import java.util.Random;
public class Reader {
	//values for state maintenence
	public static int saveSlot = 0;
	public static ArrayList<Integer> STATUSLIST = new ArrayList<Integer>();
	
    private static Random locRand = new Random();
    private static Scanner locScan = new Scanner(System.in);
    private static File locFile;
    public static Sound currentSoundA;
    public static long currentSoundID;
    public static float currentSoundVolume = 1.0f;
    public static Sound currentAmbient;
    public static long currentAmbientID;
    public static float currentAmbientVolume = 1.0f;
    public static boolean ambientIsPlaying = false;
    private static String curAmbient = "none";
    public static Sound currentMusic;
    public static long currentMusicID;
    public static float currentMusicVolume = 1.0f;
    public static boolean musicIsPlaying = false;
   
    
    
    
    public static Texture groundTexture = getTexture("worldArt/groundTex.png");
    		//new Texture("worldArt/groundTex.png");
    public static Texture staticTexture20 = getTexture("worldArt/static/staticTex20.png");
    //new Texture("worldArt/static/staticTex20.png");
    public static Texture staticTexture80 = getTexture("worldArt/static/staticTex80.png");
    //new Texture("worldArt/static/staticTex80.png");
    public static Texture doorTexture20 = getTexture("worldArt/static/doors20.png");
    
    //Method for generating a texture from a given String
    public static Texture getTexture(String inName){
        Texture tempTex = new Texture(inName);
        return tempTex;
    }
    
    //This function returns
    //a Random integer between
    //the parameters lo and hi
    public static int getRandInt(int lo, int hi){
        return locRand.nextInt(hi-lo)+lo;
    }
    
    //this function
    //returns the terminal input
    //of a very handsome developer
    public static String getInputString(){
    	return locScan.nextLine();
    }
    
  //this function
    //returns the terminal input
    //of a very handsome developer
    public static int getInt(){
    	int a = locScan.nextInt();
    	locScan.nextLine();
    	return a;
    }
    
    //Reads a text file and returns it as a String
    public static String readStringFromFile(String fileName){
        try {
            locFile = new File(fileName);
            StringBuilder sb = new StringBuilder();
            Scanner Prelim = new Scanner(locFile);
            Prelim.useDelimiter("\n");
            while (Prelim.hasNext()) {
                sb.append(Prelim.next());
            }
            Prelim.close();
            return sb.toString();
 
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
        return null;
    }
    
    //writes a String to a file
    public static void saveToFile(String s, String name) {
        try {
            PrintWriter writer = new PrintWriter(name);
            Scanner scan = new Scanner(s);
            scan.useDelimiter("\n");
            while (scan.hasNext()) {
                writer.println(scan.next());
            }
            writer.close();
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
        
    }
    
    //method for playing a sound
    public static void playSound(String inString){
    	currentSoundA = Gdx.audio.newSound(Gdx.files.internal(inString));
    	currentSoundID = currentSoundA.play(currentSoundVolume);
    }
    
    public static void setAmbient(String inString){
    	if(inString.equals(curAmbient)){
    		if(!ambientIsPlaying){
    			currentAmbient.loop(currentAmbientVolume);
    			ambientIsPlaying = true;
    		}
    		return;
    	}
    	if(inString.equals("none")){
    		currentAmbient.stop();
    		ambientIsPlaying = false;
    		return;
    	}
    	
    	if(currentAmbient != null){
    		currentAmbient.stop();
    		ambientIsPlaying = false;
    	}
    	currentAmbient = Gdx.audio.newSound(Gdx.files.internal(inString));
    	curAmbient = inString;
    	currentAmbientID = currentAmbient.loop(currentAmbientVolume);
    	ambientIsPlaying = true;
    }
    
    public static void stopAmbient(){
    	currentAmbient.stop();
    	ambientIsPlaying = false;
    }
    
    //MUSIC METHODS
    public static void setMusic(String inString, boolean loop){
    	if(currentMusic != null){
    		currentMusic.stop();
    	}
    	currentMusic = Gdx.audio.newSound(Gdx.files.internal(inString));
    	if(loop){
    		currentMusicID = currentMusic.loop(currentMusicVolume);
    	}
    	else{
    		currentMusicID = currentMusic.play(currentMusicVolume);
    	}
    	musicIsPlaying = true;
 
    }
    
    public static void stopMusic(){
    	currentMusic.stop();
    	musicIsPlaying = false;
    }
    //END MUSIC METHODS
    
    public static void soundFXVolume(boolean turnUp){
    	if(currentSoundA != null){
    	if(turnUp&&currentSoundVolume<1.0f){
    		currentSoundVolume+=0.1;
    		currentSoundA.setVolume(currentSoundID, currentSoundVolume);
    	}
    	else if (!turnUp&&currentSoundVolume>=0.0f){
    		currentSoundVolume-=0.1;
    		if(currentSoundVolume<0.0){
    			currentSoundVolume = 0.0f;
    		}
    		currentSoundA.setVolume(currentSoundID, currentSoundVolume);
    	}
    	}
    }
    
    public static void musicVolume(boolean turnUp){
    	if(currentMusic != null){
    	if(turnUp&&currentMusicVolume<1.0f){
    		currentMusicVolume+=0.1f;
    		currentMusic.setVolume(currentMusicID, currentMusicVolume);
    	}
    	else if (!turnUp&&currentMusicVolume>=0.0f){
    		currentMusicVolume-=0.1f;
    		if(currentMusicVolume<0.0){
    			currentMusicVolume = 0.0f;
    		}
    		currentMusic.setVolume(currentMusicID, currentMusicVolume);
    	}
    	}
    }
    public static void ambientVolume(boolean turnUp){
    	if(currentAmbient != null){
    	if(turnUp&&currentAmbientVolume<1.0f){
    		currentAmbientVolume+=0.1;
    		currentAmbient.setVolume(currentAmbientID, currentAmbientVolume);
    	}
    	else if (!turnUp&&currentAmbientVolume>=0.0f){
    		currentAmbientVolume-=0.1;
    		if(currentAmbientVolume<0.0){
    			currentAmbientVolume = 0.0f;
    		}
    		currentAmbient.setVolume(currentAmbientID, currentAmbientVolume);
    	}
    	}
    }
    
    //METHODS FOR SAVE MAINTENENCE
    
    //Method for saving the serializable overworld, and by extension all of the
    //dynamic entities present in the game world. The first parameter is the
    //world to be saved, followed by a string to specify the location in assets
    //the world will be saved to.
    public static void saveOverWorld(Overworld inWorld, String guideString){
    	//loop for snapshotting visual aspects
    	for(int y = 0;  y < inWorld.worldList[0].length; y++){
    		for(int x = 0; x < inWorld.worldList.length; x++){
    			for(int i = 0; i < inWorld.worldList[x][y].dynList.size(); i++){
    				inWorld.worldList[x][y].dynList.get(i).snapShotAspect();
    			}
    		}
    	}
    	 try {
             FileOutputStream stream = new FileOutputStream(Gdx.files.getLocalStoragePath()+guideString);
             ObjectOutputStream out = new ObjectOutputStream(stream);
             //RadScape.hudPrinter.type("SAVING GAME OVERWORLD...");
             out.writeObject(inWorld);
             out.close();

         } catch (IOException e) {
        	 //RadScape.hudPrinter.type("Error while saving game overworld!");
             e.printStackTrace();
         }
    }
    
    public static void savePlayer(Player inPlayer, String guideString){
    	inPlayer.snapShotAspect();
    	 try {
             FileOutputStream stream = new FileOutputStream(Gdx.files.getLocalStoragePath()+guideString);
             ObjectOutputStream out = new ObjectOutputStream(stream);
             //RadScape.hudPrinter.type("SAVING GAME OVERWORLD...");
             out.writeObject(inPlayer);
             out.close();

         } catch (IOException e) {
        	 //RadScape.hudPrinter.type("Error while saving game overworld!");
             e.printStackTrace();
         }
    }
    
    //saves the current status list to a state file in the 
    //working save slot
    public static void saveStatusList(String guideString){
   	 try {
            FileOutputStream stream = new FileOutputStream(Gdx.files.getLocalStoragePath()+guideString);
            ObjectOutputStream out = new ObjectOutputStream(stream);
            //RadScape.hudPrinter.type("SAVING GAME OVERWORLD...");
            out.writeObject(STATUSLIST);
            out.close();

        } catch (IOException e) {
       	 //RadScape.hudPrinter.type("Error while saving game overworld!");
            e.printStackTrace();
        }
    }
    
    //Serializes the game in the form of 3 files, and puts those files
    //in the current active save game folder
    public static void saveGame(){
    	RadScape.hudPrinter.type("Saving Game World...");
		saveOverWorld(RadScape.overworld,"/save/slot"+saveSlot+"/world.bucket");
		RadScape.hudPrinter.type("Saving Player data...");
		savePlayer(RadScape.PLAYER,"/save/slot"+saveSlot+"/player.dat");
		RadScape.hudPrinter.type("Saving Game Status...");
		saveStatusList("/save/slot"+saveSlot+"/statusList.dat");
		
	}
    
    

	public static void setSaveSlot(int in){
		saveSlot = in;
		
	}
	
	public static Overworld loadOverworld(String guideString){
		
		try {
			Overworld retWorld;
            FileInputStream stream = new FileInputStream(Gdx.files.getLocalStoragePath()+guideString);
            ObjectInputStream in = new ObjectInputStream(stream);
            retWorld = (Overworld) in.readObject();
            in.close();
            //code for re-instantianting visual aspects
            for(int y = 0;  y < retWorld.worldList[0].length; y++){
        		for(int x = 0; x < retWorld.worldList.length; x++){
        			for(int i = 0; i < retWorld.worldList[x][y].dynList.size(); i++){
        				retWorld.worldList[x][y].dynList.get(i).loadSnapshot();
        			}
        		}
        	}
            
            return retWorld;


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return null;
        }
	}

	//This method accepts a String of text, which
	//is the filepath to the player file in a save folder
    //and scans information from it to produce an object
    //of the class Player.
    public static Player loadPlayer(String guideString){
    	try {
			Player retPlayer;
            FileInputStream stream = new FileInputStream(Gdx.files.getLocalStoragePath()+guideString);
            ObjectInputStream in = new ObjectInputStream(stream);
            retPlayer = (Player) in.readObject();
            in.close();
            retPlayer.loadSnapshot();
            
            return retPlayer;


        } catch (IOException e) {
            System.out.print(e);
            return null;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return null;
        }
    	
    }
    
    @SuppressWarnings("unchecked")
	public static ArrayList<Integer> loadStatusList(String guideString){
    	try {
			ArrayList<Integer> retList;
            FileInputStream stream = new FileInputStream(Gdx.files.getLocalStoragePath()+guideString);
            ObjectInputStream in = new ObjectInputStream(stream);
            retList = (ArrayList<Integer>) in.readObject();
            in.close();
            
            return retList;


        } catch (IOException e) {
            System.out.print(e);
            return null;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return null;
        }
    }
    
    public static void loadGame(){
    	RadScape.hudPrinter.type("Loading Game World...");
		RadScape.overworld = loadOverworld("/save/slot"+saveSlot+"/world.bucket");
		RadScape.hudPrinter.type("Loading Player data...");
		RadScape.PLAYER = loadPlayer("/save/slot"+saveSlot+"/player.dat");
		RadScape.hudPrinter.type("Loading Game Status..."); 
		STATUSLIST = loadStatusList("/save/slot"+saveSlot+"/statusList.dat");
		RadScape.curMap = new Map("maps/map"+RadScape.PLAYER.gridX+RadScape.PLAYER.gridY);
		
    }
    
    public static void addToStatusList(int in){
    	STATUSLIST.add(in);
    }
    
    public static void removeFromStatusList(int in){
    	STATUSLIST.remove(in);
    }
    
    public static boolean statusListContains(int in){
    	return STATUSLIST.contains(in);
    }
    
}
