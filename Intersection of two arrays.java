// Intersection of two arrays

class Solution {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : b)
        {
            if(map.containsKey(i))
            map.put(i, map.get(i)+1);
            else
            map.put(i, 1);
        }
        for(int i : a)
        {
            if(map.containsKey(i))
            {
                cnt++;
                map.remove(i);
            }
        }
        return cnt;
    }
}
