
public class Circle {
	static int circlecount = 0;
	public double x,y,r;
	public Circle(double x, double y,double r) {
		this.x = x ;
		this.y = y;
		this.r = r;
		circlecount++;
	}
	public Circle(double r) {
		this(0.0,0.0,r);
		circlecount++;
	}
	public Circle(Circle c) {
		this(c.x,c.y,c.r);
		circlecount++;
	}
	public Circle() {
		this(0.0,0.0,1);
		circlecount++;
	}
	public circumference() {
		return(2*3.14159*r);
	}
	public double area() {
		return(3.14159*r*r);
	}
	

	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle(5.0);
		Circle c3 = new Circle(c1);
		System.out.println("c1# "+c1.circlecount+"\nc2# "+c2.circlecount+"\nc3# "+c3.circlecount);
	}

}
