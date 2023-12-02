class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int i=0; i<chars.length(); i++){
            int count = map.getOrDefault(chars.charAt(i), 0);
            map.put(chars.charAt(i), count+1);
        }
        
        for(int i=0; i<words.length; i++){
            HashMap<Character, Integer> temp = new HashMap<>();
            
            for(int j=0; j<words[i].length(); j++){
                int count = temp.getOrDefault(words[i].charAt(j), 0);
                temp.put(words[i].charAt(j), count+1);
            }
            
            
            boolean flag = true;
            for(Map.Entry<Character, Integer> entry : temp.entrySet()){
                int key = entry.getKey();
                int count = entry.getValue();
                
                if(map.getOrDefault((char)key, 0) < count){
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans += words[i].length();
        }
        
        return ans;
    }
}