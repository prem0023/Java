class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(1,n,0,k,ans,subset);
        return ans;
    }
    void helper(int start, int n, int size,int k,List<List<Integer>> ans, List<Integer> subset)
    {
        if(start>n){
            if(size==k){
                ans.add(new ArrayList(subset));
            }
            return;
        }
        
        //include
        subset.add(start);
        helper(start+1,n,size+1,k,ans,subset);
        
        //exclude
        subset.remove(subset.size()-1);
        helper(start+1,n,size,k,ans,subset);
    }
}