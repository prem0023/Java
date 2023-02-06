import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
	int num, freq;

	Pair(int _num, int _freq) {
		this.num = _num;
		this.freq = _freq;
	}
}

class GFG {
	public static int[] frequencySort(int[] nums) {
		int n = nums.length;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
			if (a.freq != b.freq)
				return b.freq - a.freq;

			return a.num - b.num;
		});
		int[] ans = new int[n];

		for (int i = 0; i < n; i++) {
			int x = map.getOrDefault(nums[i], 0);
			map.put(nums[i], x + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		int c = 0;
		while (!pq.isEmpty()) {
			int m = pq.peek().freq;
			int x = pq.poll().num;
			for (int i = 0; i < m; i++)
				ans[c++] = x;
		}

		return ans;
	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			arr = frequencySort(arr);

			for (int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");

			System.out.println();
		}
	}
}