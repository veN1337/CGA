import org.amcgala.Amcgala;
import org.amcgala.Scene;

public class Plotter extends Amcgala {

    private Scene scene = new Scene("PlotterScene");

    public Plotter() {
        this.framework.addScene(scene);
       this.framework.show();
    }

    public static void main(String[] args) {
        new Plotter();
    }
}

