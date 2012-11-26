package org.amcgala.examples;

import org.amcgala.Framework;
import org.amcgala.Scene;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.raytracer.RGBColor;
import org.amcgala.framework.scenegraph.Node;
import org.amcgala.framework.shape.shape3d.Sphere;

import java.awt.*;

/**
 * Dieser Test sollte eine Kugel raytracen.
 */
public class RaySphereTest {

    public RaySphereTest() {
        Framework framework = Framework.createInstance(600, 600);
        Scene scene = new Scene("raytracer");
        Node sphereNode = new Node("sphere node");

        Sphere sphere = new Sphere(new Vector3d(-110, 100, -80), 50);
        sphere.setColor(new RGBColor(0,1,0));
        scene.add(sphere, sphereNode);

        Sphere sphere2 = new Sphere(new Vector3d(110, 100, -80), 50);
        sphere2.setColor(new RGBColor(1, 0, 0));
        scene.add(sphere2, sphereNode);

        framework.addScene(scene);
    }

    public static void main(String[] args) {
        new RaySphereTest();
    }
}
