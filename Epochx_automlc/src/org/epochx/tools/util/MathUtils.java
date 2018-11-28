package org.epochx.tools.util;



public final class MathUtils {

	private MathUtils() {}
	

	public static double arccsc(double d) {
		return Math.asin(1.0/d);
	}
	

	public static double arccot(double d) {
		return Math.atan(1.0/d);
	}
	

	public static double arcsec(double d) {
		return Math.acos(1.0/d);
	}
	

	public static double csc(double d) {
		return 1.0 / Math.sin(d);
	}
	

	public static double sec(double d) {
		return 1.0 / Math.cos(d);
	}
	

	public static double cot(double d) {
		return 1 / Math.tan(d);
	}
	

	public static double arcosh(double d) {
		return Math.log(d + Math.sqrt(d*d - 1.0));
	}
	

	public static double arsinh(double d) {
		return Double.isInfinite(d) ? d : (d == 0.0) ? d : Math.log(d+Math.sqrt(d*d+1.0)); 
	}
	

	public static double artanh(double d) {
		return (d != 0.0) ? (Math.log(1.0 + d) - Math.log(1.0 - d))/2.0 : d; 
	}
	

	public static double sech(double d) {
		return 1.0/Math.cosh(d);
	}
	

	public static double csch(double x) {
		return 1.0/Math.sinh(x);
	}
	

	public static double coth(double x) {
		return 1.0/Math.tanh(x);
	}
}
