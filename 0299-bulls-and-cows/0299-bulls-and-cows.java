class Solution {
    class Pair{
        int val;
        List<Integer> list;
        Pair(int val,List<Integer> list){
            this.val=val;
            this.list=list;
        }
    }
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        Map<Character,Pair> map = new HashMap<>();
        int length = guess.length();
        for(int i=0;i<length;i++){
            if(map.containsKey(secret.charAt(i))){
                Pair p = map.get(secret.charAt(i));
                p.val++;
                p.list.add(i);
            }
            else{
                map.put(secret.charAt(i),new Pair(1,new ArrayList<Integer>()));
                Pair p = map.get(secret.charAt(i));
                p.list.add(i);
            }
        }
     
        char[] ch = guess.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(map.containsKey(ch[i]) && map.get(ch[i]).list.contains(new Integer(i))){
                map.get(ch[i]).val--;
                ch[i]='-';
                A++;
            }
        }

        for(int i=0;i<ch.length;i++){
            if(ch[i] != '-' && map.containsKey(ch[i]) && map.get(ch[i]).val> 0){
                map.get(ch[i]).val--;
                B++;
            }
        }
        return A+"A"+B+"B";
    }
}
