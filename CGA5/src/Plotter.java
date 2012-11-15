import org.amcgala.Amcgala;
import org.amcgala.Scene;
import org.amcgala.framework.animation.interpolation.LinearInterpolation;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.scenegraph.Node;
import org.amcgala.framework.scenegraph.transform.RotationY;
import org.amcgala.framework.scenegraph.transform.Translation;
import org.amcgala.framework.shape.shape3d.Box;

public class Plotter extends Amcgala {

    private Scene scene = new Scene("PlotterScene");
    
    private Node boxNode = new Node("boxNode");
    private Box box = new Box(new Vector3d(-200, -200, -200), -400, -400, -400); 
    
    private Node pendelNode = new Node("pendelNode");
    private Box pendel = new Pendel(new Vector3D(-200,-200,-200), 50,50,50);
    
    private Translation trans = new Translation(400,400,0);
    private RotationY rb = new RotationY(0);

    public Plotter() {
        this.framework.addScene(scene);
        
        this.scene.add(box, boxNode);
        rb.setInterpolationPhi(new LinearInterpolation(0, 2 * Math.PI, 600, true));
        this.boxNode.add(rb);
        this.boxNode.add(trans);
        
        this.scene.add(pendel,pendelNode);
        
        this.framework.show();
    }

    public static void main(String[] args) {
        new Plotter();
    }
}

