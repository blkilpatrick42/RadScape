
package com.mygdx.game.hud;
import com.mygdx.game.HudEntity;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;

import java.util.Scanner;

public class hudTextPrinter extends HudEntity{
    textQueue queue = new textQueue();
    private String typeString = "";
    private String tempString = "";
    int counter = 0;
    public boolean typing = false;
    
    
    public void print(String inString, boolean fit){
    	if(!typing){
	        if(!fit){
	            queue.add(inString);
	        }
	        else{
	            queue.add(splitString(inString));
	        }
    	}
    }
    
    public void type(String inString){
    	if(!typing){
	    	typing = true;
	    	queue.add(tempString);
	    	typeString = splitString(inString);
	    	counter = 0;
    	}
    }
    
    public String get(int i){
        return queue.get(i);
    }
    
    //This method trims a given string to fit
    //into the hud text printer box
    public String splitString(String inString){
        StringBuilder outBuilder = new StringBuilder();
        StringBuilder addString = new StringBuilder();
        StringBuilder tempString = new StringBuilder();
        String nextString;
        Scanner splitScan = new Scanner(inString);
        splitScan.useDelimiter(" ");
        while(splitScan.hasNext()){
            nextString = splitScan.next();
            tempString.append(addString);
            tempString.append(" ");
            tempString.append(nextString);
            if(tempString.length()>37){
                addString.append("\n");
                outBuilder.append(addString);
                addString = new StringBuilder();
            }
            addString.append(" ");
            addString.append(nextString);
            tempString = new StringBuilder();
        }
        outBuilder.append(addString);
        splitScan.close();
        return outBuilder.toString();
    }
    public void update(){
    	if(typing){
    		if(counter == typeString.length()){
    			typing = false;
    			tempString = "";
    			counter = 0;
    		}
    		else{
    		   tempString = tempString + typeString.charAt(counter);
    		   
    		   queue.set(0, tempString);
    		   if(counter%3==0){
    			   Reader.playSound("sound/fx/typeSound.wav");
    		   }
    		   counter++;
    		}
    	}
    }
}

//this class is a simple array implementation of a queue
//for use with the hudTextPrinter class above
class textQueue{
    private String locQueue[] = new String[10];
    
    //constructor which initializes the array
    public textQueue(){
        for(int i = 0; i <locQueue.length; i++){
            locQueue[i] = "";
        }
    }
    
    //returns an element of locQueue
    public String get(int i){
        return locQueue[i];
    }
    
  //sets an element of locQueue
    public void set(int i,String in){
        locQueue[i] = in;
    }
    
    //adds a String to the queue, and kick out
    //the String in the last place
    public void add(String addString){
        for(int i =locQueue.length-1; i > 0; i--){
            if(i!=0){
                locQueue[i]=locQueue[i-1];
            }
        }
        locQueue[0] = addString;
    }
    
    
}

