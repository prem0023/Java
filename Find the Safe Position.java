// Find the Safe Position

class Solution {
    static int safePos(int n, int k) {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++)
            list.add(i);
        return getNumber(list, n, k-1, 0);
    }
    static int getNumber(ArrayList<Integer> list, int n, int k, int i){
        if(list.size() == 1)
            return list.get(0);
            
        list.remove((k+i)%n);
        
        int x = getNumber(list, n-1, k,(k+i)%n);
        
        return x;
        
    }
}