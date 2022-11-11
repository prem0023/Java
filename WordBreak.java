
class Solution {
    private List<String> wordDict;
    boolean[] visited;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict=wordDict;
        visited=new boolean[s.length()+1];
        return findWord(s,0);
    }
    
    private boolean findWord(String s,int i){
        if(i==s.length())
            return true;
        boolean ans=false;
        visited[i]=true;
        for(int k=0;k<wordDict.size();k++){     
            if(s.startsWith(wordDict.get(k),i)){
                if(!visited[i+wordDict.get(k).length()] && findWord(s,i+wordDict.get(k).length()))
                    return true;
            }
        }
        return false;
    }
}

/*
//Now just add a bit of code to make it N^2 time complexicty
class Solution {
    // use memoization: at what substring which could lead to a correct answer
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Map<String, Boolean> map = new HashMap<>(); // memoization
        return dfs(s, words, map);
    }
    
    private boolean dfs(String s, Set<String> words, Map<String, Boolean> map){
        if(map.containsKey(s)) 
            return map.get(s);
        int len = s.length();
        if(len == 0) return true;
        
        for(int i = 1; i <= len; i++){
            if(words.contains(s.substring(0, i)) && dfs(s.substring(i), words, map)){
                map.put(s.substring(0, i), true);
                return true;   
            }
        }
        map.put(s, false);
        return false;
    }
}
*/
