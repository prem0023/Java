
import java.util.Arrays;
class Count_Inversion
{
	static int merge(int arr[], int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;

		int count = 0;
		
		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
				count = count + n1-i;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
			
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return count;
		
	}

	int sort(int arr[], int l, int r)
	{
		int count = 0;
		
		if (l < r) {
		
			int m =l+ (r-l)/2;

			count += sort(arr, l, m);
			count += sort(arr, m + 1, r);

			count += merge(arr, l, m, r);
			
		}
		return count;
	}

	public static void main(String args[])
	{
		int arr[] = { 2, 4, 1, 3, 5, 4, 9, 4, 3, 7, 6};
		int n = arr.length;

		Exp ob = new Exp();
		int count = ob.sort(arr, 0, n-1);

		System.out.println(Arrays.toString(arr));
		System.out.println(count);
		
	}
}
