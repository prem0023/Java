class Solution{
    int steppingNumbers(int n, int m){
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        
        if(n < 10)
            ans = 10 - n;
        
        for(int i=1; i<=9; i++)
            queue.offer(i);
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=0; i<=9; i++){
                int x = temp%10;
                if(Math.abs(x-i) == 1){
                    x = temp*10 + i;
                    if(x >= n && x <= m)
                        ans++;
                    else if(x > m)
                        return ans;
                    
                    queue.offer(x);
                }
                else if(x < i-1)
                	break;
            }
        }
        return ans;
    }
}

/*
class Solution{
    int ans;
    steppingNumbers(int n, int m){
      int   // code here
        ans = 0;
        if(n == 0)
            ans++;
        for(int i = 1; i <= 9; i++)
            find(i, i, n, m);
        return ans;
    }
    
    void find(int prev, int num, int lo, int hi){
        if(num >= lo && num <= hi)
            ans++;
        if(num > hi)
            return;
        if(prev != 0)
            find(prev - 1, num * 10 + prev - 1, lo, hi);
        if(prev != 9)
            find(prev + 1, num * 10 + prev + 1, lo, hi);
    }
}
*/
