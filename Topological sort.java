// kahn's Algo
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        int[] topo = new int[V];
        
        for(int i=0; i<V; i++){
            for(int x : adj.get(i))
                indegree[x]++;
        }
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        int k = 0;
        while(!queue.isEmpty()){
            int i = queue.poll();
            if(indegree[i] == 0){
                topo[k++] = i;
                for(int x : adj.get(i)){
                    indegree[x]--;
                    if(indegree[x] == 0)
                        queue.offer(x);
                }
            }
        }
        return topo;
    }
}



/*
//DFS Algo
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
*/
