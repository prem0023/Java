// Factorials of large numbers

class Solution {
    static ArrayList<Integer> factorial(int n){
        //code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        list.add(1);
        
        for(int i=2; i<=n; i++){
            int size = list.size() - 1;
            int carry = 0;
            
            while(size >= 0){
                int temp = list.get(size)*i+carry;
                
                list.set(size, temp%10);
                carry = temp/10;
                size--;
            }
            
            while(carry != 0){
                list.add(0,carry%10);
                carry = carry/10;
            }
            
        }

        return list;
    }
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(getFact(N));
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i : list)
			System.out.print(i);
		
		sc.close();
	}
}

/*
// Method - 2 (Recursion)
class Solution {
    static ArrayList<Integer> factorial(int n){
        //code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(n < 2){
            list.add(1);
            return list;
        }
            
        list = factorial(n-1);
        Collections.reverse(list);
        
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        int q = 0;
        
        for(int i : list){
            list1.add((i*n+q)%10);
            q = (i*n+q)/10;
        }
        while(q != 0){
            list1.add(q%10);
            q = q/10;
        }
           
        Collections.reverse(list1); 
        return list1;
    }
}

*/