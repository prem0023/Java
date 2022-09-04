// Job Sequencing Problem

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(item1, item2) -> {
            return item2.profit - item1.profit;
        });
        
        int[] sum = new int[n+1];
        
        int i = 0;
        int j = 0;
        
        while(i<n){
            if(arr[j].deadline > n)
                arr[j].deadline = n;
                
            if(sum[arr[j].deadline] == 0)
                sum[arr[j].deadline] = arr[j].profit;
                
            else{
                int x = arr[j].deadline - 1;
                while(sum[x] != 0 && x > 0)
                    x--;
                if(x != 0)
                	sum[x] = arr[j].profit;
            }
            i++;
            j++;
        }
        
        i = 0;
        j = 0;
        int max_profit = 0;
        while(i <= n){
            if(sum[i] != 0)
                j++;
            max_profit += sum[i];
            i++;
        }
        int[] a = {j, max_profit};
        return a;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/