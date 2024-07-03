class Solution {
    private int minDiff(List<Integer> nums) {
        int n = nums.size();
        return Math.min(
                Math.min(nums.get(n - 1) - nums.get(3), nums.get(n - 2) - nums.get(2)),
                Math.min(nums.get(n - 3) - nums.get(1), nums.get(n - 4) - nums.get(0))
        );
    }

    private int minDiffViaPq(List<Integer> nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int el : nums) {
            maxHeap.add(el);
            minHeap.add(el);

            if (maxHeap.size() > 4) maxHeap.poll();
            if (minHeap.size() > 4) minHeap.poll();
        }

        int l = 3;
        int r = nums.size() - 4;
        while (!maxHeap.isEmpty()) {
            nums.set(l--, maxHeap.poll());
            nums.set(r++, minHeap.poll());
        }
        return minDiff(nums);
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(num);
        }

        return minDiffViaPq(ans);
    }
}