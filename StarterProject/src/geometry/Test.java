package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point point1 = new Point();
		//point1.x = 2; ne moze, specifikator pristupa private
		//point1.y = 3;
		point1.setX(2);
		point1.setY(3);
		point1.setSelected(false);
		
		System.out.println("x="+ point1.getX());
		System.out.println("y="+ point1.getY());
		System.out.println("Selected="+ point1.isSelected());
		//
		double result=point1.distance(6, 7);
		System.out.println(result);
		
	}

}
