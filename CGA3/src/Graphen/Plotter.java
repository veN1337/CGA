package Graphen;

import org.amcgala.Amcgala;
import org.amcgala.Scene;
import org.amcgala.framework.scenegraph.Node;

/**
 * Hauptprogramm für den Plotter.
 */
public class Plotter extends Amcgala {

    private Scene scene = new Scene("PlotterScene");
    private Node graphNode = new Node("GraphNode");

    /**
     * Graph ist abstrakt, daher müssen alle abstrakten Methoden implementiert werden.
     * Hier als Beispiel x^2
     */
    private Graph graph = new Graph() {
        @Override
        public double function(double x) {
            return x * x;
        }
    };

    public Plotter() {
        // fügt eine neue Scene hinzu
        this.framework.addScene(scene);
        // fügt ein neues Element mit Knotenpunkt zum Scenengraphen hinzu
        this.scene.add(graph, graphNode);
        // startet das Framework
        this.framework.start();
    }

    public static void main(String[] args) {
        // Erstellt den Plotter und startet das Programm
        new Plotter();
    }
}
