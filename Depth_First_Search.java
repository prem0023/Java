// Depth First Search

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> list =  new ArrayList<Integer>();
        boolean[] visited = new boolean[V];
        
        DFS(0, adj, visited, list);
        
        return list;
    }
    
    void DFS(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list){
        
        if(visited[curr])  //optional
            return;
        
        visited[curr] = true;
        list.add(curr);
        
        for(int x : adj.get(curr)){
            if(!visited[x]){
                DFS(x, adj, visited, list);
            }
        }
    }
}