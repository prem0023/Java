
public class BubbleSortDemo {
	
	static void BubbleS(int[] list, int n) {
		int c;
		for(int i=1;i<n;i++) {
			c=0;
			for(int j=0;j<n-i;j++) {
				if(list[j]>list[j+1]) {
					int temp= list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					c++;
				}
			}
			//System.out.println(i);
			if(c == 0)
				return;
			
		}
	}

	public static void main(String[] args) {
		int[] list = {1,2,3,4,5,6,77,8,9};
		BubbleS(list,9);
		int i=0;
		while(i<9) {
			System.out.print(list[i]+" ");
			i++;
		}

	}

}
