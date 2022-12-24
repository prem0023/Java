//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


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