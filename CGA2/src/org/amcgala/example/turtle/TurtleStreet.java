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
    	double height = (int) (80+Math.random()*220);
    	int width = (int) (80+Math.random()*260);
    	int etagen = 2+(int)(Math.random()*5);
		move(width);
    	turnLeft(180);
    	int doorL = (int)(width/4);
    	move((int)(width/2 + doorL/2 + 0.5));
    	turnRight(90);
    	move((int)(height/etagen/2));
    	turnRight(90);
    	move(doorL);
    	turnRight(90);
    	move((int)(height/etagen/2));
    	turnLeft(90);
    	move((int)(width/2 - doorL/2 +0.5));
        turnLeft(90);
        move(height);
        
        if(1+Math.random()*5<3){
        	drawRoof(width);
        }
        else{
        	turnLeft(90);
        }
        move(width);
        turnLeft(90);
        move(height);
        turnRight(180); 
        drawStages(height, width, etagen);
        up();
        turnLeft(90);
        move(height);
        turnLeft(90);
        
    }
	private void drawStages(double height, int width, int etagen) {
		for(int i=0; i<etagen;i++){
        	int fenster = 1+(int)(Math.random()*6);
        	up();
        	move(height/etagen);
            turnRight(90);
            down();
            move(width);
            turnRight(180);
            up();

            if(i<etagen-1){
            	move(6);
                turnRight(90);
                move(6);
            	for(int j=0; j<fenster;j++){
            		if((int)(Math.random()*5)<3){
            			drawWindow(height, width, etagen, fenster);
            		}
            		else {
            			up();
            			turnLeft(90);
            			move((width-((fenster+1)*6))/fenster+6);
            			turnRight(90);
            		}
            	}
            	turnLeft(90);
            	int anpassung = (width-((fenster+1)*6))-(((int)((width-((fenster+1)*6))/fenster))*fenster);
            	if(anpassung>0)
            		move(anpassung);
            	turnRight(90);
            	turnRight(180);
            	move(6);
            	turnRight(180);
            }
            
        }
	}
	private void drawWindow(double height, int width, int etagen, int fenster) {
		down();
		move(height/etagen - 12);
		turnLeft(90);
		move((width-((fenster+1)*6))/fenster);
		turnLeft(90);
		move(height/etagen - 12);
		turnLeft(90);
		move((width-((fenster+1)*6))/fenster);
		up();
		turnLeft(180); 
		move((width-((fenster+1)*6))/fenster+6);
		turnRight(90);
	}
	private void drawRoof(int width) {
		int albe = (int) (20+Math.random()*50+0.5);
		int ga = 180 - albe*2;
		int ab = (int) (width * Math.sin(albe*Math.PI/180) / Math.sin(ga*Math.PI/180) + 0.5);
		turnLeft(90 - albe);
		move(ab);
		turnLeft(180 - ga);
		move(ab);
		turnLeft(180 - albe);
		move(width);
		turnLeft(180);
	}
    
    private void drawHouses() {
    	int anzahl = (int) (2+Math.random()*6);
    	for(int i=0;i<anzahl;i++){
    		move(20);
    		newHouse();
    	}
    	
    }

    public static void main(String[] args) {
		new TurtleStreet();
    }
}
