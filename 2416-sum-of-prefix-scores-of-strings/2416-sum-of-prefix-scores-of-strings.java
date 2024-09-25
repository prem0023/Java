class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.count++;
        }
    }

    public int calculateScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char ch : word.toCharArray()) {
            node = node.children.get(ch);
            score += node.count;
        }
        return score;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();

        // Step 1: Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }

        // Step 2: Calculate the score for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.calculateScore(words[i]);
        }
        return result;
    }
}