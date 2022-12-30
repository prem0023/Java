//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
	int findCity(int n, int m, int[][] edges, int distanceThreshold) {
		// code here
		int[][] ans = new int[n][n];
		
		for(int i=0; i<m; i++){
		    ans[edges[i][0]][edges[i][1]] = edges[i][2];
		    ans[edges[i][1]][edges[i][0]] = edges[i][2];
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || ans[i][j] > 0)
					continue;
				ans[i][j] = (int)Math.pow(10, 9) + 7;;
			}
		}
		for (int via = 0; via < n; via++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ans[i][j] = Math.min(ans[i][j], ans[i][via] + ans[via][j]);
				}
			}
		}
// 		for (int i = 0; i < n; i++) {
// 			for (int j = 0; j < n; j++) {
// 				System.out.print(ans[i][j] + " ");
// 			}
// 			System.out.println();
// 		}

        int mincount = Integer.MAX_VALUE;
        int city = -1;
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (i != j && ans[i][j] <= distanceThreshold)
					count++;
			}
			if(mincount >= count){
			    city = i;
			    mincount = count;
			}
		}
		return city;
	}
}
