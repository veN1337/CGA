package aufgabe4;

import org.amcgala.Amcgala;
import org.amcgala.Scene;
import org.amcgala.framework.scenegraph.Node;

import aufgabe4.BresenhamRenderer;

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
    private Graph graph = new Graph(20, 20, "X", "Y") {

		@Override
		public double function(double x) {
			// TODO Auto-generated method stub
			return x*x;
		}
    };
    
    public Plotter() {
    	
        // f�gt eine neue Scene hinzuMath.sin(x);
    	this.scene.setRenderer(new BresenhamRenderer(scene.getCamera()));
        this.framework.addScene(scene);
        System.out.println(System.currentTimeMillis());
        System.out.println(this.framework.getWidth() + " - " + this.framework.getHeight());
        // f�gt ein neues Element mit Knotenpunkt zum Scenengraphen hinzu
        this.scene.add(graph, graphNode);
        // startet das Framework
        this.framework.show();
        
    }

    public static void main(String[] args) {
        // Erstellt den Plotter und startet das Programm
        new Plotter();
    }
}

/*

1351148066677
1351148096474
29797ms

 */
