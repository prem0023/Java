class Find_All_Occurence {

	public static void main(String[] args) {
		int[] a = {2,3,6,9,3,5,0,3,4,6}; //1 4 7
		find(3,a,0);
	}
	public static void find(int k, int[] a, int start) {
	
		if(start == a.length)
			return;
		else if(a[start] == k) {
			System.out.println(start);
		}
		find(k,a,start+1);
		return;
	}
	
}