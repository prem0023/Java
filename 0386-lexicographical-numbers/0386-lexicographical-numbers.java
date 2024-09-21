class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = 1;
        
        while(num <= n && ans.size() < n){
            ans.add(num);
            int temp = num*10;
            // System.out.println("num: " + num + " temp: " + temp);
            
            if(temp <= n){
                num = temp;
                continue;
            }
            
            temp = num + 1;
            while(temp % 10 == 0)
                    temp = temp/10;
            
            while(temp > n){
                temp++;
                while(temp % 10 == 0)
                    temp = temp/10;
            }
            num = temp;
        }
        return ans;
    }
}