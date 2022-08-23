// BFS Algorithm

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> list =  new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        
        boolean[] visited = new boolean[V];
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int a = queue.poll();
            list.add(a);
            
            for(int curr : adj.get(a)){
                if(!visited[curr]){
                    queue.add(curr);
                    visited[curr] = true;
                }
            }
        }
        return list;
    }
}