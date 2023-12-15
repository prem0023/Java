class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        
        for(List<String> list : paths){
            set.add(list.get(0));
        }
        
        for(List<String> list : paths){
            if(set.add(list.get(1)))
                return list.get(1);
        }
        
        return "-1";
    }
}