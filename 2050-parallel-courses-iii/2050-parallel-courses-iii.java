class Solution {
    private int[] startNodes; // An array to store the starting nodes (nodes with no incoming edges).
    private ArrayList<Integer>[] graph; // An adjacency list representation of the course prerequisites graph.
    private int[] time; // An array to store the time required to complete each course.
    private boolean[] visited; // An array to track visited nodes during DFS.
    private int[] ans; // An array to store the maximum time needed for each course.

    public int minimumTime(int n, int[][] relations, int[] time) {
        toGraph(relations, n); // Convert the input relations into a graph.
        this.time = time;
        ans = new int[n]; // Initialize the ans array to store maximum times.
        visited = new boolean[n]; // Initialize the visited array for DFS.
        int longest = 0;

        // For each starting node (no incoming edges), find the maximum time needed.
        for (int node : startNodes) {
            longest = Math.max(longest, calculate(node));
        }
        return longest;
    }

    // Convert the input relations into an adjacency list graph.
    private void toGraph(int[][] edges, int n) {
        int[] incoming = new int[n];
        int[] outgoing = new int[n]; // Fixed the type declaration for outgoing.
        
        // Count incoming and outgoing edges for each node.
        for (int[] e : edges) {
            outgoing[e[0] - 1]++;
            incoming[e[1] - 1]++;
        }
        
        int startCnt = 0;

        // Count the number of starting nodes (nodes with no incoming edges).
        for (int i : incoming) {
            if (i == 0) {
                startCnt++;
            }
        }

        startNodes = new int[startCnt];

        // Populate the starting nodes array.
        for (int sni = 0, i = 0; sni < startNodes.length; i++) {
            if (incoming[i] == 0) {
                startNodes[sni++] = i;
            }
        }

        // Create the adjacency list graph.
        graph = new ArrayList[n]; // Fixed the type declaration for graph.
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Populate the graph with edges.
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
        }
    }

    // Recursively calculate the maximum time needed for a course using DFS.
    private int calculate(int node) {
        if (ans[node] > 0) {
            return ans[node];
        }

        int worstPrereq = 0;
        visited[node] = true;

        // Visit each child (prerequisite) and find the maximum time.
        for (int child : graph[node]) {
            if (!visited[child]) {
                worstPrereq = Math.max(calculate(child), worstPrereq);
            }
        }

        visited[node] = false;

        // Store the maximum time needed for the current course.
        return ans[node] = worstPrereq + time[node];
    }
}