//Print anyone SCS

//Method -1 
class Solution {
    int[][] t;
    int l = 0;
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int n = str1.length();
        int m = str2.length();
		
		t = new int[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++)
                t[i][j] = -1;
        }
        
        l = getLCS(str1, str2, n, m);
        
        return printSCS(str1, str2, n, m);
        
    }
    
    String printSCS(String s1, String s2, int n, int m){
        
        String s = "";
        
        while(n>0 && m>0){
            
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                s = s1.charAt(n-1) + s;
                n--;
                m--;
            } 
            else if(t[n][m-1] == t[n][m]) {
            	s = s2.charAt(m-1) + s;
                m--;     
            }
            else {
            	s = s1.charAt(n-1) + s;
                n--;
            }
        }
        while(n>0){
            s = s1.charAt(n-1) + s;
            n--;
        }
        while(m>0){
            s = s2.charAt(m-1) + s;
            m--;
        }
        return s; 
    }
    
    int getLCS(String s1, String s2, int n, int m){
        
        if(n == 0 || m == 0)
            return 0;
        
        if(t[n][m] != -1)
            return t[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1))
            t[n][m] = 1 + getLCS(s1, s2, n-1, m-1);
        
        else
            t[n][m] = Math.max(getLCS(s1, s2, n-1, m), getLCS(s1, s2, n, m-1));
        
        return t[n][m];
    }
}

/*
//Method - 2

class Solution {
    int l = 0;
    int[][] t;
    public String shortestCommonSupersequence(String str1, String str2) {
		char[] arr1 = str1.toCharArray(), arr2 = str2.toCharArray();
        
		int m = arr1.length, n = arr2.length;
        
        t = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++)
                t[i][j] = -1;
        }
        
        l = getLCS(str1, str2, m, n);
        String st = printSCS(str1, str2, m, n);
        char[] arr3 = st.toCharArray();
        
        int o = arr3.length;
        
		char[] res = new char[m + n - o];
		int index = 0, i = 0, j = 0, k = 0;
		while (k < o) {
			while (arr1[i] != arr3[k]) {
				res[index++] = arr1[i++];
			}
			while (arr2[j] != arr3[k]) {
				res[index++] = arr2[j++];
			}
			res[index++] = arr3[k++];
			i++;
			j++;
		}
		while (i < m) {
			res[index++] = arr1[i++];
		}
		while (j < n) {
			res[index++] = arr2[j++];
		}
		return String.valueOf(res);
	}
    
    String printSCS(String s1, String s2, int n, int m){
        
        String s = "";
        
        while(n>0 && m>0){
            
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                s = s1.charAt(n-1) + s;
                n--;
                m--;
            } 
            else if(t[n][m-1] == t[n][m]) {
                m--;     
            }
            else {
                n--;
            }
        }
        return s; 
    }
    
    int getLCS(String s1, String s2, int n, int m){
        
        if(n == 0 || m == 0)
            return 0;
        
        if(t[n][m] != -1)
            return t[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1))
            t[n][m] = 1 + getLCS(s1, s2, n-1, m-1);
        
        else
            t[n][m] = Math.max(getLCS(s1, s2, n-1, m), getLCS(s1, s2, n, m-1));
        
        return t[n][m];
    }
}
*/