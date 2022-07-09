// Sort Array using Recursion

//Method 1

class Solution {
	static void sortArray(int[] a, int i,int n) {
		if(i == n-1)
			return;
		
		sortArray(a,i+1,n);
		int c = a[i];
		insertElement(a,i+1,n, c);
	}
	static void insertElement(int[] a, int i, int n, int c) {
		if(i == n || c<= a[i]) {
			a[i-1] = c;
			return;
		}
		int x = a[i];
		insertElement(a,i+1,n,c);
		a[i-1] = x;
		return;
		
	}
    
    
    public static void main(String[] args) {
    	int[] a = {1,6,3,5,9,7,8,4,2,5};
    	sortArray(a,0,a.length);
    	System.out.println(Arrays.toString(a));
    }
}


/*
// Method 2
class Solution {
	static void sortArray(int[] a, int i,int n) {
		if(i == n-1)
			return;
		
		sortArray(a,i+1,n);
		int c = a[i];
		insertElement(a,i,n, c);
	}
	static int insertElement(int[] a, int i, int n, int c) {
		if(a[i]> c)
			return i-1;
		else if(i == n-1)
			return i;
		a[i] = a[i+1];	
		int x = insertElement(a,i+1,n,c);
		a[x] = c;
		
		return x;
	}
    
    
    public static void main(String[] args) {
    	int[] a = {1,6,3,5,9,7,8,4,2,5};
    	sortArray(a,0,a.length);
    	System.out.println(Arrays.toString(a));
    }
}
*/

/*
// Method 3
class Solution {
	static void sortArray(int[] a, int i,int n) {
		if(i == n-1)
			return;
		
		sortArray(a,i+1,n);
		int c = a[i];
		insertElement(a,i+1,n, c);
	}
	static void insertElement(int[] a, int i, int n, int c) {
		if(i == n) {
			a[i-1] = c;
			return;
		}
		else if(a[i]>=c) {
			a[i-1] = c;
			return;
		}
		else {
			a[i-1] = a[i];
			insertElement(a,i+1,n,c);
		}
		return;
	}
    
    
    public static void main(String[] args) {
    	int[] a = {1,6,3,5,9,7,8,4,2,5};
    	sortArray(a,0,a.length);
    	System.out.println(Arrays.toString(a));
    }
}
*/

/*

// Method 4
class Solution {
	static void sortArray(int[] a, int i,int n) {
		if(i == n)
			return;
		
		sortArray(a,i+1,n);
		
		int j = i+1;
		int c = a[i];
		while(j<n) {
			if(c>a[j])
				a[j-1] = a[j];
			else
				break;
			j++;
		}
		a[j-1] = c;
		
	}
    
    
    public static void main(String[] args) {
    	int[] a = {1,6,3,5,9,7,8,4,2,5};
    	sortArray(a,0,a.length);
    	System.out.println(Arrays.toString(a));
    }
}
*/