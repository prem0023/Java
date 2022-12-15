class Pair{
    int child;
    int parent;
    Pair(int child, int parent){
        this.child = child;
        this.parent = parent;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(checkCycle(adj, visited, i,-1))
                    return true;
            }
        }
        return false;
    }
    // DFS Technique
    public boolean checkCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i, int parent){
        visited[i] = true;
        
        for(int k : adj.get(i)){
            if(!visited[k]){
                if(checkCycle(adj, visited, k, i))
                    return true;
            }
            else if(k != parent)
                return true;
        }
        return false;
    }
}
 
 /*   
    // BFS Technique
    public boolean checkCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i,-1));
        visited[i] = true;
        
        while(!queue.isEmpty()){
            int child = queue.peek().child;
            int parent = queue.peek().parent;
            queue.remove();
            
            for(int k : adj.get(child)){
                if(!visited[k]){
                    visited[k] = true;
                    queue.offer(new Pair(k, child));
                }
                else if(k != parent)
                    return true;
            }
        }
        return false;
    }
}
*/
