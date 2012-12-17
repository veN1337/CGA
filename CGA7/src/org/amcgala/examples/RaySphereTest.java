package org.amcgala.examples;

import org.amcgala.Framework;
import org.amcgala.Scene;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.raytracer.RGBColor;
import org.amcgala.framework.raytracer.material.MirrorMaterial;
import org.amcgala.framework.scenegraph.Node;
import org.amcgala.framework.shape.shape3d.CheckerBoard;
import org.amcgala.framework.shape.shape3d.Sphere;

/**
 * Dieser Test sollte eine Kugel raytracen.
 */
public class RaySphereTest {

    public RaySphereTest() {
        Framework framework = Framework.createInstance(600, 600);
        Scene scene = new Scene("raytracer");
        Node sphereNode = new Node("sphere node");
        scene.setBackground(new RGBColor(0,0,0));

        Sphere sphere = new Sphere(new Vector3d(-10, 10, -120), 40);
        sphere.setMaterial(new MirrorMaterial(0.3f,0.4f, new RGBColor(1,1,1)));
        scene.add(sphere, sphereNode);
        
        Sphere sphere1 = new Sphere(new Vector3d(-100, 100, -200), 40);
        sphere1.setMaterial(new MirrorMaterial(0.3f,0.4f, new RGBColor(0,0,1)));
        scene.add(sphere1, sphereNode);

        Sphere sphere2 = new Sphere(new Vector3d(110, 50, -50), 50);
        sphere2.setMaterial(new MirrorMaterial(0.3f,0.4f, new RGBColor(1,1,0)));
        scene.add(sphere2, sphereNode);
        
        Sphere sphere12 = new Sphere(new Vector3d(150, 140, -400), 30);
        sphere12.setMaterial(new MirrorMaterial(0.3f,0.4f, new RGBColor(0,0.5f,0)));
        scene.add(sphere12, sphereNode);
        
        Sphere sphere32 = new Sphere(new Vector3d(-150, 40, -30), 30);
        sphere32.setMaterial(new MirrorMaterial(0.3f,0.4f, new RGBColor(0.4f,0.4f,0.4f)));
        scene.add(sphere32, sphereNode);
        
        CheckerBoard board = new CheckerBoard(new Vector3d(0, -300, 0), new Vector3d(1, 0, 0), new Vector3d(0, 0, 1), 600, new RGBColor(1,1,1), new RGBColor(0,0,0));
        scene.add(board, sphereNode);
        
        CheckerBoard board2 = new CheckerBoard(new Vector3d(0, -200, -6000), new Vector3d(1, 0, 0), new Vector3d(0, 1, 0), 600, new RGBColor(0.75f,0,0), new RGBColor(1,1,1));
        scene.add(board2, sphereNode);

        framework.addScene(scene);
    }

    public static void main(String[] args) {
        new RaySphereTest();
    }
}
