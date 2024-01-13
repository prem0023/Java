class Solution {
    public int minSteps(String s, String t) {
        int[] charFreq = new int[26];

        for(char cur: s.toCharArray()) {
            charFreq[cur-'a']++;
        }

        for(char cur: t.toCharArray()) {
            charFreq[cur-'a']--;
        }

        int minSteps = 0;

        for(int idx=0; idx < 26; idx++) {
            if (charFreq[idx] != 0) {
                minSteps += Math.abs(charFreq[idx]);
            }
        }

        return minSteps;
    }
}