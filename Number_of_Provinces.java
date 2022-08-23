// Number of Provinces

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
//Method - 2
class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        boolean[] visited = new boolean[isConnected.length+1];
        int count = 0;
        
        for(int i=1; i<=isConnected.length; i++){
            if(!visited[i]){
                count++;
                BFS(i, isConnected, visited);
            }
        }
        return count;
    }
    
    void BFS(int curr, int[][] isConnected, boolean[] visited){
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(curr);
        visited[curr] = true;
        
        while(!queue.isEmpty()){
            int i = queue.poll();
            for(int j=1; j<=isConnected.length; j++){
                if(i != j && isConnected[i-1][j-1] == 1 && !visited[j]){
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}


//Method - 3
class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        boolean[] visited = new boolean[isConnected.length+1];
        
        for(int j=0; j<=isConnected.length; j++){
                adj.add(new ArrayList<Integer>());
        }
        
        for(int i=1; i<=isConnected.length; i++){
            for(int j=i+1; j<=isConnected.length; j++){
                if(isConnected[i-1][j-1] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        
        for(int i=1; i<=isConnected.length; i++){
            if(!visited[i]){
                count++;
                DFS(i, adj, visited);
            }
        }
        return count;
    }
    
    void DFS(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        
        visited[curr] = true;
        
        for(int x : adj.get(curr)){
            if(!visited[x])
                DFS(x, adj, visited);
        }
    }
}
*/