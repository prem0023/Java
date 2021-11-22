import java.util.*;

class Minimum_Jump
{
	static int minJumps(int[] arr){
        int n = arr.length;
        if (n <= 1)
            return 0;
 
        if (arr[0] == 0)
            return -1;
 
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
 
        
        for (int i = 1; i < n; i++) {
            
            if (i == arr.length - 1)
                return jump;
 
            maxReach = Math.max(maxReach, i + arr[i]);
 
            step--;
 
            if (step == 0) {
                
                jump++;
 
                if (i >= maxReach)
                    return -1;
                    
                step = maxReach - i;
            }
        }
 
        return -1;
    }
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] arr = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};
		System.out.println(minJumps(arr));
		//System.out.println(Arrays.toString(arr));
		sc.close();
	}
}


/**
static int minJumps(int[] arr){
		int n  = arr.length;
        int c = 0;
        int i=0;
        while(i < n-1) {
        	c++;
        	if(i+arr[i]>=n-1) {
        		return c;
        	}
        	int k = i+arr[i];
        	int x=i;
        	for(int j=i;j<=i+arr[i];j++) {
        		if(k<i+arr[j] || j+arr[j] >= n-1) {
        			if(j+arr[j]>=n-1){
        				c++;
        			    return c;
        			}
        			else if(arr[i+arr[j]] != 0){
        			    k = i+arr[j];
        			    x =j;
        			}
        		}
        	}
        	if(arr[x] == 0) {
        		return -1;
        	}
        	i = i==x? i+arr[i] : x;
        	//System.out.println(i);
        }
        return c;
	}
	**/
