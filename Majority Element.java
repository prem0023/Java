// Majority Element

// Method 1
class Solution
{
    static int majorityElement(int a[], int size)
    {
        int count=0, ele=a[0];
        
        for(int num : a){
            if(count==0){
                ele = num;
                count = 1;
            }
            else{
                if(num == ele)
                    count++;
                else
                    count--; 
            }
            if(num == ele)
                count++;
            else
                count--;
        }
        return ele;
    }
}

/*
// Method 2

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i=0; i<size; i++){
            if(hm.get(a[i]) != null)
                hm.put(a[i], hm.get(a[i])+1);
            else
                hm.put(a[i], 1);
                
            if(i >= size/2 && hm.get(a[i]) > size/2)
                return a[i];
        }
        
        // for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
        //     if(entry.getValue() > size/2)
        //         return entry.getKey();
        // }
        
        return -1;
    }
}
*/