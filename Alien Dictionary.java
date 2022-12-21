class Solution
{
    public static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        int[] indegree = new int[26];
        String ans = "";
        
        for(int i=1; i<N; i++){
            if(dict[i].charAt(0) != dict[i-1].charAt(0)){
                if(map.containsKey(dict[i-1].charAt(0)))
                    map.get(dict[i-1].charAt(0)).add(dict[i].charAt(0));
                else{
                    ArrayList<Character> temp = new ArrayList<>();
                    temp.add(dict[i].charAt(0));
                    map.put(dict[i-1].charAt(0), temp);
                }
            }
            else{
                int n = dict[i-1].length();
                int m = dict[i].length();
                int j=0,k=0;
                while(j<n && k<m){
                    if(dict[i].charAt(k) != dict[i-1].charAt(j)){
                        if(map.containsKey(dict[i-1].charAt(j))){
                            map.get(dict[i-1].charAt(j)).add(dict[i].charAt(k));
                        }
                        else{
                            ArrayList<Character> temp = new ArrayList<>();
                            temp.add(dict[i].charAt(k));
                            map.put(dict[i-1].charAt(j), temp);
                        }
                        break;
                    }
                    j++;
                    k++;
                }
            }
        }
        
        for(Map.Entry<Character, ArrayList<Character>> entry : map.entrySet()){
            char key = entry.getKey();
            
            for(char c : map.get(key)){
                indegree[c-'a']++;
            }
        }
        for(int i=0; i<26; i++){
            if(indegree[i] == 0)
                queue.offer((char)(i+97));
        }
        
        while(!queue.isEmpty()){
            char c = queue.poll();
            ans = ans + c;
            if(!map.containsKey(c))
                continue;
            for(char ch : map.get(c)){
                indegree[ch-'a']--;
                if(indegree[ch-'a'] == 0)
                    queue.offer(ch);
            }
        }
        
        return ans;
    }
}

/*
// Striver's solution

import java.util.*;


class Solution {
    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }
    public String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        String ans = "";
        for (int it : topo) {
            ans = ans + (char)(it + (int)('a'));
        }

        return ans;

    }
}

public class tUf {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        Solution obj = new Solution();
        String ans = obj.findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
*/
