//Alternate positive and negative numbers

class Alt_Positive_Negartive {
    void rearrange(int arr[], int n) {
        int i = 0;
        while(i<n){
            if(i%2 == 0){
                if(arr[i]<0){
                    int k = findPositive(arr,i+1,n);
                    if(k<0)
                        return;
                    int c = arr[k];
                    while(k>i){
                        arr[k] = arr[k-1];
                        k--;
                    }
                    arr[i] = c;
                }
                
            }
            else{
                if(arr[i]>=0){
                    int k = findNegative(arr,i+1,n);
                    if(k<0)
                        return;
                    int c = arr[k];
                    while(k>i){
                        arr[k] = arr[k-1];
                        k--;
                    }
                    arr[i] = c;
                }
            }
            i++;
        }
    }
    
    static int findPositive(int[] arr,int i,int n){
        while(i<n){
            if(arr[i]>=0)
                return i;
            i++;
        }
        return -1;
    }
    
    static int findNegative(int[] arr,int j,int n){
        while(j<n){
            if(arr[j]<0)
                return j;
            j++;
        }
        return -1;
    }
}

/*
class Solution2 {
	static void rearrange(int arr[], int n) {
		ArrayList<Integer> positive = new ArrayList<>();
		ArrayList<Integer> negative = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (arr[i] >= 0) {
				positive.add(arr[i]);
			} else {
				negative.add(arr[i]);
			}
		}
		int pos = 0;
		int neg = 0;
		int po = positive.size();
		int ne = negative.size();
		for (int j = 0; j < n; j++) {
			if (j == 0) {
				if (po > 0) {
					arr[j] = positive.get(pos++);
				} else {
					arr[j] = negative.get(neg++);
				}
			} 
			else if (j % 2 != 0 && neg < ne) {
				arr[j] = negative.get(neg++);
			} 
			else if (j % 2 == 0 && pos < po) {
				arr[j] = positive.get(pos++);
			} 
			else if (pos == positive.size() && neg < ne) {
				findNegative(arr, j, negative,neg, ne);
				return;
			} 
			else if (neg == negative.size() && pos < po) {
				findPositive(arr, j, positive,pos, po);
				return;
			}
		}
	}
*/
