class CommonElement
//Common element
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        int i=0, j=0, k=0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        while(i<n1 && j<n2 && k<n3){
            if(A[i] == B[j] && A[i] == C[k]){
                if(!al.contains(A[i]))
                    al.add(A[i]);
                    
                i++;
                j++;
                k++;
            }
            else{
                if(A[i] < B[j]){
                    if(A[i]<C[k])
                        i++;
                    else
                        k++;
                }
                else{
                    if(B[j]<C[k])
                        j++;
                    else
                        k++;
                }
            }
        }
        
        return al;
    }
}