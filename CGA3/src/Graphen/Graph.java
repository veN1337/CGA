package Graphen;

import org.amcgala.framework.renderer.Renderer;
import org.amcgala.framework.shape.AbstractShape;
import org.amcgala.framework.shape.Line;
import org.amcgala.framework.shape.shape2d.Text;

/**
 * Abstract Graph mit einer Abstrakt definierten Funktion.
 * TODO: Zeichnen des Graphens in passenden Maﬂstab
 */
public abstract class Graph extends AbstractShape {
	
	int x =5;
	int y =5;

    private Line line1 = new Line(-390, 0, 390, 0);
    private Line line2 = new Line(0, -270, 0, 270);
    //private Text text = new Text("Textbeispiel", 0, 0);

    @Override
    public void render(Renderer renderer) {
    	for(int i = -5; i <=5;i++){
    		if(i<0){
    			new Line(i*(780/11),0,i*(780/11),-6).render(renderer);
    			double test =((double)x*((double)i/(double)x));
    			//new Text(""+test,i*(780/11),-8).render(renderer);
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
        line1.render(renderer);
        line2.render(renderer);
        //text.render(renderer);
    }

    /**
     * Abstrakte mathematische Funktion
     *
     * @param x Berechnungswert
     * @return Ergebnis
     */
    public abstract double function(double x);
}
