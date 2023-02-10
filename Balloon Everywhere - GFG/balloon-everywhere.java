//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        int[] v=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            v[ch-'a']++;
        }
        //balloon ->0-a,1-b,11-l,14-o,13-n
        return Math.min(Math.min(v[0],v[1]),Math.min(Math.min(v[11]/2,v[14]/2),v[13]));
    }
}