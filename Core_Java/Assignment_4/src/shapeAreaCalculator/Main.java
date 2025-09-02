package shapeAreaCalculator;

public class Main {

	public static void main(String[] args) {
		ShapeCalculator sc = new ShapeCalculator();
		sc.area(4);
		sc.area(2,4);
		sc.area(7.00);
		sc.area(3, 10, false);
		sc.area(4, 12, true);
	}

}
