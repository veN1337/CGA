import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.renderer.Renderer;
import org.amcgala.framework.shape.AbstractShape;

public class Pendel extends AbstractShape {
	
	private Vector3d pos;
	private static Vector3d newpos = new Vector3d(0,0,0);
	private int radius;	
	
	private Vector3d speed = new Vector3d(0, 0, 0);	    
	private Vector3d decelerate = new Vector3d(-0.1, -0.2, -0.15);	    
	private Vector3d attenuation = new Vector3d(0.99, 0.99, 0.99);
	
	 private List<Vector3d> liste = new ArrayList<Vector3d>();

	public Pendel(Vector3d p, int r) {
        this.pos = p;
        this.radius = r;
	}
	
	@Override
    public void render(Renderer renderer) { 
        newpos = pos; 
        speed.x = decelerate.x * pos.x + attenuation.x * speed.x;
        newpos.x = pos.x + speed.x;

        speed.y = decelerate.y * pos.y + attenuation.y * speed.y;
        newpos.y = pos.y + speed.y;

        speed.z = decelerate.z * pos.z + attenuation.z * speed.z;
        newpos.z = pos.z + speed.z;

        liste.add(new Vector3d(newpos));
        renderer.setColor(Color.red);
        renderer.drawCircle(newpos,radius);
        
        if(liste.size() > 60){
        	liste.remove(0);
        }
        Vector3d v = liste.get(0);
        for (Vector3d l: liste) {
        	renderer.setColor(Color.blue);
        	renderer.drawLine(v, l);
            v = l;
        }        
	}       

}
