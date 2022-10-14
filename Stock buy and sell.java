// Stock buy and sell

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer> > ls = new ArrayList<ArrayList<Integer> >();
        boolean open = false;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 1; i<n; i++){
            if(A[i]>A[i-1]){
                if(!open){
                   temp = new ArrayList<Integer>();
                   temp.add(i-1);
                   open = true;
                }
            }else{
                if(open == true){
                    temp.add(i-1);
                    ls.add(temp);
                    open = false;
                }
            }
        }
        
        if(open == true){
            temp.add(n-1);
            ls.add(temp);
            
        }
        
      
        return ls;
        
    }
}
