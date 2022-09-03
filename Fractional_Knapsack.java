// Fractional Knapsack -- Greedy Method

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
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Pair[] p=new Pair[n];
        
        for(int i=0;i<n;i++){
            double r=arr[i].value*1.0/arr[i].weight*1.0;
            p[i]=new Pair(r,i);
        }
        Arrays.sort(p);
        
        int i=0;
        double maxVal=0;
        while(i<n && W>0){
            if((arr[p[i].index].weight) < W){
                maxVal+=arr[p[i].index].value;
                W-=arr[p[i].index].weight;
            }else{
                maxVal+=p[i].ratio*W;
                W=0;
            }
            i++;
        }
        return maxVal;
        
    }
}