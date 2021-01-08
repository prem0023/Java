import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray1 {

	public static void main(String[] args) {
		System.out.println("START");
		//System.out.println(1^6);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		ArrayList<ArrayList<Integer> > l = new ArrayList<>(); 
		for(int j=0;j<n;j++) {
			l.add(new ArrayList<Integer>());
		}
		int lastAns = 0;
		for(int i=0;i<q;i++) {
			int p = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int index = (x^lastAns) % n;
			ArrayList<Integer> seq = (ArrayList<Integer>) l.get(index);
			if(p==1) {
				seq.add(y);
			}
			else if(p==2) {
				//System.out.println(index);
				//System.out.println(seq);
				//System.out.println(seq.size());
				lastAns = (int) seq.get(y % seq.size());
				System.out.println(lastAns);
			}
			System.out.println(l);
		}
		sc.close();
	}
}