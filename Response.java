package com.mygdx.game;

import java.io.Serializable;

//Represents a response in a dialogue node
public class Response implements Serializable{
	public int nextAct;  //index of node to jump to. End dialogue if -1, exit to battle if below -2
	public int setCode;  //Code to add to the statuscode list
	public int itemCode; //index of the item to interact with
	public String responseText; //the text the player sees for the response.
	public Response(int inNextAct, int inSetCode, int inItemCode, String inText){
		nextAct = inNextAct;
		setCode = inSetCode;
		itemCode = inItemCode;
		responseText = inText;
	}
}
