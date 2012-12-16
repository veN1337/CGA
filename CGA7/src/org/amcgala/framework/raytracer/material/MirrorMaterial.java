package org.amcgala.framework.raytracer.material;

import org.amcgala.framework.math.MathConstants;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.raytracer.RGBColor;
import org.amcgala.framework.raytracer.Ray;
import org.amcgala.framework.raytracer.ShadingInfo;

/**
 * Spiegelndes Material für den Raytracer.
 *
 * @author Robert Giacinto
 * @since 2.1
 */
public class MirrorMaterial extends Material {
    private float reflectionCoefficient;
	private float refractionCoefficient;
    private RGBColor baseColor;

    /**
     * Ein reflektives Material, das die Umgebung spiegelt.
     *
     * @param reflectionCoefficient der Reflektionskoeffizient
     * @param baseColor             die Grundfarbe des Materials
     */
    public MirrorMaterial(float reflectionCoefficient, float refractionCoefficient, RGBColor baseColor) {
    	this.reflectionCoefficient = reflectionCoefficient;
    	this.refractionCoefficient = refractionCoefficient;
        // Nebenbedingung: refCo + refrCo <= 1 ansonsten IllegalArgumentException
    	if(reflectionCoefficient + refractionCoefficient > 1) {
    		throw new IllegalArgumentException("reflectionCoefficient + refractionCoefficient > 0");
    	}
        this.baseColor = baseColor;
    }

    @Override
    public RGBColor getColor(ShadingInfo hit) {

        /*
         * TODO An dieser Stelle soll die Reflektion berechnet werden.
         *
         * Hierfür muss die eigene Farbe des Objekts an der Stelle des Hitpoints berechnet werden.
         * Dazu addiert werden die Reflektionsfarben der Objekte, die über die Reflektionsstrahlen getroffen werden.
         * Die gewichtete Summe der Farben wird am Ende der Methode zurückgegeben.
         *
         */

        Vector3d refl = (hit.normal).times(hit.normal.dot(hit.ray.direction)).times(-2).add(hit.ray.direction);

        // Refraktionsvektor bestimmen
        double n = 1/1.5;
        Vector3d i = hit.ray.direction.normalize();
        double cosI = hit.normal.times(-1).dot(i);
        double sinT2 = n * n * (1.0 - cosI * cosI);
        
    	if ( sinT2 > 1.0 ) {
    		return null;
    	}

        Vector3d refr = i.times(n).sub(hit.normal.times(n * cosI + Math.sqrt(1.0 - sinT2)));

    	return baseColor.times(1-reflectionCoefficient-refractionCoefficient)
                .add(hit.tracer.trace(new Ray(hit.hitPoint, refl), hit.scene, hit.depth++).times(reflectionCoefficient))
                .add(hit.tracer.trace(new Ray(hit.hitPoint.travel(refr, MathConstants.EPSILON), refr), hit.scene, hit.depth++).times(refractionCoefficient));
    }

}
