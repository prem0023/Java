class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1);

        for(int i=1; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<=i; j++){
                int value = 0;
                if(j-1 >= 0){
                    value += pascalTriangle.get(i-1).get(j-1);
                }
                if(j < i){
                    value += pascalTriangle.get(i-1).get(j);
                }
                list.add(value);
            }
            pascalTriangle.add(list);
        }
        return pascalTriangle;
    }
}
// 1
// 1 1
// 1 