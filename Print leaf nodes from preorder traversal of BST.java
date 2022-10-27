// Print leaf nodes from preorder traversal of BST


class Solution
{
    
    public int[] leafNodes(int arr[], int N)
    {
        // code here
        if(N <= 1)
            return arr;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = getNodes(arr, 0, N-1, list);
        int[] ans = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    ArrayList<Integer> getNodes(int[] arr,int l, int r, ArrayList<Integer> list){
        if(l == r){
            list.add(arr[l]);
            return list;
        }
        
        for(int i=l+1; i<=r; i++){
            if(arr[l] < arr[i]){
                list = getNodes(arr, l+1, i-1, list);
                list = getNodes(arr, i, r, list);
                break;
            }
            else if(i == r)
                list = getNodes(arr, l+1, r, list);
        
        }
        return list;
    }
}