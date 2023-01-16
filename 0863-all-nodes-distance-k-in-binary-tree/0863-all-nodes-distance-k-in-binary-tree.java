/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair
{
    TreeNode node;
    int dist;
    Pair(TreeNode _node, int _dist){
        this.node = _node;
        this.dist = _dist;
    }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<>();

		insertNode(root, map, null);

		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp.val == target.val) {
				bfs(temp, map, ans, k);
				q.clear();
			}
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);
		}
		Collections.sort(ans);
		return ans;
	}

	private static void insertNode(TreeNode root, HashMap<TreeNode, TreeNode> map, TreeNode prev) {
		if (root == null)
			return;

		map.put(root, prev);

		if (root.left != null)
			insertNode(root.left, map, root);
		if (root.right != null)
			insertNode(root.right, map, root);
	}

	private static void bfs(TreeNode root, HashMap<TreeNode, TreeNode> map, ArrayList<Integer> ans, int k) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		HashMap<TreeNode, Boolean> hm = new HashMap<>();
		hm.put(root, true);

		while (!q.isEmpty()) {
			Pair p = q.poll();
			TreeNode node = p.node;
			int dist = p.dist;

			if (dist == k)
				ans.add(node.val);

			if (node.left != null && !hm.containsKey(node.left) && dist < k) {
				q.offer(new Pair(node.left, dist + 1));
				hm.put(node.left, true);
			}
			if (node.right != null && !hm.containsKey(node.right) && dist < k) {
				q.offer(new Pair(node.right, dist + 1));
				hm.put(node.right, true);
			}
			if (map.get(node) != null && !hm.containsKey(map.get(node)) && dist < k) {
				q.offer(new Pair(map.get(node), dist + 1));
				hm.put(map.get(node), true);
			}
		}
	}
}