import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.common.eventbus.Subscribe;
import org.amcgala.Amcgala;
import org.amcgala.Scene;
import org.amcgala.framework.event.InputHandler;
import org.amcgala.framework.event.MouseClickedEvent;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.scenegraph.Node;
import org.amcgala.framework.shape.Line;
import org.amcgala.framework.shape.Shape;
import org.amcgala.framework.shape.shape2d.Rectangle;

/**
 * Dieses Beispiel zeigt, wie man mit MouseEvents innerhalb des Frameworks umgehen kann.
 */
public class Input extends Amcgala implements InputHandler {
	
    private static final boolean alles = true;
    
	private Scene inputScene = new Scene("inputScene");
    private Node inputNode = new Node("input");
    
    private int prevX = 0;
    private int prevY = 0;
    
    private List<Rectangle> points = new ArrayList<Rectangle>();
    
    private List<Shape> lines = new ArrayList<Shape>();
        
    int boxsize = 400;
    Rectangle box = new Rectangle(-boxsize/2,-boxsize/2,boxsize,boxsize);
    
    public Input() {
    	inputScene.add(box, inputNode);
        framework.addScene(inputScene);
        framework.addInputHandler(this, "input");
    }

    @Subscribe
    public void addPoint(MouseClickedEvent e) {
    	if(points.size() >= 2) {
    		inputScene.removeShape(points.get(0).getLabel());
    		inputScene.removeShape(points.get(1).getLabel());
    		for(Shape s: lines) {
    			inputScene.removeShape(s.getLabel());
    		}
       		points.clear();
       		lines.clear();
    	}
    	Rectangle r = new Rectangle(e.getX(), e.getY(), 6, 6);
    	points.add(r);
        inputScene.add(r, inputNode);
        if(points.size() == 2) {
        	Line oldline = new Line(prevX, prevY, e.getX() + 3, e.getY() + 3);
        	try {
				Line newline = clip(oldline);
				lines.add(newline);
				inputScene.add(newline, inputNode);
				if(alles) {
					Line s1 = new Line(oldline.getStart(),newline.getStart());
					Line s2 = new Line(newline.getEnd(),oldline.getEnd());
					s1.setColor(Color.GREEN);
					s2.setColor(Color.GREEN);
					lines.add(s1);
					lines.add(s2);
					inputScene.add(s1, inputNode);
					inputScene.add(s2, inputNode);					
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Die Linie befindet sich außerhalb des Viewports","Linie außerhalb", JOptionPane.ERROR_MESSAGE);
				inputScene.removeShape(points.get(0).getLabel());
	    		inputScene.removeShape(points.get(1).getLabel());
				points.clear();
			}
        }
        prevX = e.getX() + 3; prevY = e.getY() + 3;
    }

    private Line clip(Line l) throws Exception {
    	
    	Vector3d p0 = l.getStart();
    	Vector3d p1 = l.getEnd();

		// Unten
		Vector3d E0 = box.bottom.getStart();
		Vector3d n0 = new Vector3d(0,1,0);
		double t0 = p0.sub(E0).dot(n0)/p0.sub(p1).dot(n0);

		if (p1.sub(p0).dot(n0) > 0) {
			if (t0 <= 1 && t0 >= 0)
				p0 = p0.add(p1.sub(p0).times(t0));
			else if (t0 > 1)
				throw new Exception();
		} else if (p1.sub(p0).dot(n0) < 0) {
			if (t0 <= 1 && t0 >= 0)
				p1 = p0.add(p1.sub(p0).times(t0));
			else if (t0 < 0)
				throw new Exception();
		}

		// Links
		Vector3d E1 = box.top.getStart();
		Vector3d n1 = new Vector3d(1,0,0);
		double t1 = p0.sub(E1).dot(n1)/p0.sub(p1).dot(n1);

		if (p1.sub(p0).dot(n1) > 0) {
			if(t1 <= 1 && t1 >= 0)
				p0 = p0.add( p1.sub(p0).times(t1));
			else if (t1 > 1)
				throw new Exception();
		} else if (p1.sub(p0).dot(n1) < 0) {
			if (t1 <= 1 && t1 >= 0)
				p1 = p0.add(p1.sub(p0).times(t1));
			else if (t1 < 0)
				throw new Exception();
		}

		// Oben
		Vector3d E2 = box.top.getEnd();
		Vector3d n2 = new Vector3d(0,-1,0);

		double t2 = p0.sub(E2).dot(n2)/p0.sub(p1).dot(n2);

		if (p1.sub(p0).dot(n2) > 0) {
			if (t2 <= 1 && t2 >= 0)
				p0 = p0.add(p1.sub(p0).times(t2));
			else if (t2 > 1)
				throw new Exception();
		} else if(p1.sub(p0).dot(n2) < 0) {
			if (t2 <= 1 && t2 >= 0)
				p1 = p0.add(p1.sub(p0).times(t2));
			else if (t2 < 0)
				throw new Exception();
		}

		// Rechts
		Vector3d E3 = box.bottom.getEnd();
		Vector3d n3 = new Vector3d(-1,0,0);
		double t3 = p0.sub(E3).dot(n3)/p0.sub(p1).dot(n3);

		if (p1.sub(p0).dot(n3) > 0) {
			if (t3 <= 1 && t3 >= 0)
				p0 = p0.add(p1.sub(p0).times(t3));
			else if (t3 > 1)
				throw new Exception();
		} else if(p1.sub(p0).dot(n3) < 0) {
			if (t3 <= 1 && t3 >= 0)
				p1 = p0.add(p1.sub(p0).times(t3));
			else if (t3 < 0)
				throw new Exception();
		}
		return new Line(p0,p1);

	}
    
    public static void main(String[] args) {
        new Input();
    }
        
}