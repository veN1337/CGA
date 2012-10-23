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
	
	int x =30;
	int y =20;

    private Line line1 = new Line(-390, 0, 390, 0);
    private Line line2 = new Line(0, -270, 0, 270);
    //private Text text = new Text("Textbeispiel", 0, 0);

    @Override
    public void render(Renderer renderer) {
    	line1.render(renderer);
        line2.render(renderer);
        double sl=0.1;
        for(double x1=-x; x1<x; x1+=sl){
        	Line graph = new Line(x1*(390/x),f(x1)*(270/y),(x1+sl)*(390/x),f(x1+sl)*(270/y));
        	graph.setColor(Color.RED);
        	graph.render(renderer);
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
    			double test =(((double)x/5)*i);
    			new Text(""+test,i*(780/11)-40,-25).render(renderer);
    		}
    		else if(i>0){
    			double test =(((double)x/5)*i);
    			new Text(""+test,i*(780/11)-20,8).render(renderer);
    		}
    	}
    	for(int i = -5; i <=5;i++){
    		if(i>0){
    			double test =(((double)y/5)*i);
    			new Text(""+test,10,i*(540/11)-8).render(renderer);
    		}
    		else if (i<0){
    			double test =(((double)y/5)*i);
    			new Text(""+test,-68,i*(540/11)-10).render(renderer);
    		}
    	}
        
        //text.render(renderer);
    }
   

    /**
     * Abstrakte mathematische Funktion
     *
     * @param x Berechnungswert
     * @return Ergebnis
     */
    public abstract double f(double x);
}
