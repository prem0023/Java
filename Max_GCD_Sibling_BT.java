class Max_GCD_Sibling_BT {
    static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
        if(N<3){
            return 0;
        }
        
        Hashtable<Integer, Integer> ht = new Hashtable<>(N);
        int max =0;
        int b=0;
        for(int i=0;i<N-2;i++){
            int a = arr.get(i).get(0);
            b = arr.get(i+1).get(0);
            //System.out.println(i+" "+a+" "+b);
            if(a==b){
                int m = GFG(arr.get(i).get(1),arr.get(i+1).get(1));
                if(max<m){
                    max = m;
                }
                i++;
            }
            else{
                if(ht.get(a) != null){
                    int m = GFG(arr.get(i).get(1),arr.get(ht.get(a)).get(1));
                    if(max<m){
                        max = m;
                    }
                    //System.out.println("HT "+a+" "+i+" "+ht.get(a)+" "+arr.get(i).get(1)+" "+arr.get(ht.get(a)).get(1)+" "+m);
                    //a ic i xc y gfg
                    ht.remove(a);
                }
                else{
                    ht.put(a,i);
                }
            }
            //System.out.println(i);
        }
        if(b != arr.get(N-3).get(0)){
            if(ht.get(b) != null){
                int m = GFG(arr.get(N-2).get(1),arr.get(ht.get(b)).get(1));
                    if(max<m){
                        max = m;
                    }
            }
            ht.clear();
        }
        
        return max;
    }
    
    static int GFG(int x, int y){
        int gfg=1;
        for(int i=2;i<=x&&i<=y;i++){
            if(x%i==0 && y%i==0){
                gfg = i;
            }
        }
        //System.out.println("GFG "+x+" "+y+" "+gfg);
        return gfg;
    }
}