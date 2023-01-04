class Solution {
    public int minimumRounds(int[] tasks) {
        // Sort the tasks array in ascending order
        Arrays.sort(tasks);
        int result = 0, count = 0;
        // Iterate through each task
        for (int i = 0; i < tasks.length; i++) {
            // Increment the count of tasks with the same value
            count++;
            // If we have reached the last task or the current task is different from the next task
            if (i == tasks.length - 1 || tasks[i] != tasks[i + 1]) {
                // If there is only one task with this value, we cannot create groups of 3
                // and we return -1
                if (count == 1) {
                    return -1;
                }
                // Add the number of full groups of 3 we can create from the tasks with this value
                result += count / 3;
                // If there are remaining tasks that cannot be included in a group of 3,
                // we need one more round to process these tasks
                if(count % 3 != 0) result++;
                // Reset the count for the next set of tasks
                count = 0;
           }
        }
        // Return the total number of rounds needed
        return result;
    }
}