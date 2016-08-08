package com.mygdx.game;
import java.io.Serializable;
import java.util.Scanner;
public class PathNode implements Serializable{
	String action;
	int duration;
	public PathNode(int inDur, String inAct){
		action = inAct;
		duration = inDur;
	}
}
