public class Solution {
    public int maxDepth(String s) {
        int count = 0, max = 0;
        for(char c : s.toCharArray()) {
            if (c == '(')
                count++;
            max = Math.max(count, max);
            if (c == ')')
                count--;
        }
        return max;
    }
}