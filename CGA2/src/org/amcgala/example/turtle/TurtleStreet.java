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
    	double height = 80+Math.random()*220;
    	int etagen = 2+(int)(Math.random()*5);
    	System.out.println("Etagen: "+ etagen);
    	move(136);
        turnLeft(90);
        move(height);
        turnLeft(90);
        move(136);
        turnLeft(90);
        move(height);
        turnRight(180); 
        for(int i=0; i<etagen;i++){
        	int fenster = 1+(int)(Math.random()*6);
        	//System.out.println("Max. Fenster: "+ fenster);
        	up();
        	move(height/etagen);
            turnRight(90);
            down();
            move(136);
            turnRight(180);
            up();

            if(i<etagen-1){
            	move(6);
                turnRight(90);
                move(6);
            	for(int j=0; j<fenster;j++){
            		if((int)(Math.random()*5)<3){
            			//System.out.println("fenster");
            			down();
            			move(height/etagen - 12);
            			turnLeft(90);
            			move((136-((fenster+1)*6))/fenster);
            			turnLeft(90);
            			move(height/etagen - 12);
            			turnLeft(90);
            			move((136-((fenster+1)*6))/fenster);
            			up();
            			turnLeft(180); 
            			move((136-((fenster+1)*6))/fenster+6);
            			turnRight(90);
            		}
            		else {
            			//System.out.println("kein fenster");

            			up();
            			turnLeft(90);
            			move((136-((fenster+1)*6))/fenster+6);
            			turnRight(90);
            		}
            	}
            	turnRight(180);
            	move(6);
            	turnRight(180);
            	//move((height/etagen)-6);
            }
            
        }
        up(); //down();
        turnLeft(90);
        move(height);
        turnLeft(90);
        
    }
    
    private void drawHouses() {
    	for(int i=0;i<5;i++){
    		move(20);
    		newHouse();
    	}
    	
    }

    public static void main(String[] args) {
		new TurtleStreet();
        
    }
}
