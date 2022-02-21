
public class Closest_Pair_from_Two_Sorted_Arrays
{
	public static void Closest_Pair(int[] a, int[] b, int x){
		int n = a.length;
		int m = b.length;
		int i=0,j=m-1;
		int x1 = a[i], x2 = b[j];
		int sum = x1+x2;
		int c=0;
		while(i<n && j>=0){
			if(c>=4){
				System.out.println(x1+" and "+x2);
				return;
			}
			if(a[i]+b[j] == x){
				System.out.println(a[i]+" and "+b[j]);
				return;
			}
			else if(a[i]+b[j] > x){
				j--;
				if(Math.abs(x-sum) > Math.abs(x-a[i]-b[j])){
					sum = a[i]+b[j];
					x1 = a[i];
					x2 = b[j];
				}
				else
					c++;
			}
			else{
				i++;
				if(Math.abs(x-sum) > Math.abs(x-a[i]-b[j])){
					sum = a[i]+b[j];
					x1 = a[i];
					x2 = b[j];
				}
				else
					c++;
			}
		}
	}
		
	public static void main(String[] args){
		int[] a = {1, 4, 5, 7};
		int[] b = {10, 20, 30, 40};
		int x = 32;
		Closest_Pair(a,b,x);
	}
}