public class Solution {
    public double solve(double x, long n) {
        if (n == 0) {
            return 1; // power of 0 is 1
        }
        double temp = solve(x, n / 2);
        temp = temp * temp;

        if (n % 2 == 0) { // if even, return just without doing anything
            return temp;
        } else {
            return temp * x; // if odd, return by multiplying once more with the given number
        }
    }

    public double myPow(double x, int n) {
        long longN = n; // Convert n to a long to handle Integer.MIN_VALUE
        double ans = solve(x, Math.abs(longN));

        if (longN < 0) {
            return 1 / ans;
        }
        return ans;
    }
}
