// Array Subset of another array

class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        HashMap<Long, Integer> map = new HashMap<>();

        for(int i =0; i<n; i++){
            map.put(a1[i], map.getOrDefault(a1[i],0)+1);
        }
        for(int j =0; j<m; j++){
            if((!map.containsKey(a2[j])) || (map.get(a2[j])==0)){
                return "No";
            }
            else{
                map.put(a2[j],map.getOrDefault(a2[j],0)-1);
            }
        }
        return "Yes";
    }
}