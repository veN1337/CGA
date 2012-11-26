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

/**
 * Ein Objekt, das das Interface Hittable implementiert, kann von einem RaytraceVisitor für Schnittpunktsberechnungen verwendet
 * werden.
 *
 * @author Robert Giacinto
 * @since 2.1
 */
public interface Hittable {

    /**
     * Berechnet den Schnittpunkt des Shapes mit dem Strahl, der vom Raytracer in die Scene geschickt wird.
     *
     * @param ray       der Strahl, mit dem der Schnittpunkt berechnet werden soll
     * @param shadingInfo Das Ergebnisobjekt der Schnittberechnung
     */
    boolean hit(Ray ray, ShadingInfo shadingInfo);
}
