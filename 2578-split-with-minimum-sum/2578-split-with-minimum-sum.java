class Solution {
    public int splitNum(int num) {
        int n = 0;
        int or = num;
        while(num > 0){
            n++;
            num = num / 10;
        }
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = or % 10;
            or = or / 10;
        }

        Arrays.sort(a);

        int num1 = 0, num2 = 0;
        for(int i = 0; i < n - 1; i+=2){
            num1 = num1 * 10 + a[i];
            num2 = num2 * 10 + a[i + 1];
        }
        if(n % 2 != 0){
            num1 = num1 * 10 + a[n-1];
        }

        return num1 + num2;


        
    }
}

/*
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
        return num1 + num2;
    }
}
*/