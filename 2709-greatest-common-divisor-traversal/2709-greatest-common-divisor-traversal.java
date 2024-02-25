class Solution {
    public void dfs(ArrayList<ArrayList<Integer>>adj,int []vis,int st){
        vis[st]=1;
        for(int i:adj.get(st)){
            if(vis[i]==0){
                dfs(adj,vis,i);
            }
        }
    }
public static void allprime(int n,HashMap<Integer,ArrayList<Integer>>map,int st){
        if(n%2==0){
            if(!map.containsKey(2))map.put(2,new ArrayList<>());
            ArrayList<Integer>temp=map.get(2);
            temp.add(st);
            map.put(2,temp);
        }
        while(n%2==0){
            n/=2;
        }
        for(int i=3; i<=Math.sqrt(n); i+=2){
            if(n%i==0){
                if(!map.containsKey(i))map.put(i,new ArrayList<>());
                ArrayList<Integer>temp=map.get(i);
                temp.add(st);
                map.put(i,temp);
            }
            while(n%i==0){
                n/=i;
            }
        }
        if(n>2){
            if(!map.containsKey(n))map.put(n,new ArrayList<>());
            ArrayList<Integer>temp=map.get(n);
            temp.add(st);
            map.put(n,temp);
        }
    }
    public boolean canTraverseAllPairs(int[] nums) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        
        int n=nums.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }    
        for(int i=0;i<n;i++){
            allprime(nums[i],map,i);
        }
        
        for(ArrayList<Integer>temp:map.values()){
            for(int i=1;i<temp.size();i++){
                adj.get(temp.get(i-1)).add(temp.get(i));
                adj.get(temp.get(i)).add(temp.get(i-1));
            }
        }
        int []vis=new int[n];
        dfs(adj,vis,0);
        for(int i=0;i<n;i++){
            if(vis[i]==0)return false;
        }
        return true;
    }
}