class Solution {
    public boolean isPathCrossing(String path) {
        HashMap<String, Boolean> map = new HashMap<>();
        int n = 0, e = 0;
        
        map.put(n + " " + e, true);
        // System.out.println(n + " " + e);
        
        for(int i=0; i<path.length(); i++){
            switch(path.charAt(i)){
                case 'N':
                    n++;
                    break;
                    
                case 'S':
                    n--;
                    break;
                    
                case 'E':
                    e++;
                    break;
                    
                case 'W':
                    e--;
                    break;
                    
                default:
                    break;
            }
            // System.out.println(n + " " + e);
            
            if(map.containsKey(n + " " + e))
                return true;
            
            map.put(n + " " + e, true);
        }
        
        return false;
    }
}