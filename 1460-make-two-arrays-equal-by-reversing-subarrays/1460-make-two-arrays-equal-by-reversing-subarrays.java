class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<target.length;i++){
            map.put(target[i],map.getOrDefault(target[i],0)+1);
        }
        for(int i=0;i<target.length;i++){
            if(!map.containsKey(arr[i]) || map.get(arr[i])==0){
                return false;
            }
            map.put(arr[i],map.get(arr[i])-1);
        }
        return true;
    }
}