//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        int[] indegree = new int[K];
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
        for(int i=0; i<K; i++){
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