// Sort Number by Frequency
import java.util.*;

class Solution{
    public static void main(String[] args){
    	int arr[] = { 4, 4, 5, 6, 4, 2, 2, 8, 5, 2};
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Pair> alist = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
            alist.add(new Pair(entry.getKey(),entry.getValue()));
        }

        Collections.sort(alist,(a,b)->b.freq-a.freq);
        for(int i=0;i<alist.size();i++){
            System.out.println(alist.get(i).num+"="+alist.get(i).freq);
        }
    }


}

class Pair{
    int num;
    int freq;

    Pair(int num,int freq){
        this.num = num;
        this.freq = freq;
    }
}