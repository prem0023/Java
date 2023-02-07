// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = arr.length;
        int c = 0;
        
        for(int i=0; i<n; i++){
            pq.offer(arr[i]);
            c++;
            if(c>k)
                pq.poll();
        }
        
        return pq.poll();
    } 
}
