class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        char[] col = new char[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(!BFS(adj, visited, i, col))
                    return false;
            }
        }
        return true;
    }
    boolean BFS(ArrayList<ArrayList<Integer>>adj, boolean[] visited, int i, char[] col){
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, 'R'));
        
        while(!queue.isEmpty()){
            i = queue.peek().i;
            char c;
            if(queue.poll().c == 'R')
                c = 'B';
            else
                c = 'R';
            
            for(int x : adj.get(i)){
                if(!visited[x]){
                    col[x] = c;
                    queue.offer(new Pair(x, c));
                    visited[x] = true;
                }
                else if(col[x] != c)
                    return false;
            }
        }
        return true;
    }
}
