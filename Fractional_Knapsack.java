// Fractional Knapsack -- Greedy Method

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        
        Arrays.sort(arr, (item1, item2) -> {
            double x = (double)item2.value/item2.weight;
            double y = (double)item1.value/item1.weight;
            
            return x > y ? 1 : -1;
        });

        // for(Item i : arr)
        //     System.out.println("Value : " +i.value + " Weight : " + i.weight);
            
        double sum = 0;
        int i = 0;
        
        while(W != 0 && i < n){
            if(W >=  arr[i].weight){
                sum = sum + arr[i].value;
                W -= arr[i].weight;
            }
            else{
                sum = sum + (double)(W*arr[i].value)/arr[i].weight;
                break;
            }
            i++;
        }
        return sum;
    }
}

/*
class Pair implements Comparable<Pair>{
    double ratio;
    int index;
    Pair(double ratio,int index){
        this.ratio=ratio;
        this.index=index;
    }
    public int compareTo(Pair p){
        if(this.ratio < p.ratio) return 1;
        else if(this.ratio > p.ratio) return -1;
        else return 0;
    }
}
*/
