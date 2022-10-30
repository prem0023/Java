// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        int n = arr.length;
        if (n <= 1)
            return 0;
 
        if (arr[0] == 0)
            return -1;
 
        int jump = 0;
        int currstep = 0;
        int maxreach = 0;
        int currreach = 0;
        
        while(currstep <= maxreach && currstep < n){
            if(currstep == n-1)
                return jump;
                
            if(currstep + arr[currstep] > maxreach)
                maxreach = currstep + arr[currstep];
            
            if(currstep == currreach){
                currreach = maxreach;
                jump++;
            }
            currstep++;
        }
        // if(maxreach >= n-1)
        //     return jump;
        
        return -1;
    }
}