package com.mygdx.game;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class Path implements Serializable{
	ArrayList<PathNode> pathNodes;
	public Path(String fileName){
		pathNodes = new ArrayList<PathNode>();
		String readString = Reader.readStringFromFile(fileName);
		Scanner fileScan = new Scanner(readString);
		int temp = 0;
		String sTemp = "";
		while(fileScan.hasNext()){
			temp = fileScan.nextInt();
			sTemp = fileScan.nextLine();
			pathNodes.add(new PathNode(temp,sTemp));
		}
	}
}
