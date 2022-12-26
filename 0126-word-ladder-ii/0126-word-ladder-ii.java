class Solution {
    String b;

    // Create a hashmap of type word->level to get the idea 
    // on which level the word comes after the transformations.

    HashMap < String, Integer > mpp;

    // A list for storing the final answer.
    List < List < String >> ans;
    private void dfs(String word, List < String > seq) {

        // Function for implementing backtracking using the created map
        // in reverse order to find the transformation sequence in less time.

        // Base condition :
        // If word equals beginWord, we’ve found one of the sequences
        // simply reverse the sequence and return. 
        if (word.equals(b)) {

            // Since java works with reference, create
            // a duplicate and store the reverse of it
            List < String > dup = new ArrayList < > (seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps = mpp.get(word);
        int sz = word.length();

        // Replace each character of the word with letters from a-z 
        // and check whether the transformed word is present in the map
        // and at the previous level or not.
        for (int i = 0; i < sz; i++) {

            for (char ch = 'a'; ch <= 'z'; ch++) {
                char replacedCharArray[] = word.toCharArray();
                replacedCharArray[i] = ch;
                String replacedWord = new String(replacedCharArray);
                if (mpp.containsKey(replacedWord) &&
                    mpp.get(replacedWord) + 1 == steps) {

                    seq.add(replacedWord);
                    dfs(replacedWord, seq);

                    // pop the current word from the back of the queue
                    // to traverse other possibilities.
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    public List < List < String >> findLadders(String beginWord, String endWord,
        List < String > wordList) {

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set < String > st = new HashSet < String > ();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }

        // Perform BFS traversal and push the string in the queue
        // as soon as they’re found in the wordList.
        Queue < String > q = new LinkedList < > ();
        b = beginWord;
        q.add(beginWord);
        mpp = new HashMap < > ();

        // beginWord initialised with level 1.
        mpp.put(beginWord, 1);
        int sizee = beginWord.length();
        st.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek();
            int steps = mpp.get(word);
            q.remove();

            // Break out if the word matches the endWord.
            if (word.equals(endWord)) break;

            // Replace each character of the word with letters from a-z 
            // and check whether the transformed word is present in the 
            // wordList or not, if yes then push to queue
            for (int i = 0; i < sizee; i++) {

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord) == true) {
                        q.add(replacedWord);
                        st.remove(replacedWord);

                        // push the word along with its level
                        // in the map data structure.
                        mpp.put(replacedWord, steps + 1);
                    }
                }


            }
        }
        ans = new ArrayList < > ();

        // If we reach the endWord, we stop and move to step-2
        // that is to perform reverse dfs traversal.
        if (mpp.containsKey(endWord) == true) {
            List < String > seq = new ArrayList < > ();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return ans;
    }
}