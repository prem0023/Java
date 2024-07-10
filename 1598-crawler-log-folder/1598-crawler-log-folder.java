class Solution {
    public int minOperations(String[] logs) {
        int step = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (step > 0) step--;
            } else if (!log.equals("./")) {
                step++;
            }
        }
        return step;
        
    }
}