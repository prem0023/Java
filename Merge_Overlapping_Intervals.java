// Merge overlapping intervals

public class Solution {
	public static ArrayList<ArrayList<Integer>> mergeIntervals(ArrayList<ArrayList<Integer>> list) {
	    
        list.sort((ArrayList<Integer> l1, ArrayList<Integer> l2) -> l1.get(0) - l2.get(0));
 
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        al.add(list.get(0));
        int k = 0;
        for(int i=1; i<list.size(); i++){
            ArrayList<Integer> l1 = al.get(k);
            ArrayList<Integer> l2 = list.get(i);
            
            if(l1.get(1) >= l2.get(0)) {
            	if(l1.get(1) < l2.get(1))
            		al.get(k).set(1, l2.get(1)); 
            }
            else{
                al.add(l2);
                k++;
            }
        }
        return al;
    }
}
/*
		list.sort(new Comparator<ArrayList<Integer>>(){

			@Override
			public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
				
				return l1.get(0) - l2.get(0);
			}

        });
*/