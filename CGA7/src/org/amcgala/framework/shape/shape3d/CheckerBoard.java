package org.amcgala.framework.shape.shape3d;

import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.raytracer.RGBColor;
import org.amcgala.framework.raytracer.Ray;
import org.amcgala.framework.raytracer.ShadingInfo;
import org.amcgala.framework.shape.AbstractShape;

public class CheckerBoard extends AbstractShape {
	private RGBColor whiteColor;
	private RGBColor blackColor;
	private Vector3d origin;
	private Vector3d dir1;
	private Vector3d dir2;
	private int size;
	
	public CheckerBoard(Vector3d origin, Vector3d dir1, Vector3d dir2, int size,RGBColor white, RGBColor black) {
		this.origin = origin;
		this.dir1 = dir1;
		this.dir2 = dir2;
		this.size = size;
		this.whiteColor = white;
		this.blackColor = black;
	}
	
	@Override
	public boolean hit(Ray ray, ShadingInfo shadingInfo) {
		shadingInfo.ray = ray;
		shadingInfo.label = getLabel();
		
		Vector3d normal = dir1.cross(dir2);
		double nenner = normal.dot(ray.direction);
		
		if (nenner != 0) {
			double t = (-normal.dot(ray.origin) + normal.dot(origin)) / nenner;
			
			if (t > 0) {
				shadingInfo.t = t;
				shadingInfo.hitPoint = ray.origin.travel(ray.direction, shadingInfo.t);
				shadingInfo.normal = normal;
				
				int max = size/2;
				
				if (shadingInfo.hitPoint.x > 0) {
					if (shadingInfo.hitPoint.x % size < max) {
						if (Math.abs(shadingInfo.hitPoint.z) % size < max) {
							shadingInfo.color = whiteColor;
						} else {
							shadingInfo.color = blackColor;
						}
					} else {
						if (Math.abs(shadingInfo.hitPoint.z) % size < max) {
							shadingInfo.color = blackColor;
						} else {
							shadingInfo.color = whiteColor;
						}
					}
				} else {
					if (Math.abs(shadingInfo.hitPoint.x) % size < max) {
						if (Math.abs(shadingInfo.hitPoint.z) % size < max) {
							shadingInfo.color = blackColor;
						} else {
							shadingInfo.color = whiteColor;
						}
					} else {
						if (Math.abs(shadingInfo.hitPoint.z) % size < max) {
							shadingInfo.color = whiteColor;
						} else {
							shadingInfo.color = blackColor;
						}
					}
				}
				return true;
			}
		}
	
		return false;
	}

}