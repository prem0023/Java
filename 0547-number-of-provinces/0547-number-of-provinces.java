class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        boolean[] visited = new boolean[isConnected.length+1];
        int count = 0;
        
        for(int i=1; i<=isConnected.length; i++){
            if(!visited[i]){
                count++;
                DFS(i, isConnected, visited);
            }
        }
        return count;
    }
    
    void DFS(int curr, int[][] isConnected, boolean[] visited){
        
        if(visited[curr])
            return;
        
        visited[curr] = true;
        
        for(int i=1; i<=isConnected.length; i++){
            if(!visited[i] && isConnected[curr-1][i-1] == 1)
                DFS(i, isConnected, visited);
        }
    }
}

/*
class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<n; i++)
			adj.add(new ArrayList<>());
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int ans = 0;
        DisjointSet dj = new DisjointSet(n);
        
        for(int i=0; i<n; i++){
            for(int x : adj.get(i)){
                if(dj.findUPar(x) != dj.findUPar(i)){
                    dj.unionBySize(x, i);
                }
            }
        }
        for(int i=0; i<n; i++){
            if(dj.findUPar(i) == i)
                ans++;
        }
        
        return ans;
    }
}

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

*/