class Solution {
    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        int islands = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(stones[i], visited, stones);
                islands++;
            }
        }
        return stones.length - islands;
    }
    
    private void dfs(int[] stone, boolean[] visited, int[][] stones) {
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] && (stone[0] == stones[i][0] || stone[1] == stones[i][1])) {
                visited[i] = true;
                dfs(stones[i], visited, stones);
            }
        }
    }
}