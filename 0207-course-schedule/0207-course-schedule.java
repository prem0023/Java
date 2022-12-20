class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int m = prerequisites.length;
        
        for(int i =0;i<n;i++)
            graph.add(new ArrayList<>());
        
        for(int i =0;i<m;i++){
            int src = prerequisites[i][1];
            int nbr = prerequisites[i][0];
            graph.get(src).add(nbr);
        }
        
        //create a indegree array
        int [] indegree = new int[n];
        
        for(int i =0;i<n;i++){
            for(int nbr: graph.get(i)){
                indegree[nbr]++;
            }
        }
        //create a queue and put all vertices whose indegree =0
        Queue<Integer> q = new ArrayDeque<>();
        for(int i =0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //create a answer arraylist
        ArrayList<Integer> ans = new ArrayList<>();
        //remove,update and add
        while(q.size()>0){
            //remove
            int node = q.remove();
            ans.add(node);
            //update
            for(int nbr: graph.get(node)){
                indegree[nbr]--;
                //add
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }
            
        }
        if(ans.size()==n)
            return true;

        return false;
    }
}