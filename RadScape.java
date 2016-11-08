package com.mygdx.game;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.mygdx.game.hud.*;
import com.mygdx.game.hud.hudCards.*;
import com.mygdx.game.hud.hudCards.dev.devCard;
import com.mygdx.game.hud.hudCards.dialogue.dialogueCard;
import com.mygdx.game.hud.hudCards.inventory.InventoryCard;
import com.mygdx.game.hud.hudCards.menu.menuCard;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class RadScape extends ApplicationAdapter {
	//variables for player begin
	public static int playerBeginX = 12;
	public static int playerBeginY = 12;
	public static int playerBeginGridX = 0;
	public static int playerBeginGridY = 0;
	
	
	//tick variables
	int gameSpeed = 60;
	 private long diff, start = System.currentTimeMillis(); //gets current system time in Millisecs
	
	//for randomly choosing explore music
	public int musicCounter = 0;
	public int currentExplore = 1;
	public int maxExplore = 3;
	
	//DECLARATION OF GAME OVERWORLD and DYNAMIC ENTITY LIST
		public static Overworld overworld;
	//END DECLARATION OF GAME OVERWORLD
		
	//VIEWPORT AND CAMERA HANDLING
	public static final int VIRTUAL_WIDTH = 1024;
	public static final int VIRTUAL_HEIGHT = 576;		
	public static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;
	public Rectangle viewport;
	
	//Player declaration
	public static Player PLAYER;
	
	//DEVMODE STUFF
	public static boolean DELETEMODE;
	public static String ITEMSTRING = "";
	public static String ITEMDESCRIPSTRING = "";
	static boolean DEVMODE = true;
	public static boolean  PLACEMODE = false;
	public static String STATICSTRING = "";
	public static String DOORTELESTRING = "";
	public static int DOORTELEX;
	public static int DOORTELEY;
	public static boolean DOORMODE = false;
	public static void setStaticString(String s){
		STATICSTRING  = s;
	}
	public static void setItemString(String s){
		ITEMSTRING = s;
	}
	public static void setITemDescripString(String s){
		ITEMDESCRIPSTRING = s;
	}
	public static void setDoorTeleString(String s){
		DOORTELESTRING  = s;
	}
	public static void setDoorTeleX(int i){
		DOORTELEX = i;
	}
	public static void setDoorTeleY(int i){
		DOORTELEY = i;
	}
	//ENDDEVMODESTUFFF
	
	//the current print the hudPrinter is on
	public static int hudPrinterCurrent = 0;
	//declare the devCard, for use if DEVMODE is active
	public static hudCard devCard;
	//declare the dialogue card
	public static dialogueCard dialogue;
	//declare the inventoryCard
	public static InventoryCard playerInventoryCard;
	//general purpose string for drawing text through batch
	String drawConcat = "";
	
	//OPENING MENU STUFF
	    boolean opening = true;
	    boolean fadeOut = false; //These are meant for fading in and out
	    boolean fadeIn = false;   //on the map screen
		float alphaTitleBack = 255;
		float alphaTitle = 255;
		float alphaHudMask = 1;
		int counter = 0;
		VisualAspect hudMask;
		
		VisualAnimated portMask;
		VisualAspect titleBack;
		VisualAspect title;
    //END OPENING MENU STUFF

	boolean mouseJustPressed = true;
    //batch for drawing sprites
	SpriteBatch batch;
    //the current map the map screen is set to display
        public static Map curMap;
    //the entity representing the HUD frame
        hudBase hudBack;
        VisualAspect screenBack;
    //the entity representing the game cursor
        public static hudPointer pointer;
    //arraylist of hudCards. The hudcards are stored in an arraylist,
    //of which get(int active) is the ACTIVE HUDCARD
        public static ArrayList<hudCard> hudCards = new ArrayList<hudCard>();
        public static int active = 0;
    //hud arrows for scrolling through hudcards
        public hudLeftScroller leftScroller;
        public hudRightScroller rightScroller;
    //hud arrows for scrolling through printouts
        public hudUpScroller upScroller;
        public hudDownScroller downScroller;
    //the entity representing the game text-box printer
        public static hudTextPrinter hudPrinter;
    //local font for general use
        BitmapFont font;
    //vector3 object mostly used for interacting with cursor inputs
        Vector3 input;
    //orthoCamera object, also mostly used for handling mouse inputs
        OrthographicCamera camera; 
        //WINDOW MODES:
            //'w' = world view
           // 'm' = opening menu/gamestart
        public static char windowMode = 'm';
	
	@Override
	public void create () {
		screenBack = new VisualAspect("hud/screenBack.png",0,0);
		//make the cursor invisible in the screen
		Pixmap pixmap = new Pixmap( 16, 16, Format.RGBA8888 );
		Cursor temp = Gdx.graphics.newCursor(pixmap, 0, 0);
		Gdx.graphics.setCursor(temp);
		
		batch = new SpriteBatch();
		
		//load the current overworld from the worldDef file,
		//which contains the definition of the game world
		//in it's state at game start
		//overworld = Reader.loadOverworld("worldDef.bucket");  
		overworld = new Overworld();
		worldDef def = new worldDef();//the worldDef class is used to declare a starting state without
		                              //the worldDef file. This is to prevent the headache that comes
		                              //from serializations errors thrown by the worldDef file, and also
		                              //provide finer control over world definition. once the game is
		                              //mostly finalized, the world should be serialized to the serialized
		                              //worldDef, and this code should be removed. 
				//OPENING MENU STUFF

				if(windowMode == 'm'){
					Reader.setMusic("sound/music/titleThemeDemo2.wav",false);
				}
				 hudMask = new VisualAspect("hudMask.png");
				 titleBack = new VisualAspect("startScreens/"+Reader.getRandInt(1, 4)+".png",48,48);
				 title = new VisualAspect("title.png",58,512);
				//END OPENING MENU STUFF
				
				
				 
				 //define a current map
                curMap = new Map("maps/map00");
                
                //define the overrall hud frame
                hudBack = new hudBase();
                
                //add the main menu card for game start
                menuCard menu = new menuCard();
		 		hudCards.add(menu);
		 		
		 		//temp player until one is loaded or defined
		 		 PLAYER = new Player(12,12,0,0,1,"Guy");
				 playerInventoryCard = new InventoryCard("Your Inventory",PLAYER.inventory);
				 hudCards.add(playerInventoryCard);
				
		 		//if DEVMODE is on, add the devcard to the card group
		 		if(DEVMODE){
		 			devCard = new devCard();
		 			hudCards.add(devCard);
		 		}
		 		
		 		
		 		//define the arrows for scrolling through
		 		//hudcards and hudprinter respectively
		 		leftScroller = new hudLeftScroller(779,9);
		 		rightScroller = new hudRightScroller(903,9);
		 		upScroller = new hudUpScroller(1000,505);
		 		downScroller = new hudDownScroller(1000,441);
                
		 		//define the hudprinter
                hudPrinter = new hudTextPrinter();
                
                //define default font for general use
                font = new BitmapFont();
                
                //declare an orthographic camera, primarily
                //for dealing with mouse input
                camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
                //define the on-screen pointer object
                pointer = new hudPointer(Gdx.input.getX(),Gdx.input.getY());
	}
	
	//Tick function, limits the program to the fps
    public void sleep(int fps) {
        if (fps > 0) {
            diff = System.currentTimeMillis() - start;
            long targetDelay = 1000 / fps;
            if (diff < targetDelay) {
                try {
                    Thread.sleep(targetDelay - diff);
                } catch (InterruptedException e) {
                }
            }
            start = System.currentTimeMillis();
        }
    }

	
	@Override
	public void render () {
		//
		sleep(gameSpeed);
		 // update camera
        camera.update();
        //camera.apply(Gdx.gl10);

        // set viewport
        Gdx.gl.glViewport((int) viewport.x, (int) viewport.y,
                          (int) viewport.width, (int) viewport.height);


		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//LEFT CLICK POLL 
		if (Gdx.input.isButtonPressed(Buttons.LEFT)&&mouseJustPressed&&!opening){
			mouseJustPressed = false;
			//DEV CLICK 
			if(active==hudCards.size()-1&&DEVMODE&&PLACEMODE){
				PLACEMODE = false;
				StringBuilder newOut = new StringBuilder();
				newOut.append(Reader.readStringFromFile(curMap.mapFileName+"ENT.txt"));
				newOut.append(" "+STATICSTRING+" ");
				if(DOORMODE){
					newOut.append(" "+DOORTELESTRING);
					newOut.append(" "+DOORTELEX);
					newOut.append(" "+DOORTELEY+" ");
					DOORMODE = false;
				}
				newOut.append(pointer.getGridLocation()[0]+" ");
				newOut.append(pointer.getGridLocation()[1]);
				Reader.saveToFile(newOut.toString(), curMap.mapFileName+"ENT.txt");
				curMap = new Map(curMap.mapFileName);
			}
			//END DEV CLICK 
			//if you click on an entity, print description text
			if(windowMode == 'w'){
				printLook();
			}
		    //HUDcard check
		    for(int i = 0; i < hudCards.get(active).cardEntities.length; i++){
        		//if colliding with pointer
        		if(hudCards.get(active).cardEntities[i].collidesWith(pointer)){
        			Reader.playSound("sound/fx/clickSound2.wav");
        			hudCards.get(active).cardEntities[i].interact();
        			break;
        		}
            
        		
        	}
		  //left right scroll chek
    		if(leftScroller.collidesWith(pointer)&&!hudCards.get(active).lockScroll){
    			Reader.playSound("sound/fx/clickSound.wav");
    			leftScroller.interact();
    		}
    		else if(rightScroller.collidesWith(pointer)&&!hudCards.get(active).lockScroll){
    			Reader.playSound("sound/fx/clickSound.wav");
    			rightScroller.interact();
    		}
    		//up/down scroll check
    		if(upScroller.collidesWith(pointer)){
    			Reader.playSound("sound/fx/clickSound.wav");
    			upScroller.interact();
    		}
    		else if(downScroller.collidesWith(pointer)){
    			Reader.playSound("sound/fx/clickSound.wav");
    			downScroller.interact();
    		}
		}
		else if(Gdx.input.isButtonPressed(Buttons.LEFT)&&opening){
			opening = false;
		}
		else if(!Gdx.input.isButtonPressed(Buttons.LEFT)){
			mouseJustPressed = true;
		}
		
		//WASD POLL
		if (Gdx.input.isKeyPressed(Input.Keys.A)&&!hudCards.get(active).lockPlayer)
        {
			
			if(!checkSolidGeneralPointCollision((int)PLAYER.getX()-1,(int)PLAYER.getY()+2)&&!checkSolidGeneralPointCollision((int)PLAYER.getX()-1,(int)PLAYER.getY()+18)){
			PLAYER.walkLeft();
			}
			else{
				PLAYER.aspect.animateLine=2;
				PLAYER.aspect.parkSprite(0, PLAYER.aspect.animateLine);
				PLAYER.wL=false;
			}
        }
		else{
			PLAYER.wL=false;
		}
		
        //Poll for D pressed to move right

        if (Gdx.input.isKeyPressed(Input.Keys.D)&&!hudCards.get(active).lockPlayer)
        {
        	
        	if(!checkSolidGeneralPointCollision((int)PLAYER.getX()+21,(int)PLAYER.getY()+2)&&!checkSolidGeneralPointCollision((int)PLAYER.getX()+21,(int)PLAYER.getY()+18)){
        	PLAYER.walkRight();
        	}
        	else{
        		PLAYER.aspect.animateLine=3;
        		PLAYER.aspect.parkSprite(0, PLAYER.aspect.animateLine);
    			PLAYER.wR=false;
    		}
        }
        else{
        	PLAYER.wR=false;
        }
        
        if (Gdx.input.isKeyPressed(Input.Keys.W)&&!hudCards.get(active).lockPlayer)
        {
        	
        	if(!checkSolidGeneralPointCollision((int)PLAYER.getX()+2,(int)PLAYER.getY()+21)&&!checkSolidGeneralPointCollision((int)PLAYER.getX()+18,(int)PLAYER.getY()+21)){
			PLAYER.walkUp();
        	}
        	else{
        		PLAYER.aspect.animateLine=1;
        		PLAYER.aspect.parkSprite(0, PLAYER.aspect.animateLine);
    			PLAYER.wU=false;
    		}
        }
        else{
        	PLAYER.wU=false;
        }
        
        //Poll for D pressed to move right

        if (Gdx.input.isKeyPressed(Input.Keys.S)&&!hudCards.get(active).lockPlayer)
        {
        	
        	if(!checkSolidGeneralPointCollision((int)PLAYER.getX()+2,(int)PLAYER.getY()-1)&&!checkSolidGeneralPointCollision((int)PLAYER.getX()+18,(int)PLAYER.getY()-1)){
        	PLAYER.walkDown();
        	}
        	else{
        	PLAYER.aspect.animateLine=0;
        	PLAYER.aspect.parkSprite(0, PLAYER.aspect.animateLine);
			PLAYER.wD=false;
        	}
        }
        else{
        	PLAYER.wD=false;
        }
        
        
        if (Gdx.input.isKeyPressed(Input.Keys.P)&&DEVMODE&&!PLACEMODE)
        {
        	PLACEMODE=true;
        }
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
        	checkGeneralInteract(PLAYER.aspect.animateLine);
        }
		
		batch.begin();
         //BEGIN WORLD WINDOW DRAWING   
         if(windowMode == 'w'){
        	 exploreMusicUpdate();
        //BEGIN MAP AND PLAYER DRAWING..
                drawGround();
            	drawDynamicEntities();
                Reader.setAmbient(curMap.ambient);
          //DRAW PLAYER//
                PLAYER.aspect.getSprite().draw(batch);
                PLAYER.update();
          //END DRAW PLAYER//
                //Draw the static entities
                drawStaticEntities();
        
        //END MAP AND PLAYER DRAWING//
         }
         
         if(windowMode == 'm'&&!opening){
         	drawMenu();
         }
         
        //HUD DRAWING CODE BELOW//
         		screenBack.getSprite().draw(batch);
            //draw the text behind the hud frame so that it if overflows
            //its space it doesn't obscure other hud elements
                font.draw(batch, hudPrinter.get(hudPrinterCurrent), 724, 525);
                hudPrinter.update();
           
            //draw the overrall hud frame
                hudBack.aspect.getSprite().draw(batch);
                updateMouse();
            //draw the current hudprinter
                drawConcat = ""+hudPrinterCurrent;
                font.draw(batch, drawConcat, 1004, 487);
              //draw hudCard scroller
                leftScroller.aspect.localSprite.draw(batch);
                leftScroller.update();
                rightScroller.aspect.localSprite.draw(batch);
                rightScroller.update();
            //hudprinter scroller
                upScroller.aspect.localSprite.draw(batch);
                upScroller.update();
                downScroller.aspect.localSprite.draw(batch);
                downScroller.update();
            //draw the hudcard
                drawHudCard();
            
            //draw mouse
                pointer.aspect.getSprite().draw(batch);
        //END HUD DRAWING CODE//
                
        if(windowMode == 'm'&&opening){
        	drawMenu();
        }
       
		batch.end();
	}
	
	
        
        public void drawDynamicEntities() {
        	for(int i = 0; i < overworld.getNode(curMap.gridX, curMap.gridY).size(); i++){
        		overworld.getNode(curMap.gridX, curMap.gridY).get(i).aspect.getSprite().draw(batch);
        		overworld.getNode(curMap.gridX, curMap.gridY).get(i).update();
            }
        }
		//method for calling the general functions for updating and drawing
        //the mouse
        public void updateMouse(){
                    input = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
                    camera.unproject(input);
                    pointer.aspect.setPos(input.x, input.y, 2);
                    pointer.updateColBox();
        }
        
        //method for drawing the ground texture of the curMap
        public void drawGround(){
            for(int y = 0; y < 24; y++){
                    for(int x = 0; x < 32; x++){
                    curMap.groundMap[x][y].aspect.getSprite().draw(batch);
                    }
                }
        }
        
        //method for drawing the static entities of the curtMap
        public void drawStaticEntities(){
            for(int i = 0; i < curMap.entityMap.size(); i++){
                    curMap.entityMap.get(i).aspect.getSprite().draw(batch);
                }
        }
        
        //method for printing the description of the  entity at the cursor
        public void printLook(){
        	if(RadScape.pointer.isOverWorldWindow()){
        	//static entities
                 for(int i = 0; i < curMap.entityMap.size(); i++){
                    if(curMap.entityMap.get(i).collidesWith(pointer)){
                        hudPrinter.print(curMap.entityMap.get(i).lookDescription, true);
                        hudPrinterCurrent = 0;
                        return;
                    }
                    
                }
            //dynamic entities
                 for(int i = 0; i < overworld.getNode(curMap.gridX, curMap.gridY).size(); i++){
                	 if(overworld.getNode(curMap.gridX, curMap.gridY).get(i).collidesWith(pointer)){
                		 if(!DELETEMODE){
                		 hudPrinter.print(overworld.getNode(curMap.gridX, curMap.gridY).get(i).lookDescription, true);
                		 hudPrinterCurrent = 0;
                		 return;
                		 }
                		 else{
                			 overworld.getNode(curMap.gridX, curMap.gridY).remove(i);

                			 return;
                		 }
                	 }
                 }
        	}
        }
        
        //method for drawing the buttons present on the HUDCARD
        public void drawHudCard(){
	        	for(int q = 0; q < hudCards.size(); q++){
	        		hudCards.get(q).update();
		        	for(int i = 0; i < hudCards.get(q).cardEntities.length; i++){
		        		if(q==active){
		        			hudCards.get(active).cardEntities[i].aspect.getSprite().draw(batch);
		        			font.draw(batch, hudCards.get(active).title, 724, 390);
		        			font.draw(batch, hudCards.get(active).localText, 720, 368);
		        		}
		        		hudCards.get(q).cardEntities[i].update();
		        		
	        	}
        	}
        }
        
        //method for drawing the title screen of the main menu
        public void drawMenu(){
        	//if the game is set to doing it's rad opening,
        	//slowly fade in the title image, title, and slowly
        	//fade out the mask covering the interface
        	if(opening){
            	counter++;
            	if(counter>270&&alphaTitleBack!=1){
            		alphaTitleBack-=1;
            	}
            	
            	if(counter>1200&&alphaTitle!=1){
            		alphaTitle-=1;
            	}
            	if(counter>1600&&alphaHudMask!=255){
            		alphaHudMask+=1;
            	}
            	if(alphaHudMask == 255){
            		opening = false;
            	}
        	}
        	//or, if they skip the opening,
        	//skip everything to their final values
        	else{
        		alphaTitleBack = 1;
        		alphaTitle = 1;
        		alphaHudMask = 255;
        	}
            	
        	//set the alpha
            	hudMask.setSpriteAlpha(alphaHudMask);
            	titleBack.setSpriteAlpha(alphaTitleBack);
            	title.setSpriteAlpha(alphaTitle);
            //draw the menu items
            	hudMask.getSprite().draw(batch);
            	titleBack.getSprite().draw(batch);
            	title.getSprite().draw(batch);
            
        }
        
        public void fadeOut(){
        	//TODO write fadeOut
        }
        
        public void fadeIn(){
        	//TODO write fadeIn
        }
        
        public boolean isFadedOut(){
        	//TODO write isFaded
        	return false;
        }
        
        @Override
        public void resize(int width, int height)
        {
            // calculate new viewport
            float aspectRatio = (float)width/(float)height;
            float scale = 1f;
            Vector2 crop = new Vector2(0f, 0f); 
            if(aspectRatio > ASPECT_RATIO)
            {
                scale = (float)height/(float)VIRTUAL_HEIGHT;
                crop.x = (width - VIRTUAL_WIDTH*scale)/2f;
            }
            else if(aspectRatio < ASPECT_RATIO)
            {
                scale = (float)width/(float)VIRTUAL_WIDTH;
                crop.y = (height - VIRTUAL_HEIGHT*scale)/2f;
            }
            else
            {
                scale = (float)width/(float)VIRTUAL_WIDTH;
            }

            float w = (float)VIRTUAL_WIDTH*scale;
            float h = (float)VIRTUAL_HEIGHT*scale;
            viewport = new Rectangle(crop.x, crop.y, w, h);
        }
        
        //checks if a given point is within the collision box
        //of a solid static and dynamic entity, if so, return true
        public boolean checkSolidGeneralPointCollision(int x, int y){
        	if(checkSolidStaticPointCollision(x,y)||checkSolidDynamicPointCollision(x,y)){
        		return true;
        	}
        	else{
        		return false;
        	}
        }

        
        //checks if a given point is within the collision box
        //of a solid staticEntity, and, if so, return true
        public boolean checkSolidStaticPointCollision(int x, int y){
        	for(int i = 0; i < curMap.entityMap.size(); i++){
                if(curMap.entityMap.get(i).colBox.contains(x, y)&&curMap.entityMap.get(i).solid){
                	return true;
                }
            }
        	return false;
        }
        
        //checks if a given point is within the collision box
        //of a solid dynamicEntity, and, if so, return true
        public boolean checkSolidDynamicPointCollision(int x, int y){
        	for(int i = 0; i < overworld.getNode(curMap.gridX, curMap.gridY).size(); i++){
        		if(overworld.getNode(curMap.gridX, curMap.gridY).get(i).solid&&overworld.getNode(curMap.gridX, curMap.gridY).get(i).colBox.contains(x,y)){
        			return true;
        		}
            }
        	return false;
        }
        
        //checks for interaction between a static or 
        //dynamic entity
        public void checkGeneralInteract(int dir){
        	checkDynamicInteract(dir);
        	checkStaticInteract(dir);
        }
        
        //method for player interactin with static
        //objects
        public void checkStaticInteract(int dir){
        	for(int i = 0; i < curMap.entityMap.size(); i++){
                if(dir==0&&curMap.entityMap.get(i).colBox.contains(PLAYER.getX()+10, PLAYER.getY()-1)){
                	curMap.entityMap.get(i).interact();
                	
                }
                if(dir==1&&curMap.entityMap.get(i).colBox.contains(PLAYER.getX()+10, PLAYER.getY()+21)){
                	curMap.entityMap.get(i).interact();
                	
                }
                if(dir==2&&curMap.entityMap.get(i).colBox.contains(PLAYER.getX()-1, PLAYER.getY()+10)){
                	curMap.entityMap.get(i).interact();
                	
                }
                if(dir==3&&curMap.entityMap.get(i).colBox.contains(PLAYER.getX()+21, PLAYER.getY()+10)){
                	curMap.entityMap.get(i).interact();
                	
                }
            }
        }
        
      //method for player interacting with dynamic
        //objects
        public void checkDynamicInteract(int dir){
        	for(int i = 0; i < overworld.getNode(curMap.gridX, curMap.gridY).size(); i++){
        		if(dir==0&&overworld.getNode(curMap.gridX, curMap.gridY).get(i).colBox.contains(PLAYER.getX()+10, PLAYER.getY()-1)){
        			overworld.getNode(curMap.gridX, curMap.gridY).get(i).interact();
                	
                }
                if(dir==1&&overworld.getNode(curMap.gridX, curMap.gridY).get(i).colBox.contains(PLAYER.getX()+10, PLAYER.getY()+21)){
                	overworld.getNode(curMap.gridX, curMap.gridY).get(i).interact();
                	
                }
                if(dir==2&&overworld.getNode(curMap.gridX, curMap.gridY).get(i).colBox.contains(PLAYER.getX()-1, PLAYER.getY()+10)){
                	overworld.getNode(curMap.gridX, curMap.gridY).get(i).interact();
                	
                }
                if(dir==3&&overworld.getNode(curMap.gridX, curMap.gridY).get(i).colBox.contains(PLAYER.getX()+21, PLAYER.getY()+10)){
                	overworld.getNode(curMap.gridX, curMap.gridY).get(i).interact();
                	
                }
            }
        }
        
        public void exploreMusicUpdate(){
        	counter++;
        	//System.out.println(counter);
        	if(counter > 31000){
        		if(Reader.getRandInt(0, 1)==0){
        			counter = 0;
        			Reader.setMusic("sound/music/explore"+currentExplore+".wav", false);
        			currentExplore++;
        			if(currentExplore > maxExplore){
        				currentExplore = 1;
        			}
        		}
        		else{
        			counter = 0;
        		}
        	}
        }
        
        //Removes all current hudcards and replaces them
        //with the deck of hudcards assosciated with common gameplay
        public static void loadPlayGameDeck(){
        	hudCards.removeAll(hudCards);
        	hudCards.add(playerInventoryCard);
        	active = 0;
        	hudCards.add(1, new menuCard());
        	if(DEVMODE){
        		hudCards.add(devCard);
        	}
        }
}
