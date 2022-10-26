// License Key Formatting

class Solution{
    static String ReFormatString(String S, int K){
        // code here
        S = S.toUpperCase();
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(int i = S.length()-1; i >= 0; i--) {
            if(S.charAt(i) != '-') {
                char c = S.charAt(i);
                q.add(c);
                if(q.size() == K) {
                    while(!q.isEmpty()) sb.append(q.poll());
                    sb.append('-');
                }
            }
        }
        while(!q.isEmpty()) sb.append(q.poll());
        String ans = sb.reverse().toString();
        int cnt = 0;
        while(cnt < ans.length() && ans.charAt(cnt) == '-') cnt++;
        return ans.substring(cnt, ans.length());
    }
}

/*
class Solution{
    static String ReFormatString(String S, int K){
        // code here
        StringBuilder result = new StringBuilder();
        int count =0;
        int i=S.length()-1;
        
        while(i>=0){
            char curr = Character.toUpperCase(S.charAt(i));
            if(curr=='-')
                i--;
            else if(count!=0 && count%K==0){
                result.insert(0,'-');
                count=0;
            }
            else{
                result.insert(0,curr);
                count++;
                i--;
            }
        }
        return result.toString();
    }
}
*/