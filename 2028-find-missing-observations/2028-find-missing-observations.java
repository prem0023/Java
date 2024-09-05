class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int totalSum = (rolls.length + n) * mean;
        int sum = 0;
        
        Random random = new Random();
        
        for(int x : rolls){
            sum += x;
        }
        
        if(sum + n*6 < totalSum || sum + n > totalSum)
            return new int[0];
        
        int[] missingRolls = new int[n];
        int remainingSum = totalSum-sum; // 21 - 12 = 9
        // System.out.println("remainingSum: " + remainingSum);
        
        for(int i=n; i>0; i--){
            int num = random.nextInt(6) + 1;
            // System.out.println("num: " + num);
            
            if((i-1)*6 >= remainingSum-num && (remainingSum-num) >= i-1 ){
                missingRolls[i-1] = num;
                remainingSum -= num;
            }
            else{
                for(int x=1; x<=6; x++){
                    if((remainingSum-x) <= (i-1)*6){
                        missingRolls[i-1] = x;
                        remainingSum -= x;
                        break;
                    }
                }
            }
                
        }
        return missingRolls;
    }
}