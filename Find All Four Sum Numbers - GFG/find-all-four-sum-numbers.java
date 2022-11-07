//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> set = new LinkedHashSet<ArrayList<Integer>>();
        
        int first = 0, sec = 0, third = 0, fourth = 0, i=0;
        int n = arr.length;
        
        if(n < 3)
            return list;
        
        Arrays.sort(arr);
        
        for(first = 0; first<=n-4; first++){
            for(sec=first+1; sec<=n-3; sec++){
                third = sec+1;
                fourth = n-1;
                while(third < fourth && fourth < n){
                    if(arr[first] + arr[sec] + arr[third] + arr[fourth] == k){
                    	ArrayList<Integer> l = new ArrayList<Integer>();
                        l.add(arr[first]);
                        l.add(arr[sec]);
                        l.add(arr[third]);
                        l.add(arr[fourth]);
                        set.add(l);
                        i++;
                        third++;
                    }
                    else if(arr[first] + arr[sec] + arr[third] + arr[fourth] < k)
                        third++;
                    else
                        fourth--;
                }
            }
        }
        list.addAll(set);
        return list;
    }
}