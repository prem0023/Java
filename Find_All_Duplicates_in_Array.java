//Find All Duplicates in an Array

class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        
        int n = arr.length;
        List<Integer> list = new ArrayList<Integer>();
        int[] a = new int[n+1];
        
        for(int i=0;i<n;i++)
            a[arr[i]]--;

        for(int i=1; i<=n; i++){
            if(a[i] < -1)
                list.add(i);
        }
             
        return list;
        
    }
}