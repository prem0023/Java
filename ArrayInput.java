import java.util.*;
public class ArrayInput {
	public static void main(String args[]) {
		int sum=0;
		float avg=0;
		//int x[];
		ArrayList <Integer> x = new ArrayList<Integer>();
		System.out.println("Enter the list");
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()) {
			x.add(s.nextInt());
		}
		System.out.println("");
		for(int i=0;i<x.size();i++) {
			sum = sum+x.get(i);
		}
		System.out.println("Sum of number is "+sum);
		System.out.print("Average of number is "+sum/(x.size()));
		
	}

}
//for terminate press ctrl+z5
