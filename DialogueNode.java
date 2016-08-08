package com.mygdx.game;

import java.io.Serializable;

//Represents a node of dialogue, in the form of a display text,
//4 responses, and a displayed portrait
public class DialogueNode implements Serializable{
	public int portrait; //index of the local portrait
	public String nodeText; //the text the player sees the character saying
	public Response responses[]; //the responses the player can select
	public DialogueNode(int inPortrait, String nodeTest, Response inResponses[]){
		portrait = inPortrait;
		nodeText = nodeTest;
		responses = inResponses;
	}
	
}
