import com.google.common.eventbus.Subscribe;
import org.amcgala.Amcgala;
import org.amcgala.Scene;
import org.amcgala.framework.event.InputHandler;
import org.amcgala.framework.event.MouseClickedEvent;
import org.amcgala.framework.scenegraph.Node;
import org.amcgala.framework.shape.shape2d.Rectangle;

/**
 * Dieses Beispiel zeigt, wie man mit MouseEvents innerhalb des Frameworks umgehen kann.
 */
public class Input extends Amcgala implements InputHandler {
    private Scene inputScene = new Scene("inputScene");
    private Node inputNode = new Node("input");

    public Input() {
        framework.addScene(inputScene);
        framework.addInputHandler(this, "input");
    }

    @Subscribe
    public void addPoint(MouseClickedEvent e) {
        inputScene.add(new Rectangle(e.getX(), e.getY(), 5, 5), inputNode);
    }

    public static void main(String[] args) {
        new Input();
    }
}