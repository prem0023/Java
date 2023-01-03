class Solution {
	static List<List<String>> accountsMerge(List<List<String>> accounts) {

		List<List<String>> ans = new ArrayList<>();
		List<List<String>> temp = new ArrayList<>();
		int n = accounts.size();
		DisjointSet dj = new DisjointSet(n);
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < accounts.get(i).size(); j++) {
				String key = accounts.get(i).get(j);
				if (map.containsKey(key)) {
					int val = map.get(key);
					dj.unionByRank(val, i);
				}
				else
				    map.put(key, i);
			}
		}
		for(int i=0; i<n; i++){
		    temp.add(new ArrayList<>());
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet()){
		    int val = entry.getValue();
		    String key = entry.getKey();
		    val = dj.findUPar(val);
		    temp.get(val).add(key);
		}
		
		for(int i=0; i<n; i++){
		    List<String> st = temp.get(i);
		    if(st.size() > 0){
		        Collections.sort(st);
		        String node = accounts.get(i).get(0);
		        List<String> l = new ArrayList<>();
		        l.add(node);
		        l.addAll(st);
		        ans.add(l);
		    }
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