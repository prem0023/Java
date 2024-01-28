class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                count++;
            }

            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] sum = new int[matrix[0].length];

            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    sum[k] += matrix[j][k];
                }

                count += subarraySum(sum, target);
            }
        }

        return count;
    }
}