import java.io.DataInputStream;
import java.io.IOException;

public class Swayamvar {
	
	public static int calc(int N,String b, String g) {
		
		int x=0;
		int y=0;
		
		for(int i=0;i<N;i++) {
			if(g.charAt(i)=='r') {
				x++;
			}
			else {
				y++;
			}
		}
		int c = N;
		for(int i=0;i<N;i++) {
			if(b.charAt(i)=='r') {
				if(x>0) {
					x--;
					c--;
				}
				else {
					return c;
				}
			}
			else {
				if(y>0) {
					y--;
					c--;
				}
				else {
					return c;
				}
			}
		}
		return c;
	}

	public static void main(String[] args) throws IOException {
		DataInputStream dis = new DataInputStream(System.in);
		int N = Integer.parseInt(dis.readLine());
		String b = dis.readLine();
		String g = dis.readLine();
		
		System.out.println(Swayamvar.calc(N, b, g));
	}
}
