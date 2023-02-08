class Solution
{
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        int max = 0, letter = 0;
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        } 
        
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return ""; 
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}


/*
Method - 2
class Pair
{
    char ch;
    int freq;
    Pair(char _ch, int _freq){
        this.ch = _ch;
        this.freq = _freq;
    }
}

class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        int n = s.length();
        String ans = "";
        
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq+1);
            if(freq == (n+1)/2)
                return "";
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            
            pq.offer(new Pair(ch, freq));
        }
        
        char ch1 = Character.MIN_VALUE;
        int freq1 = 0;
        char ch2 = Character.MIN_VALUE;
        int freq2 = 0;
        
        while(!pq.isEmpty()){
            ch1 = pq.peek().ch;
            freq1 = pq.poll().freq;
            if(!pq.isEmpty()){
                ch2 = pq.peek().ch;
                freq2 = pq.poll().freq;
            }
            if(freq1 != 0){
                ans = ans + "" + ch1;
                freq1--;
            }
            if(freq2 != 0){
                ans = ans + "" + ch2;
                freq2--;
            }
            
            if(freq1 != 0)
                pq.offer(new Pair(ch1, freq1));
            if(freq2 != 0)
                pq.offer(new Pair(ch2, freq2));
        }
        return ans;
    }
}
// https://stackoverflow.com/questions/8534178/how-to-represent-empty-char-in-java-c haracter-class

*/