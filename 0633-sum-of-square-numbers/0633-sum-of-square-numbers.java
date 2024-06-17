class Solution {
    public boolean judgeSquareSum(int c) {
        long l = 0, r = (long) Math.sqrt(c);
        while (l <= r) {
            if (l * l + r * r == c) return true;
            if (l * l + r * r > c) r--;
            else l++;
        }
        return false;
    }
}