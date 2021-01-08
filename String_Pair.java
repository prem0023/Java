
import java.util.Scanner;

public class String_Pair {
	
	static int[] removeDuplicates(int arr[], int n) 
	{
	    if (n==0 || n==1) 
	        return arr; 
	    int[] temp = new int[n]; 
	    int j = 0; 
	    for (int i=0; i<n-1; i++) 
	        if (arr[i] != arr[i+1]) 
	            temp[j++] = arr[i]; 
	    temp[j++] = arr[n-1];    
	    for (int i=0; i<j; i++) 
	        arr[i] = temp[i]; 
	    return temp; 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] b = new int[N];
		int[] x = new int[N];
		String[] d = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven", "twelve", "thirteen",  "fourteen", "fifteen", "sixteen",  "seventeen", "eighteen","nineteen",  "twenty",  "twentyone",  "twentytwo", "twentythree","twentyfour",  "twentyfive","twentysix","twentyseven","twentyeight", "twentynine", "thirty", "thirtyone","thirtytwo", "thirtythree", "thirtyfour", "thirtyfive",  "thirtysix",  "thirtyseven",  "thirtyeight",  "thirtynine",  "forty",  "fortyone",  "fortytwo",  "fortythree",  "fortyfour",  "fortyfive",  "fortysix",  "fortyseven",  "fortyeight",  "fortynine",  "fifty",  "fiftyone",  "fiftytwo",  "fiftythree",  "fiftyfour",  "fiftyfive",  "fiftysix",  "fiftyseven",  "fiftyeight",  "fiftynine",  "sixty",  "sixtyone",  "sixtytwo",  "sixtythree",  "sixtyfour",  "sixtyfive",  "sixtysix",  "sixtyseven",  "sixtyeight",  "sixtynine",  "seventy",  "seventyone",  "seventytwo",  "seventythree",  "seventyfour",  "seventyfive",  "seventysix",  "seventyseven",  "seventyeight",  "seventynine",  "eighty",  "eightyone",  "eightytwo",  "eightythree",  "eightyfour",  "eightyfive",  "eightysix",  "eightyseven",  "eightyeight",  "eightynine",  "ninety",  "ninetyone",  "ninetytwo",  "ninetythree",  "ninetyfour",  "ninetyfive",  "ninetysix",  "ninetyseven",  "ninetyeight",  "ninetynine",  "hundred"};
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			b[i] = a;
			String s = d[a];
			int c=0;
			for(int j=0;j<s.length();j++){
				char t = s.charAt(j);
				if( t =='a'||t == 'e'||t == 'i'||t == 'o'||t == 'u') {
					c++;
				}
			}
			x[i] = c;
			sum = sum + c;
			c = 0;
		}
		b = String_Pair.removeDuplicates(b, N);

		int count = 0;
		for(int i=0;i<N;i++) {
			
			for(int j=i+1;j<N;j++) {
				if(b[i]+b[j]== sum) {
					count++;
				}
			}
		}
		try {
			System.out.println(d[count]);
		}
		catch(Exception e) {
			System.out.println("greater 100");
		}
		
		
		sc.close();
	}

}
