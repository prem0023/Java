class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new LinkedHashSet<>();
        Set<Integer> column = new LinkedHashSet<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for(int r : row){
            for(int j=0; j<matrix[0].length; j++){
                matrix[r][j] = 0;
            }
        }

        for(int c : column){
            for(int i=0; i<matrix.length; i++){
                matrix[i][c] = 0;
            }
        }
    }
}