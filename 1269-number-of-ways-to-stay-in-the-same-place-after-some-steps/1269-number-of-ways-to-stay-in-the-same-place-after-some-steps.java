class Solution {
    public int numWays(int steps, int arrLen) {
        if (arrLen == 1) {
            return 1;
        }
        
        arrLen = Math.min(steps / 2 + 1, arrLen);
        long modulo = 1_000_000_007;

        long[] current = new long[arrLen];
        current[0] = 1;
        current[1] = 1;
        long[] next = new long[arrLen];

        for (int i = 2; i <= steps; i++) {
            int maxPos = Math.min(i + 1, arrLen);
            next[0] = (current[0] + current[1]) % modulo;
            for (int j = 1; j < maxPos - 1; j++) {
                next[j] = (current[j - 1] + current[j] + current[j + 1]) % modulo;
            }
            next[maxPos - 1] = (current[maxPos - 2] + current[maxPos - 1]) % modulo;

            long[] temp = current;
            current = next;
            next = temp;
        }

        return (int) current[0];
    }
}