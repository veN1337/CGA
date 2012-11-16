import java.util.ArrayList;
import java.util.List;

import com.google.common.eventbus.Subscribe;
import org.amcgala.Amcgala;
import org.amcgala.Scene;
import org.amcgala.framework.event.InputHandler;
import org.amcgala.framework.event.MouseClickedEvent;
import org.amcgala.framework.scenegraph.Node;
import org.amcgala.framework.shape.Line;
import org.amcgala.framework.shape.shape2d.Rectangle;

/**
 * Dieses Beispiel zeigt, wie man mit MouseEvents innerhalb des Frameworks umgehen kann.
 */
public class Input extends Amcgala implements InputHandler {
    private Scene inputScene = new Scene("inputScene");
    private Node inputNode = new Node("input");
    
    private int prevX = 0;
    private int prevY = 0;
    
    private List<Rectangle> liste = new ArrayList<Rectangle>();
    
    int boxsize = 400;
    
    public Input() {
    	inputScene.add(new Rectangle(-boxsize/2,-boxsize/2,boxsize,boxsize), inputNode);
        framework.addScene(inputScene);
        framework.addInputHandler(this, "input");
    }

    @Subscribe
    public void addPoint(MouseClickedEvent e) {
    	if(liste.size() >= 2) {
    		inputScene.removeShape(liste.get(0).getLabel());
    		inputScene.removeShape(liste.get(1).getLabel());
    		inputScene.removeShape("linie");
       		liste.clear();
    	}
    	Rectangle r = new Rectangle(e.getX(), e.getY(), 6, 6);
    	liste.add(r);
        inputScene.add(r, inputNode);
        if(liste.size() == 2) {
        	Line l = new Line(prevX, prevY, e.getX() + 3, e.getY() + 3, "linie");
        	inputScene.add(l, inputNode);
        }
        prevX = e.getX() + 3; prevY = e.getY() + 3;
    }

    public static void main(String[] args) {
        new Input();
    }
}