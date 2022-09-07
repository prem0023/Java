// Smaller number on left

class Solution{
    static List<Integer> leftSmaller(int n, int arr[])
    {
        //code here
        Stack<Integer> st = new Stack<Integer>();
        //int[] ans = new int[n];
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++){
            if(st.isEmpty())
                list.add(-1);
                
            else{
                while(!st.isEmpty()){
                    if(arr[i] > st.peek()){
                        list.add(st.peek());
                        break;
                    }
                    else
                        st.pop();
                }
                if(st.isEmpty())
                    list.add(-1);
            }
            st.push(arr[i]);
            //j--;
        }
        return list;
    }
}