class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        String[][] store = new String[len][len];
        for(int i = 0 ; i < len; i++){
            for(int j = i; j < len ; j++){
                if(checkPalindrome(s, i, j)){
                    store[i][j] = s.substring(i, j+1);
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        dfs(result, store, 0, new ArrayList<>());
        return result;
    }
    
    public void dfs( List<List<String>> result,  String[][] store, int pos, List<String> array){
        if(pos >= store.length){
            result.add(array);
        }
        
        if(pos == store.length-1){
            array.add(store[pos][pos]);
            result.add(array);
            return;
        }
        
        for(int i = pos; i < store.length; i++){
            if(store[pos][i] != null){
                List<String> temp = new ArrayList<>(array);
                temp.add(store[pos][i]);
                dfs(result, store, i+1, temp);
            }
        }
        return;
    }
    
    
    
    public boolean checkPalindrome(String s, int start, int end){
        
        for(int i = start, j = end; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
}