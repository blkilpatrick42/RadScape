package com.mygdx.game;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;
public class Dialogue implements Serializable{
	public ArrayList<DialogueNode> nodeList = new ArrayList<DialogueNode>();
	public DialogueNode curNode;
	public String name;
	public String[] startStates;
	public String[] portraits;
	public Dialogue(String inName, String[] inPortraits, String[] inStates, Scanner inScan, int setCurNode){
		portraits = inPortraits;
		startStates = inStates;
		name = inName;
		while(inScan.hasNext()){
			int inPortrait = inScan.nextInt();
			//System.out.println("\ninPortrait = "+inPortrait);
			String inString = inScan.nextLine();
			//System.out.println("\ninString = "+inString);
			Response inResponses[] = new Response[4];
			for(int i = 0; i < 4; i++){
				int tempNext = inScan.nextInt();
				if(tempNext == -2){
					inResponses[i] = new Response(-2,0,0,"");
				}
				else{
					//System.out.println("tempNext: " + tempNext);

					int tempSet = inScan.nextInt();
					//System.out.println("tempSet: "+ tempSet);
					int tempItem = inScan.nextInt();
					//System.out.println("tempItem: "+ tempItem);
					String inText = inScan.nextLine();
					//System.out.println("inText: "+ inText);
					inResponses[i] = new Response(tempNext,tempSet,tempItem,inText);
				}
			}
			nodeList.add(new DialogueNode(inPortrait,inString,inResponses));
		}
		curNode = nodeList.get(setCurNode);
		inScan.close();
	}
	
	public void setCurNode(int i){
		curNode = nodeList.get(i);
	}
	
	public void getStartNode(){
		Scanner tempScanner;
		int tempA;
		int tempB;
		for(int i =0; i<startStates.length;i++){
			tempScanner = new Scanner(startStates[i]);
			tempA = tempScanner.nextInt();
			tempB = tempScanner.nextInt();
			if(tempA == 0){
				setCurNode(0);
			}
			else if(Reader.statusListContains(tempA)){
				setCurNode(tempB);
			}
			tempScanner.close();
		}
		
	}
	
	
}





