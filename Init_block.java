
public class Init_block {
	int x = 5;
	
	Init_block() {
		System.out.println("This is constructor");
	}
	{
		System.out.println("This initialisation block");
	}
	Init_block(int x) {
		System.out.println("This is parameterized constructor, no. is "+ x);
	}
	static
	{
		System.out.println("This is static initialisation block ");
	}
	

	public static void main(String[] args) {
		Init_block con = new Init_block();
		System.out.println("642132");
		Init_block co = new Init_block(4);

	}

}
