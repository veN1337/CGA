/*
 * Copyright 2011 Cologne University of Applied Sciences Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.amcgala.framework.raytracer;

import org.amcgala.Scene;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.raytracer.sampler.RegularSampler;
import org.amcgala.framework.raytracer.tracer.RecursiveTracer;
import org.amcgala.framework.raytracer.tracer.Tracer;
import org.amcgala.framework.renderer.Renderer;

/**
 * Der RaytraceVisitor traversiert den {@link org.amcgala.framework.scenegraph.SceneGraph} und berechnet die
 * Schnittpunkte den Objekten innerhalb der Szene.
 *
 * @author Robert Giacinto
 * @since 2.1
 */
public class Raytracer {

    private Scene scene;
    private Tracer tracer;
    private ViewPlane viewPlane;
    private Vector3d direction;
    private Vector3d eye;

    public Raytracer() {
        //tracer = new SimpleTracer();
        tracer = new RecursiveTracer(4);

        // Was bewirken die Parameter? Wie verändert sich das Ergebnis des Raytracers?
        viewPlane = new ViewPlane(600, 600, 1);
        eye = new Vector3d(0, 0, 650);
        viewPlane.setSampler(new RegularSampler());

    }

    public void setScene(Scene scene) {
        this.scene = scene;

    }

    public void setRenderer(Renderer renderer) {
        viewPlane.setRenderer(renderer);
    }

    public void traceScene() {
        /*
         * TODO
         * Für jedes Pixel
         *      Schieße einen Strahl von der Mitte eines jeden Pixels in die Szene
         *          Tipp: o = viewPlane.getWorldCoordinates(x, y);
         *      Berechne mithilfe des Tracers den Farbwert an der Stelle
         *      Färbe den Pixel an der Stelle (x,y) ein.
         *          Tipp: viewPlane.drawPixel(x, y, color)
         */

        for (int x = 0; x < viewPlane.getHorizontalResolution(); x++) {
            for (int y = 0; y < viewPlane.getVerticalResolution(); y++) {
                Vector3d org = viewPlane.getWorldCoordinates(x, y);
                direction = org.sub(eye);
                RGBColor color = tracer.trace(new Ray(org, direction), scene);
                viewPlane.drawPixel(x, y, color);
            }
        }

    }
}

