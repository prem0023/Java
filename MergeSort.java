
public class MergeSort {
	
	static void Merge(int[] arr,int l,int mid, int h) {
		int m = mid-l+1;
		int n = h-mid;
		
		int[] A = new int[m];
		int[] B = new int[n];
		
		for(int i=0;i<m;++i) {
			A[i] = arr[l+i];
		}
		for(int i=0;i<n;i++) {
			B[i] = arr[i+mid+1];
		}
		
		int i=0;int j=0;int k=l;
		
		while(i<m && j<n) {
			if(A[i] < B[j])
				arr[k++] = A[i++];
			else
				arr[k++] = B[j++];
		}
		
		while(i<m) {
			arr[k++] = A[i++];
		}
		while(j<n) {
			arr[k++] = B[j++];
		}		
		
	}
	static int[] MS(int[] a, int l, int h) {
		if(l<h) {
			int mid = (l+h)/2;
			MS(a,l,mid);
			MS(a,mid+1,h);
			Merge(a,l,mid,h);
		}
		return a;
	}

	public static void main(String[] args) {
		int[] C = {7,5,12,99,10,21,15,18,1,9,8,0,4,1,2,3,6};
		int n = C.length-1;
		int m = n/2;
		C = MS(C,0,n);
		int i=0;
		while(i<=n) {
			System.out.print(C[i++]+" ");
		}
	
	}

}
