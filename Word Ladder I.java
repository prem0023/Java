// Method - 1 - My approach

class Solution
{
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> queue = new LinkedList<>();
        int n = wordList.length;
        int m = wordList[0].length();
        int[] dist = new int[n+1];
        int src = -1;
        
        for(int i=0; i<n; i++){
            if(startWord.equals(wordList[i])){
                src = i;
                break;
            }
        }
        
        for(int i=0; i<n; i++){
            dist[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<Integer>());
        }
        
        int t = 0;
        if(src == -1){
        	dist[n] = Integer.MAX_VALUE;
            adj.add(new ArrayList<Integer>());
            t = 1;
            src = 0;
            for(int i=0; i<n; i++){
                int count = 0;
                for(int j=0; j<m; j++){
                    if(wordList[i].charAt(j) != startWord.charAt(j))
                        count++;
                }
                if(count == 1){
                    adj.get(0).add(i+t);
                    adj.get(i+t).add(0);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int count = 0;
                for(int k=0; k<m; k++){
                    if(wordList[i].charAt(k) != wordList[j].charAt(k))
                        count++;
                    if(count > 1)
                        break;
                }
                if(count == 1){
                    adj.get(i+t).add(j+t);
                    adj.get(j+t).add(i+t);
                }
            }
        }
        dist[src] = 0;
        queue.offer(src);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int x : adj.get(node)){
                if(dist[node] + 1 < dist[x]){
                    dist[x] = dist[node] + 1;
                    queue.offer(x);
                }
            }
        }
        //System.out.println(Arrays.toString(dist));
        
        for(int i=0; i<n; i++){
            if(wordList[i].equals(targetWord)) {
            	if(dist[i+t] > n+1)
            		break;
                return dist[i+t] + 1;
            }
        }
        
        return 0;
    }
    
}


/*
//Method 2 - Striver's approach
class Pair {
    String first;
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // Creating a queue ds of type {word,transitions to reach ‘word’}.
        Queue < Pair > q = new LinkedList < > ();
 
        // BFS traversal with pushing values in queue 
        // when after a transformation, a word is found in wordList.
        q.add(new Pair(startWord, 1));

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set < String > st = new HashSet < String > ();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }
        st.remove(startWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
      
            // we return the steps as soon as
            // the first occurence of targetWord is found.
            if (word.equals(targetWord) == true) return steps;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // check if it exists in the set and push it in the queue.
                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }

            }
        }
        // If there is no transformation sequence possible
        return 0;
    }
}
*/
