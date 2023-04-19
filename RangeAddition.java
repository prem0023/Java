import java.util.Arrays;

public class Solution {
    public static int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] ans = new int[length];

        for(int i=0; i<updates.length; i++){
            int start = updates[i][0];
            int end = updates[i][1];
            int value = updates[i][2];

            ans[start] += value;
            if(end+1 < length)
                ans[end+1] -= value;
        }

        for(int i=1; i<length; i++){
            ans[i] += ans[i-1];
        }

        return ans;
    }

    public static void main(String[] args){
        int length = 5;
        int[][] updates = {{1,3,2},
                           {2,4,3},
                           {0,2,-2}};
        
        System.out.println(Arrays.toString(getModifiedArray(length, updates)));
    }
}
