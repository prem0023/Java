class Solution {
    String addBinary(String A, String B) {
        // code here
        java.math.BigInteger a=new java.math.BigInteger(A,2);
        java.math.BigInteger b=new java.math.BigInteger(B,2);
        a=a.add(b);
        return a.toString(2);
    }
}

/*
class Solution {
    String addBinary(String A, String B) {
        java.math.BigInteger a=new java.math.BigInteger(A,2);
        java.math.BigInteger b=new java.math.BigInteger(B,2);
        a=a.add(b);
        return a.toString(2);
        
    }
}
 

0

kshitijmagare19
44 minutes ago

class Solution {
    String addBinary(String a, String b) {
        // code here
        int carry = 0;
        int l = a.length();
        String ans = "";
        String result = "";
        int l1 = a.length(), l2 = b.length();
        if(l1 > l2){
            int i = l1 - l2;
            while(i-->0){
                b = "0" + b;
            }
            l = l1;
        }
        else if(l1 < l2){
            int i = l2 - l1;
            while(i-->0){
                a = "0" + a;
            }
            l = l2;
        }
        //System.out.println(a+ " "+ b);
        for(int i = l-1; i >=0; i--){
            //System.out.println("\n"+a.charAt(i)+ " "+ b.charAt(i) + " "+ carry);
            if((a.charAt(i)- '0') + (b.charAt(i) - '0') + carry == 2){
                carry = 1;
                ans+="0";
            }
            else if((a.charAt(i)- '0') + (b.charAt(i) - '0') + carry== 1){
                carry = 0;
                ans+="1";
            }
            else if((a.charAt(i)- '0') + (b.charAt(i) - '0') + carry== 3){
                carry = 1;
                ans+="1";
            }
            else{
                carry = 0;
                ans+="0";
            }
            //System.out.print( " nK: "+carry + " "+ ans);
        }
        if(carry == 1){
            ans+="1";
        }
        //System.out.print( " \n\n ");
        for(int i = ans.length()-1; i >=0; i--){
            result += ans.charAt(i);
        }
        return result.replaceFirst("^0*", "");
    }
}
*/
