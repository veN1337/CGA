package aufgabe4;

import org.amcgala.Amcgala;
import org.amcgala.Scene;
import org.amcgala.framework.scenegraph.Node;

import aufgabe4.BresenhamRenderer;
import Graphen.*;

/**
 * Hauptprogramm f�r den Plotter.
 */
public class Plotter extends Amcgala {

    private Scene scene = new Scene("PlotterScene");    	
    private Node graphNode = new Node("GraphNode");

    /**
     * Graph ist abstrakt, daher m�ssen alle abstrakten Methoden implementiert werden.
     * Hier als Beispiel x^2
     */
    private Graph graph = new Graph() {
    	
        @Override
        public double f(double x) {
            return x * x;
        }
    };
    
    public Plotter() {
    	
    	graph.setVars(10, 10, 0.1);
    	
        // f�gt eine neue Scene hinzu
    	this.scene.setRenderer(new BresenhamRenderer(scene.getCamera()));
        this.framework.addScene(scene);
        System.out.println(this.framework.getWidth() + " - " + this.framework.getHeight());
        // f�gt ein neues Element mit Knotenpunkt zum Scenengraphen hinzu
        this.scene.add(graph, graphNode);
        // startet das Framework
        this.framework.start();
    }

    public static void main(String[] args) {
        // Erstellt den Plotter und startet das Programm
        new Plotter();
    }
}
