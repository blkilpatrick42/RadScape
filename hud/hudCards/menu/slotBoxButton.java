package com.mygdx.game.hud.hudCards.menu;
import com.mygdx.game.RadScape;
import com.mygdx.game.Reader;
import com.mygdx.game.VisualAspect;
import com.mygdx.game.HudEntity;
import com.mygdx.game.Map;
public class slotBoxButton extends HudEntity{
	boolean newGame;
	public int slot;
	public slotBoxButton(boolean inNewGame, int inSlot, int inX, int inY){
		newGame = inNewGame;
		slot = inSlot;
		aspect = new VisualAspect("hud/hudCards/menuB/newGameCard/slotBox.png", inX, inY);
		updateColBox();
	}
	public void interact(){
		Reader.setSaveSlot(slot);
		//This action sets the Reader's active game slot to this button's given slot number.
		//it then proceeds with appending the first of the player elaboration cards.
		if(newGame){
			RadScape.hudPrinter.type("Save Slot "+slot+"                  WARNING: This will overwrite any current game in this slot.");
			
			RadScape.hudCards.add(new newGameCardB());
			RadScape.active=RadScape.hudCards.size()-1;
		}
		else{
			if(Reader.loadPlayer("save/slot"+slot+"/player.dat")!=null){
				Reader.loadGame();
				RadScape.loadPlayGameDeck();
				if(RadScape.windowMode!='w'){
					RadScape.windowMode='w';
				}
				Reader.stopMusic();
			}
		}
	}
}
