class Solution {
    public int totalMoney(int n) {
        int w = n / 7;
        int money = w * 28;
        money += (7 * w * (w - 1)) / 2;

        if (n % 7 != 0) {
            int extraDays = n % 7;
            int moneyToAdd = w + 1;
            for (int i = 0; i < extraDays; ++i) {
                money += moneyToAdd;
                moneyToAdd += 1;
            }
        }

        return money;
    }
}