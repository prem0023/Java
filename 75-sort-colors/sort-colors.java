class Solution {
    public void sortColors(int[] nums) {
        int zero=0,two=nums.length-1;
        
        while(zero <= two){
            if(nums[zero] != 0){
                break;
            }
            zero++;
        }
        while(two >= zero){
            if(nums[two] != 2){
                break;
            }
            two--;
        }
        
        if(zero > two){
            return;
        }
        int pointer = zero;

        while(zero <= two && pointer <= two){
            if(nums[pointer] == 0){
                int temp = nums[pointer];
                nums[pointer] = nums[zero];
                nums[zero] = temp;
                zero++;
            }
            if(nums[pointer] == 2){
                int temp = nums[pointer];
                nums[pointer] = nums[two];
                nums[two] = temp;
                two--;
            }
            if(nums[pointer] == 1 || zero == pointer){
                pointer++;
            }
        }
    }
}