// Replace every element with the least greater element on its right

lass Solution {
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int a : arr) {
            int count = map.get(a);
            if(count > 1) {
                map.put(a, count - 1);
            } else {
                map.remove(a);
            }
            Integer ceil = map.ceilingKey(a + 1);
            if(ceil == null) {
                res.add(-1);
            } else {
                res.add(ceil);
            }
        }
        return res;
    }
}