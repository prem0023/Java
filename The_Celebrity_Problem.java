//  The Celebrity Problem

// Method 1
class Solution
{
    
    int celebrity(int matrix[][], int n)
    {
    	int[] arr = new int[n];
    	
    	for(int i=0; i<n; i++){
    	    for(int j=0; j<n; j++){
    	        if(matrix[i][j] == 1){
    	            if(arr[j] == 0)
    	                arr[j] = 1;
    	            arr[i] = -1;
    	        }
    	    }
    	}
    	
    	int c = -1;
    	for(int i=0; i<n; i++){
    	    if(arr[i] == 1)
    	        c = i;
    	    else if(arr[i] == 0)
    	        return -1;
    	}
    	if(c >= 0)
    	    return c;
    	return -1;
    }
}

/*
// Method 2

class Solution
{
    
    int celebrity(int matrix[][], int n)
    {
    	//int[] arr = new int[n];
    	int k = -1, m =0;
    	
    	for(int j=0; j<n; j++){
    	    if(matrix[0][j] == 1 || matrix[1][j] == 1){
    	        int c = 0, i = 0;
    	        while(i<n){
    	            if(matrix[i][j] == 1)
    	                c++;
    	            i++;
    	        }
    	        if(c == n-1){
    	            if(m == 1)
    	                return -1;
    	            k = j;
    	            m = 1;
    	        }
    	    }
    	}
    	if(k == -1)
    	    return -1;
    	    
    	for(int j=0; j<n; j++){
    	    if(matrix[k][j] != 0)
    	        return -1;
    	}
    	return k;
    }
}
*/