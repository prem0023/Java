class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i)))
               map.put(s.charAt(i), 1);
            else{
                if(max < i-l)
                    max = i-l;
                int j = l;
                char c = s.charAt(i);
                while(j < i){
                    if(s.charAt(j) == c){
                        l = j+1;
                        break;
                    }
                    int x = map.get(s.charAt(j));
                    if(x == 1)
                        map.remove(s.charAt(j));
                    else
                        map.put(s.charAt(j), map.get(s.charAt(j)-1));
                    j++;
                }
            }  
        }
        if(s.length()-l > max)
            max = s.length() - l;
        
        return max;
    }
}