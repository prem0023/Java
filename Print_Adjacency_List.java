//Print adjacency list

class Solution {
    // Function to return the adjacency list for each vertex.
    public ArrayList<ArrayList<Integer>> printGraph(
        int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<V; i++){
            list.add(new ArrayList<Integer>());
        }
        boolean[] visited = new boolean[V];
        
        for(int i=0; i<V; i++){
                list.get(i).add(i);
            for(int j : adj.get(i)){
                if(!list.get(i).contains(j))
                    list.get(i).add(j);
            }
        }
        
        return list;
    }
}
