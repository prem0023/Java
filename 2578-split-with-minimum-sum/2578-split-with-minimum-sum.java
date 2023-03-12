class Solution {
    public int splitNum(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = num;
        
        while(n > 0){
            int r = n%10;
            list.add(r);
            n = n/10;
        }
        
        Collections.sort(list);
        int num1 = 0, num2 = 0;
        boolean flag = true;
        
        for(int x : list){
            if(flag){
                num1 = num1*10 + x;
                flag = false;
            }
            else{
                num2 = num2*10 + x;
                flag = true;
            }
        }
        // System.out.println("num1 : " + num1 + " num2 : " + num2);
        return num1 + num2;
    }
}