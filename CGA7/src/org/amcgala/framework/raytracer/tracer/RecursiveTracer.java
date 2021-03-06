package org.amcgala.framework.raytracer.tracer;

import org.amcgala.Scene;
import org.amcgala.framework.raytracer.RGBColor;
import org.amcgala.framework.raytracer.Ray;
import org.amcgala.framework.raytracer.ShadingInfo;
import org.amcgala.framework.shape.Shape;

import java.util.Collection;

/**
 * Rekursiver Raytracer, der für die Berechnung von Reflexionen verwendet werden kann.
 *
 * @author Robert Giacinto
 * @since 2.1
 */
public class RecursiveTracer implements Tracer {
    private int maxDepth;

    /**
     * Erzeugt einen neuen rekursiv arbeitenden Tracer. Die Rekursionstiefe bestimmt, wie oft von einem Schnittpunkt ein
     * neuer Strahl in die Szene geschickt wird.
     *
     * @param maxDepth die Anzahl von Bounds innerhalb der Szene
     */
    public RecursiveTracer(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    @Override
    public RGBColor trace(Ray ray, Scene scene) {
        return trace(ray, scene, 0);
    }

    @Override
    public RGBColor trace(Ray ray, Scene scene, int depth) {
        /*
         * TODO Die rekursive Version des Tracers aus Aufgabe 7.
         * Innerhalb dieser Methode muss wieder mit ShadingInfo Instanzen gearbeitet werden. Dem Objekt müssen folgende
         * Informationen mitgegeben werden, bevor die shape.hit(ray, shadingInfo) Methode aufgerufen wird:
         *
         *      - Rekursionstiefe
         *      - aktuelle Szene
         *      - Referenz auf den Tracer
         */

        if (depth > maxDepth) {
            return scene.getBackground();
        }

        ShadingInfo result = new ShadingInfo();
        result.color = scene.getBackground();


        Collection<Shape> shapes = scene.getShapes();
        for (Shape s : shapes) {
            ShadingInfo tmp = new ShadingInfo();
            tmp.depth = depth;
            tmp.scene = scene;
            tmp.tracer = this;

            if (s.hit(ray, tmp)) {
                if (tmp.t < result.t) {
                    result = tmp;
                }
            }
        }

        return result.color;

    }
}
