// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.num - b.num);
        
        for(int i=0; i<k; i++)
            pq.offer(new Tuple(arr[i][0], i, 0));
        
        while(!pq.isEmpty()){
            int num = pq.peek().num;
            int x = pq.peek().x;
            int y = pq.poll().y;
            
            ans.add(num);
            if(y+1 < k)
                pq.offer(new Tuple(arr[x][y+1], x, y+1));
        }
        
        return ans;
    }
}
