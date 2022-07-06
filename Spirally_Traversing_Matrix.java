// Spirally traversing a matrix

class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        int nr = r;
		int nl = 0;
		int mr = c;
		int ml = 0;
		int i = 0;
		int j = 0;
		int ki = 0;
		int kj = 1;
		
		ArrayList<Integer> al = new ArrayList<>();
		
		while(i<nr && i>=nl && j>=ml && j<mr) {
			al.add(matrix[i][j]);
			i=i+ki;
			j=j+kj;
			if(i == nl && j == mr) {
				kj = 0;
				ki = 1;
				nl++;
				i++;
				j--;
			}
			else if(i == nr && j == mr-1) {
				mr--;
				kj = -1;
				ki = 0;
				j--;
				i--;
			}
			else if(i == nr-1 && j == ml-1) {
				nr--;
				i--;
				j++;
				ki = -1;
				kj = 0;
			}
			else if (i == nl-1 && j == ml) {
				ki = 0;
				kj = 1;
				ml++;
				i++;
				j++;
			}
			
		} 
		return al;
    }
}


/*
class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
  
        if (matrix.length == 0)
            return ans;
  
        int m = matrix.length, n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int x = 0, y = 0, di = 0;
  
        // Iterate from 0 to R * C - 1
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];
  
            if (0 <= cr && cr < m && 0 <= cc && cc < n
                    && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }
}
*/