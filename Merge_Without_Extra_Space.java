
import java.util.*;

class Merge_Without_Extra_Space {

    void merge(int arr1[], int arr2[], int n, int m) {
        int i = n - 1, j = 0;
        while( i >= 0 && j < m){
            if(arr1[i] > arr2[j]){
                int x = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = x;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}


/*
public static void merge(int arr1[], int arr2[], int n, int m) {
        int i=0;
        int x=0;
        while(i<n){
            if(arr1[i]>arr2[0]){
                x = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = x;
                i++;
                if(m>1){
                    for(int j=1;j<=m-1;j++){
                        if(arr2[j]>=x){
                            arr2[j-1] = x;
                            break;
                        }
                        else{
                            arr2[j-1] = arr2[j];
                            arr2[j] = x;
                        }
                    }
                }
            }
            else{
                i++;
            }
        }
    }
*/