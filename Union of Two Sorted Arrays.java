// Union of Two Sorted Arrays

class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> list= new ArrayList<>();
        TreeSet<Integer> treeset= new TreeSet<>();
        
        for(int i=0; i<n; i++){
            treeset.add(arr1[i]);
        }
        for(int i=0; i<m; i++){
            treeset.add(arr2[i]);
        }
        for(Integer elem : treeset) list.add(elem);
        return list;
    }
}