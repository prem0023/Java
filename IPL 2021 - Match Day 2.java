// https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Pair
{
    int num, index;
    Pair(int _num, int _index){
        this.num = _num;
        this.index = _index;
    }
}

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.num - a.num);
        int x = 0;
        
        for(int i=0; i<k; i++)
            pq.offer(new Pair(arr[i], i));
        
        ans.add(pq.peek().num);
        for(int i=k; i<n; i++){
            pq.offer(new Pair(arr[i], i));
            while(pq.peek().index <= x)
                pq.poll();
            
            ans.add(pq.peek().num);
            x++;
        }
        
        return ans;
    }
}
