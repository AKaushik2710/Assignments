package shapeAreaCalculator;

public class ShapeCalculator {
	void area(int side) {
		System.out.println("Area is "+side*side);
	}
	
	void area(int length, int breadth) {
		System.out.println("Area is "+length*breadth);
	}
	
	void area(double radius) {
		System.out.println("Area is "+3.14*radius*radius);
	}
	
	void area(double base, double height, boolean isTriangle) {
		if(isTriangle) System.out.println("Area is "+0.5*base*height);
	}
}
