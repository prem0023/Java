
public class String_Lar {
	
	/*
	public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String a[] = new String[100];
        
        for(int i = 0;i<s.length()-k+1;i++){
            a[i]=s.substring(i,i+k);
        }
        for(int i = 0;i<s.length()-k+1;i++){
            if((a[i].compareTo(a[i+1])>0)){
                a[i+1]=a[i];
            }
            else{}
        }
        smallest = a[s.length()-k];
        for(int i = 0;i<s.length()-k+1;i++){
            a[i]=s.substring(i,i+k);
        }
        for(int i = 0;i<s.length()-k+1;i++){
            if((a[i].compareTo(a[i+1])<0)){
                a[i+1]=a[i];
            }
            else{}
        }
        largest = a[s.length()-k];
        
        return smallest + "\n" + largest;
    }
*/

    public static void main(String[] args) {
     
    	
        String s = "welcometojava";
        int k = 3;
        
        String a[] = new String[100];
        
        for(int i = 0;i<s.length()-k+1;i++){
            a[i]=s.substring(i,i+k);
            //System.out.println(a[i]);
        }
        
        for(int i = 0;i<s.length()-k;i++){
            if(a[i].compareTo(a[i+1])>0){
            	String tem = a[i];
            	a[i] = a[i+1];
            	a[i+1] = tem;
            	//System.out.println(a[i]+" "+a[i+1]);	
            }
            else {}        	
        }        
        //System.out.println(a[s.length()-k]);
        
        for(int i = 0;i<s.length()-k;i++){
            if(a[i].compareTo(a[i+1])<0){
            	String tem = a[i];
            	a[i] = a[i+1];
            	a[i+1] = tem;
            	//System.out.println(a[i]+" "+a[i+1]);
            }
            else {}
        }
        System.out.println(a[s.length()-k]);
        
    }
}


