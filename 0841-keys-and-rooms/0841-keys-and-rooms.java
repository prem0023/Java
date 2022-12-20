class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> edges) {
         int n = edges.size();
         boolean[] visited = new boolean[n];
         Queue<Integer> queue = new LinkedList<>();
         queue.add(0);
         visited[0]=true;
         while(!queue.isEmpty()) {
             int size = queue.size();
             while(size-->0) {
                 int v=queue.poll();
                 for(int edge:edges.get(v)) {
                     if(!visited[edge]) {
                        visited[edge]=true;
                        queue.add(edge);
                     }
                 }
             }
         }
         //check if any vertex not visited
         while(--n>0) {
             if(!visited[n])
                return false;
         }
         return true;
    }

    
}