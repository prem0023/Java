class Solution {
    public String addStrings(String num1, String num2) {
        String big = num1.length() >= num2.length() ? num1 : num2;
        String small = num1.length() < num2.length() ? num1 : num2;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < big.length(); i++) {
            int b = big.charAt(big.length() - i - 1) - '0';
            int s = i < small.length() ? (small.charAt(small.length() - i - 1) - '0') : 0;
            sum += b + s;
            sb.append(sum % 10);
            sum /= 10;
        }
        if (sum > 0) sb.append(sum);
        return sb.reverse().toString();
    }
}