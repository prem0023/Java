class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<V; i++){
            if(!visited[i])
                DFS(adj, stack, visited, i);
        }
        int k = 0;
        
        while(!stack.isEmpty())
            ans[k++] = stack.pop();
        return ans;
    }
    
    private static void DFS(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited, int i){
        
        visited[i] = true;
        
        for(int x : adj.get(i)){
            if(!visited[x]){
                DFS(adj, stack, visited, x);
                visited[x] = true;
            }
        }
        stack.push(i);
    }
}
