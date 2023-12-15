class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        
        for(List<String> list : paths){
            set.add(list.get(0));
        }
        
        for(List<String> list : paths){
            String dest = list.get(1);
            if(set.add(dest))
                return dest;
        }
        
        return "-1";
    }
}