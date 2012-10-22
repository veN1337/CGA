package org.amcgala.example.turtle;

import org.amcgala.TurtleMode;

public class TurtleGraph extends TurtleMode{
	
	double xPos;
	double xNeg;
	double yPos;
	double yNeg;
    int nullX;
	int nullY;
	
	int width;
	int height;

	public static void main(String[] args) {
		new TurtleGraph();
        
    }
	
	@Override
	public void turtleCommands() {
		// TODO Auto-generated method stub
		init();
		defineConstants(20,5,10,2);
		drawAxes();
		
	}
	
	public void init(){
		width=800;
		height=600;
	}
	
	public void defineConstants(int xp, int xn, int yp, int yn){
		xPos = xp;
		xNeg = xn;
		yPos = yp;
		yNeg = yn;
		nullX = (int)(800*(xNeg/(xPos+xNeg)));
		nullY = (int)(600*(yPos/(yPos+yNeg)));
		System.out.println(nullX);
		System.out.println(nullY);
		
	}
	
	public void drawAxes(){
		up();
		turnLeft(180);
		move(width/2);
		turnRight(90);
		move(height/2);
		turnLeft(180);
		move(nullY);
		turnLeft(90);
		down();
		move(width);
		turnLeft(180);
		up();
		move(width);
		turnRight(90);
		move(nullY);
		turnRight(90);
		move(nullX);
		turnRight(90);
		down();
		move(height);
		up();
		turnRight(180);
		move(height);
		turnLeft(90);
		move(nullX);
		turnRight(180);
		
	}

}
