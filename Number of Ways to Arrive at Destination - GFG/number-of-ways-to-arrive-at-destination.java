//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair
{
    int src,cost;
    Pair(int src, int cost){
        this.src = src;
        this.cost = cost;
    }
}

class Solution {

        static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.cost-y.cost);
        int m = roads.size();
        int ans = 0, mincost = Integer.MAX_VALUE;
        int[] price = new int[n];
        
        for(int i=0; i<n; i++){
            price[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0),roads.get(i).get(2)));
        }
        pq.offer(new Pair(0, 0));
        price[0] = 0;
        
        while(!pq.isEmpty()){
            int src = pq.peek().src;
            int cost = pq.poll().cost;
        
            for(Pair p : adj.get(src)){
                if(p.cost + cost <= price[p.src]){
                   
                    if(p.src == n-1){
                        if(mincost > p.cost+cost){
                            ans = 1;
                            mincost = p.cost+cost;
                        }
                        else if(mincost == p.cost+cost){
                            ans++;
                        }
                        //System.out.println(p.cost+cost);
                        continue;
                    }
                    
                    price[p.src] = p.cost +cost;
                    pq.offer(new Pair(p.src, p.cost+cost));
                }
            }
        }
        
        return ans;
    }
}
