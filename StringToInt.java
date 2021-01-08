public class StringToInt {

	public static void main(String[] args) {
		String n = "10";
		Integer x = Integer.parseInt(n);
		System.out.println(x);
		int z = Integer.valueOf(n);
		System.out.println(z);
		
		String m = "10.15";
		double y = Double.parseDouble(m);
		System.out.println(y);
		double k = Double.valueOf(m);
		System.out.println(k);

	}

}
