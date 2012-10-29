package Graphen;

import org.amcgala.Amcgala;
import org.amcgala.Scene;
import org.amcgala.framework.scenegraph.Node;

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
            return Math.sin(Math.tan(x));
        }
    };
    
    public Plotter() {
    	
    	graph.setVars(0.75*Math.PI, 10, 0.001);
    	
        // f�gt eine neue Scene hinzu
    	this.scene.setRenderer(new aufgabe4.BresenhamRenderer(scene.getCamera()));
        this.framework.addScene(scene);
        //System.out.println(System.currentTimeMillis());
        //System.out.println(this.framework.getWidth() + " - " + this.framework.getHeight());
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

/*


1351147977504
1351148005626

28122ms


*/