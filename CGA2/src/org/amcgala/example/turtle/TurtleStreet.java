package org.amcgala.example.turtle;

import org.amcgala.TurtleMode;

/**
 * Aufgabe 2, CGA Praktikum
 * Turtle Street
 *
 * @author Aaron Reiher, Sascha Rothkopf
 */
public class TurtleStreet extends TurtleMode {

    @Override
    public void turtleCommands() {

         gotoStart();
         street();
         drawHouses();
         //asdjhgasdjgadhfahsd

    }

    private void street() {
    	move(800);
    	up();
    	turnRight(90);
    	move(200);
    	turnRight(90);
    	down();
    	move(800);
    	up();
    	turnRight(90);
    	move(100);
    	turnRight(90);
    	for(int i=0;i<5;i++) {
    		move(80);
    		down();
    		move(80);
    		up();
    	}
    	up();
    	turnLeft(90);
    	move(100);
    	turnLeft(90);
    	move(800);
    	turnRight(90);
    	move(40);
    	turnRight(90);
    }

    private void gotoStart(){
        up();
        turnLeft(180);
        move(400);
        turnRight(180);
        down();
    }

    private void newHouse() {
    	down();
    	double length = 80+Math.random()*220;
    	int etagen = 2+(int)(Math.random()*5);
    	move(136);
        turnLeft(90);
        move(length);
        turnLeft(90);
        move(136);
        turnLeft(90);
        move(length);
        turnRight(180);  
        for(int i=0; i< etagen;i++){
        	int fenster = 1+(int)(Math.random()*6);
        	up();
        	move(length/etagen);
            turnRight(90);
            down();
            move(136);
            turnRight(180);
            up();
            
            //int bigF = 0;
            if(i<etagen-1){
            	move(6);
                turnRight(90);
                move(6);
            	for(int j=0; j<fenster;j++){
            		if((int)(Math.random()*5)<3){
            			down();
            			move(length/etagen - 12);
            			turnLeft(90);
            			move((136-((fenster+1)*6))/fenster);
            			turnLeft(90);
            			move(length/etagen - 12);
            			turnLeft(90);
            			move((136-((fenster+1)*6))/fenster);
            			up();
            			turnLeft(180);
            			move((136-((fenster+1)*6))/fenster+6);
            			turnRight(90);
            		}
            		else{
            			up();
            			turnLeft(90);
            			move((136-((fenster+1)*6))/fenster+6);
            			turnRight(90);
            		}
            	}
            	move(length/etagen-6);
            }
            /*if(i<etagen-1){
            	bigF = (int) Math.round(Math.random());
	            if (bigF == 1) {
	            	move(6);
	                turnRight(90);
	                move(6);
	            	down();
	            	move(length/etagen - 12);
	            	turnLeft(90);
	            	move(124);
	            	turnLeft(90);
	            	move(length/etagen - 12);
	            	turnLeft(90);
	            	move(124);
	            	up();
	            	turnLeft(180);
	            	move(130);
	            	turnLeft(90);
	            	move(6);
	            	turnLeft(180);
	            }
	            
            }*/
            /*if(bigF ==0){
            	move(136);
                turnRight(90);
            }*/
            
        }
        turnRight(180);
        up();
        move(length);
        turnLeft(90);
        move(136);
        
    }
    
    private void drawHouses() {
    	for(int i=0;i<1;i++){
    		move(20);
    		newHouse();
    	}
    	
    }

    public static void main(String[] args) {
		new TurtleStreet();
        
    }
}
