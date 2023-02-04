class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for(char x: s1.toCharArray()){
            cnt[x - 'a']++;
        }

        int n1 = s1.length(), n2 = s2.length();

        for(int i = 0; i < n2 - n1 + 1; i++){
            int[] cnt2 = new int[26];
            for(int j = i; j < i + n1; j++){
                cnt2[s2.charAt(j) - 'a']++;
            }
            if(Arrays.equals(cnt, cnt2)) return true;
        }
        return false;
    }
}