// Minimum Cost of ropes

class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
         Queue<Long> q =new PriorityQueue<>();
        for(int i=0;i<n;i++){
            q.add(arr[i]);
        }
        long sum=0;
        while(q.size()>=2){
            long a=q.poll();
            long b=q.poll();
            sum+=(a+b);
            q.add(a+b);
        }
        return sum;
    }
}