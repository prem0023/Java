// Tower of Hanoi

class Solution {

    public static long toh(int N, int from, int to, int aux) {
        // Your code here
        if(N == 1){
            //System.out.println("move disk "+ N + " from rod "+ from + " to rod " + to );
            return 1;
        }
        long i = toh(N-1, from, aux, to); 
        //System.out.println("move disk "+ N + " from rod "+ from + " to rod " + to);
        i = i + toh(N-1, aux, to, from);
        
        
        return i + 1;
    }

	public static void main(String[] args) {
		
		//System.out.println("123".substring(0,1));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(toh(n,1,3,2));
		
		sc.close();
	}
}