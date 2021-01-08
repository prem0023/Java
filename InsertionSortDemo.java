
public class InsertionSortDemo {
	
	static int min(int[] A, int k, int n) {
		int loc = k;
		int min = A[k];
		for(int i=k+1;i<n;i++) {
			if(min>A[i]) {
				min = A[i];
				loc = i;
			}
		}
		return loc;
	}

	public static void main(String[] args) {
		int[] A = {9,5,7,2,3,1,0,61, 13, 15, 26,6,4,8};
		int n = A.length;
		for(int k=0;k<n;k++) {
			int t = min(A,k,n);
			int temp = A[t];
			A[t] = A[k];
			A[k] = temp;
			System.out.print(A[k]+" ");
		}

	}

}
