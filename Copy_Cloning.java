public class Copy_Cloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		A obj = new A();
		obj.i = 5;
		obj.j = 6;
		A obj1 = (A)obj.clone(); 
		System.out.println("For obj1");
		System.out.println("i = "+ obj1.i +", j = "+ obj1.j);
		obj.j = 8;
		System.out.println("For obj");
		System.out.println("i = "+obj.i +", j = "+ obj.j);

	}

}
class A implements Cloneable
{
	int i;
	int j;
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}