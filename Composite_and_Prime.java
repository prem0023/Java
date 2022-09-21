// Composite and Prime

class Solution
{
    public int Count(int L, int R)
    {
        // code here
        ArrayList<Integer> comp = new ArrayList<>();

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = L; i <= R; i++) {

            if (i <= 1)

                continue;

            if (prime(i))

                primes.add(i);

            else

                comp.add(i);

        }

        return comp.size() - primes.size();

    }



    static boolean prime(int num) {

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {

            if (num % i == 0) {

                return false;

            }

        }

        return true;

  }
}

/*
class Solution
{
    public int Count(int L, int R)
    {
        // code here
        int c = 0;
        
        for(int i=L; i<=R; i++){
            if(i <= 1)
        		continue;
            else if(isPrime(i))
                c--;
            else
                c++;
        }
        
        return c;
    }
    
    boolean isPrime(int n){
        
        if(n < 2)
            return false;
        
        for(int i=2; i<=(int) Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
*/