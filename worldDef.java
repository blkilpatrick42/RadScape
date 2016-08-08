package com.mygdx.game;

public class worldDef {
	public worldDef(){
	     Character	guy1 = new Character("guy1.png","guy1.chr","guy1.wander",1,1,12,14);
	     Character	guy2 = new Character("guy1.png","guy2.chr","guy2.wander",1,1,7,11);
	     Character	guy3 = new Character("girl1.png","guy3.chr","guy3.wander",1,1,15,1);
	     Item item1 = new Item("pie", "a slice of pie", 100000001, 0, 0,18,13);
	     Item item2 = new Item("pie", "a slice of pie", 100000001, 0, 0,18,20);
	     Item item3 = new Item("bikeTire", "an old bike tire", 100000002, 0, 1,8,9);
	     Item item4 = new Item("bikeTire", "a bent bike tire", 100000002, 0, 1,19,11);
	     Item item5 = new Item("ball", "a big red ball", 100000003, 1, 1,20,6);
	     Item item6 = new Item("ball", "a big red ball", 100000003, 1, 1,20,3);
	}
}
