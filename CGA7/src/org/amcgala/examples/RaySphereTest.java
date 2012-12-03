package org.amcgala.examples;

import org.amcgala.Framework;
import org.amcgala.Scene;
import org.amcgala.framework.math.Plane;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.raytracer.RGBColor;
import org.amcgala.framework.raytracer.material.MirrorMaterial;
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
        scene.setBackground(new RGBColor(0,0,0));

        Sphere sphere = new Sphere(new Vector3d(-10, 100, -120), 40);
        sphere.setColor(new RGBColor(0,0,1));
        sphere.setMaterial(new MirrorMaterial(0.25f, new RGBColor(1,1,1)));
        scene.add(sphere, sphereNode);

        Sphere sphere2 = new Sphere(new Vector3d(110, 100, -50), 50);
        sphere2.setColor(new RGBColor(1, 0, 0));
        sphere2.setMaterial(new MirrorMaterial(0.25f, new RGBColor(1,1,1)));
        scene.add(sphere2, sphereNode);
        
        Sphere sphere12 = new Sphere(new Vector3d(150, 240, -400), 30);
        sphere12.setColor(new RGBColor(0, 1, 0));
        sphere12.setMaterial(new MirrorMaterial(0.25f, new RGBColor(1,1,1)));
        scene.add(sphere12, sphereNode);
        
        Sphere sphere32 = new Sphere(new Vector3d(-150, 140, -10), 30);
        sphere32.setColor(new RGBColor(0, 1, 0));
        sphere32.setMaterial(new MirrorMaterial(0.25f, new RGBColor(1,1,1)));
        scene.add(sphere32, sphereNode);

        framework.addScene(scene);
    }

    public static void main(String[] args) {
        new RaySphereTest();
    }
}
