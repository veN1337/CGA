package Graphen;

import java.awt.Color;

import org.amcgala.framework.renderer.Renderer;
import org.amcgala.framework.shape.AbstractShape;
import org.amcgala.framework.shape.Line;
import org.amcgala.framework.shape.shape2d.Text;

/**
 * Abstract Graph mit einer Abstrakt definierten Funktion.
 * TODO: Zeichnen des Graphens in passenden Ma�stab
 */
public abstract class Graph extends AbstractShape {
	
	double x = 10;
	double y = 10;
	double sl = 0.5;
	
    private Line line1 = new Line(-390, 0, 390, 0);
    private Line line2 = new Line(0, -290, 0, 290);
    //private Text text = new Text("Textbeispiel", 0, 0);

    @Override
    public void render(Renderer renderer) {
    	line1.render(renderer);
        line2.render(renderer);
        
        for(double x1=-x; x1<x; x1+=sl){
        	//                        390           270             390              270
        	Line graph = new Line(x1*(390/x),f(x1)*(340/y),(x1+sl)*(390/x),f(x1+sl)*(340/y));
        	graph.render(renderer);
        	//graph.update();
        }
    	for(int i = -5; i <=5;i++){
    		if(i<0){
    			new Line(i*(780/11),0,i*(780/11),-6).render(renderer);
    		}
    		else{
    			new Line(i*(780/11),0,i*(780/11),6).render(renderer);
    		}
    	}
    	for(int i = -5; i <=5;i++){
    		if(i>0){
    			new Line(0,i*(540/11),6,i*(540/11)).render(renderer);
    		}
    		else{
    			new Line(0,i*(540/11),-6,i*(540/11)).render(renderer);
    		}
    	}
    	for(int i = -5; i <=5;i++){
    		if(i<0){
    			double test = (((double)x/5)*i);
    			
    			String s = ""+((double)(int)(test*10))/10;
    			
    			new Text(s,i*(780/11)-40,-25).render(renderer);
    		}
    		else if(i>0){
    			double test =(((double)x/5)*i);
    			
    			String s = ""+((double)(int)(test*10))/10;
    			
    			new Text(s,i*(780/11)-20,8).render(renderer);
    		}
    	}
    	for(int i = -5; i <=5;i++){
    		if(i>0){
    			double test =(((double)y/5)*i);
    			
    			String s = ""+((double)(int)(test*10))/10;
    					
    			new Text(s,10,i*(540/11)-8).render(renderer);
    		}
    		else if (i<0){
    			double test =(((double)y/5)*i);
    			
    			String s = ""+((double)(int)(test*10))/10;
    			
    			new Text(s,-68,i*(540/11)-10).render(renderer);
    		}
    	}
    	//System.out.println(System.currentTimeMillis());
        
        //text.render(renderer);
    }
    
	public void setVars(double x, double y, double sl) {
		
		this.x = x;
		this.y = y;
		this.sl = sl;
		
	}
   

    /**
     * Abstrakte mathematische Funktion
     *
     * @param x Berechnungswert
     * @return Ergebnis
     */
    public abstract double f(double x);
}
