// Power Of Numbers

class Solution
{
    int mod = (int)1e9+7;
    long power(int N,int R)
    {
        return getAns((long)N, (long)R);

    }
    
    long getAns(long N, long R){
        if(R == 0)
            return 1;
        
        if(R == 1)
            return N%mod;
        
        if(R<0){
            R = -1 * R;
            N = 1/N;
        }
        
        long ans = 0;
        
        if(R%2 == 0){
            ans = (getAns((N%mod * N%mod)%mod, (R / 2)))%mod;
        }
        else{
            ans = (N%mod * getAns((N%mod * N%mod)%mod,(R/2)%mod))%mod;
        }
        
        return ans;
    }
}
