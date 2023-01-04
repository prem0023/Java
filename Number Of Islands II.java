// problem link : https://practice.geeksforgeeks.org/problems/number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-islands
class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        List<Integer> ans = new ArrayList<>();
        int[][] matrix = new int[rows][cols];
        int n = operators.length;
        DisjointSet dj = new DisjointSet(n+1);
        
        for(int i=0; i<n; i++){
            int x = operators[i][0];
            int y = operators[i][1];
            
            if(matrix[x][y] != 0){
                ans.add(ans.get(i-1));
                dj.unionBySize(i+1, matrix[x][y]);
                continue;
            }
            
            if(x>0 && matrix[x-1][y] != 0)
                dj.unionBySize(i+1, matrix[x-1][y]);
            
            if(x+1<rows && matrix[x+1][y] != 0)
                dj.unionBySize(i+1, matrix[x+1][y]);
            
            if(y>0 && matrix[x][y-1] != 0)
                dj.unionBySize(i+1, matrix[x][y-1]);
            
            if(y+1<cols && matrix[x][y+1] != 0)
                dj.unionBySize(i+1, matrix[x][y+1]);
            
            matrix[x][y] = i+1;
            int count = i+1;
            
            for(int j=1; j<=i+1; j++){
                if(dj.findUPar(j) != j)
                    count--;
            }
            ans.add(count);
        }
        
        return ans;
    }
    
}

class DisjointSet {
	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	List<Integer> size = new ArrayList<>();

	public DisjointSet(int n) {
		for (int i = 0; i <= n; i++) {
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}

	public int findUPar(int node) {
		if (node == parent.get(node)) {
			return node;
		}
		int ulp = findUPar(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}

	public void unionByRank(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v)
			return;
		if (rank.get(ulp_u) < rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
		} else if (rank.get(ulp_v) < rank.get(ulp_u)) {
			parent.set(ulp_v, ulp_u);
		} else {
			parent.set(ulp_v, ulp_u);
			int rankU = rank.get(ulp_u);
			rank.set(ulp_u, rankU + 1);
		}
	}

	public void unionBySize(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v)
			return;
		if (size.get(ulp_u) < size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
		} else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
		}
	}
}
