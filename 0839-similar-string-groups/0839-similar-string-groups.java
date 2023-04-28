class Solution {
    public int numSimilarGroups(String[] strs) {
        Set<String> s1=new HashSet<>();
        //taking the unique strings
        for(String u:strs)s1.add(u);
        List<String> l=new ArrayList<>();
        for(String u:s1)l.add(u);
        
        int n=l.size();
        
        int parent[]=new int[n];
        int rank[]=new int[n];
        //numbering each unique string for applying dsu
        Map<String,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++){
            parent[i]=i;
            m.put(l.get(i),i);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(issame(l.get(i),l.get(j))){
                    int u=m.get(l.get(i));
                    int v=m.get(l.get(j));
                    u=findPar(u,parent);
                    v=findPar(v,parent);
                    union(u,v,rank,parent);
                }
            }
        }
        //finding no of connected components
        int res=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i)res++;
        }
        return res;
    }
    public int findPar(int node,int parent[]){
        if(node==parent[node])return node;
        return parent[node]=findPar(parent[node],parent);
    }
    public void union(int u,int v,int rank[],int parent[]){
        if(rank[u]<rank[v]){
            parent[u]=v;
        }
        else if(rank[v]<rank[u]){
            parent[v]=u;
        }
        else{
            rank[u]++;
            parent[u]=v;
        }
    }
    public boolean issame(String a,String b){
        int n=a.length();int c=0;
        for(int i=0;i<n;i++){
            if(a.charAt(i)!=b.charAt(i)){
                c++;
                if(c>2)return false;
            }
        }
        return c==0 || c==2;
    }
}