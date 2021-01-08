package p1;


public class Max_Profit {

	public static void main(String[] args) {
		int[] a = {0,5,5,6,2,1,1,3};
		//System.out.println(n);
		System.out.println(maxProfit(a));
	}
	
	
	    public static int maxProfit(int[] prices) {
	        int sum = 0;
	        //int max = 0;
	        int min = 0;
	        int c = 0;
	        int n = prices.length;
	        if(n==1) {
	        	return 0;
	        }
	        if (prices[0] <prices[1]){
	            min = prices[0];
	            c = 1;
	        }
	        try{
	        for(int i=1;i<n;i++){
	            if(c==0 && prices[i] < prices[i+1] && prices[i] <= prices[i-1]){
	                min = prices[i];
	                c=1;
	            }
	            else if( c==1 && prices[i] > prices[i+1]){
	                sum = sum + prices[i] - min;
	                c = 0;
	                System.out.println(min+" "+prices[i]+" "+ sum);
	            }
	        }
	        }
	        catch(Exception e){
	        	if(c==1) {
	        		sum = sum + prices[n-1] - min;
	        	}
	        }
	        return sum;
	        
	    }
	
}
