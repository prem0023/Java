class Solution {
    private int partition(String[] names,int[] heights,int low,int high)
    {
         int pivot = heights[high];
        int i = (low - 1); // index of the larger element

        for (int j = low; j < high; j++) {
            // If the current element is greater than or equal to the pivot
            if (heights[j] >= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = heights[i];
                heights[i] = heights[j];
                heights[j] = temp;
                String temps = names[i];
                names[i] = names[j];
                names[j] = temps;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = heights[i + 1];
        heights[i + 1] = heights[high];
        heights[high] = temp;

        String temps=names[i+1];
        names[i+1]=names[high];
        names[high]=temps;

        return i + 1;
    }
    private void quicksort(String[] names,int[] heights,int low,int high)
    {
        if(low<high)
        {
            int pi=partition(names,heights,low,high);
            quicksort(names,heights,low,pi-1);
            quicksort(names,heights,pi+1,high);
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        int length=heights.length-1;
        quicksort(names,heights,0,length);
        return names;
    }
}