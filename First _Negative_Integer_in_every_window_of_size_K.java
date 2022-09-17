// First negative integer in every window of size k

class Compute {
   
   public long[] printFirstNegativeInteger(long arr[], int n, int k)
   {
       int i=0,j=0;
       ArrayList<Long> list=new ArrayList<>();
  
       long ret[]=new long[n-k+1];
       int index=0;
       while(j<n){
           if(arr[j]<0){
               list.add(arr[j]);
           }
           
           if(j-i+1<k){
               j++;
           }
           else{
               if(j-i+1==k){
                   if(!list.isEmpty())
                   {
                       ret[index++]=list.get(0);
                       if(arr[i]==list.get(0)){
                           list.remove(0);
                       }
                       i++;
                       j++;
                   }
                   else{
                       ret[index++]=0;
                        i++;
                        j++;
                   }
               }
           }
       }
       
       return ret;
   }
}