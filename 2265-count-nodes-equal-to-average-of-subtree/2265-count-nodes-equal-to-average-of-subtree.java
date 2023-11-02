/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int matchingSubtreeCount = 0; // Initialize the count of subtrees with matching averages.

    // A Depth-First Search (DFS) function that returns an array of two values:
    // - The sum of values within the current subtree.
    // - The number of nodes within the current subtree.
    private int[] calculateSubtreeValues(TreeNode currentNode) {
        if (currentNode == null)
            return new int[]{0, 0}; // Base case: Return 0 for both sum and number of nodes if the node is null.

        // Recursively calculate values for the left and right subtrees.
        int[] leftSubtree = calculateSubtreeValues(currentNode.left);
        int[] rightSubtree = calculateSubtreeValues(currentNode.right);

        // Calculate the sum of values and the number of nodes in the current subtree.
        int sumOfValues = leftSubtree[0] + rightSubtree[0] + currentNode.val;
        int numberOfNodes = leftSubtree[1] + rightSubtree[1] + 1;

        // Check if the current node's value matches the average of its subtree.
        if (sumOfValues / numberOfNodes == currentNode.val)
            matchingSubtreeCount++;

        return new int[]{sumOfValues, numberOfNodes}; // Return the calculated values for the current subtree.
    }

    public int averageOfSubtree(TreeNode root) {
        calculateSubtreeValues(root); // Start the DFS from the root node.
        return matchingSubtreeCount; 
    }
}