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
		
		//vezbe 3  - 13.3
		Point  p2 = new Point();
		Line l1 = new Line();
		Rectangle r1 = new Rectangle();
		Circle c1 = new Circle();
		p2.setX(10);
		p2.setY(15);
		//1. inicijalizacija x point1 na vrednost y p2
		point1.setX(p2.getY());
		System.out.println("X koordinata tacke point1 : " + point1.getX());
		//2.
		l1.setStartPoint(point1);
		l1.setEndPoint(p2);
		System.out.println("Start point X: " + l1.getStartPoint().getX());
		System.out.println("Start point Y: " + l1.getStartPoint().getY());
		System.out.println("End point X: " + l1.getEndPoint().getX());
		System.out.println("End point Y: " + l1.getEndPoint().getY());
		//3.
		l1.getEndPoint().setY(23);
		System.out.println("End point Y: " + l1.getEndPoint().getY());
		
		//4.
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		System.out.println("Start point X: " + l1.getStartPoint().getX());
		
		//5.
		l1.getEndPoint().setX((int)l1.length()-(l1.getStartPoint().getX() + l1.getStartPoint().getY()));
		System.out.println("Start point X: " + l1.getEndPoint().getX());
		
		//6.
		r1.setUpperLeftPoint(new Point());
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println("Start rectangle point X: " + r1.getUpperLeftPoint().getX());
		System.out.println("Start rectangle point Y: " + r1.getUpperLeftPoint().getY());
		// p i o od r1
		r1.setWidth(20);
		r1.setHeight(10);
		System.out.println("Povrsina r1:"+r1.area());
		System.out.println("Obim r1:"+r1.circumference());
		
		//7 centar c1 na koordinate od r1 tacke gore levo
		c1.setCenter(r1.getUpperLeftPoint());
		System.out.println("Centar kruga c1: "+ "("+ c1.getCenter().getX() + "," + c1.getCenter().getY() + ")");
		
		//8.
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println("Centar kruga c1: "+ "("+ c1.getCenter().getX() + "," + c1.getCenter().getY() + ")");
		
		
		//vezbe 4
		System.out.println(point1);
		System.out.println(l1);
		System.out.println(c1);
		System.out.println(r1);
		
		int a = 5;
		int b = 5;
		System.out.println(a==b); // poredjenje po vrednosti 
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1 == s2); // poredjenje po referenci , da li dve memorijske varijable ukazuju na istu mem lokaciju
		System.out.println(s1.equals(s2)); // poredjenje po vrednosti
		
		
		Point p3 = new Point(23,3);
		System.out.println(point1 == p3);
		System.out.println(point1.equals(p3));
		
		
		
	}

}
