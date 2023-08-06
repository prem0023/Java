//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        
        ArrayList<String> ans = helper(S, S.length(), 0);
        Collections.sort(ans);
        
        return ans;
    }
    
    private ArrayList<String> helper(String s, int n, int i){
        if(i == n-1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(Character.toString(s.charAt(n-1)));
            return ans;
        }
        
        ArrayList<String> temp = helper(s, n, i+1);
        ArrayList<String> ans = new ArrayList<>();
        char c = s.charAt(i);
        
        for(String x : temp){
            for(int j=0; j<n-i; j++){
                String s1 =  x.substring(0,j) + c + x.substring(j,n-i-1);
                ans.add(s1);
            }
        }
        
        return ans;
    }
}
