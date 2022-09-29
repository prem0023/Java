// Largest subarray with 0 sum

class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer, Integer> map=new HashMap<>();

        int prefix_sum=0;

        int ans=Integer.MIN_VALUE, sum_to_find=0;

        map.put(prefix_sum, -1);

        

        for(int i=0; i<n; i++){

            prefix_sum +=arr[i];

            if(map.containsKey(prefix_sum-sum_to_find)){

                ans=Math.max(ans, i-map.get(prefix_sum));

            }else{

                map.put(prefix_sum, i);

            }

        }

        return (ans==Integer.MIN_VALUE)?0:ans;
    }
}