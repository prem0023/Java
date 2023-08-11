class Solution {
    public void solveSudoku(char[][] board) {
        int row = 0, col = 0;
        
        while(row < 9 && board[row][col] != '.'){
            row = (col+1) / 9 + row % 9;
            col = (col+1) % 9;
        }
        
        helper(board, row, col);
    }
    
    private boolean helper(char[][] board, int row, int col){
        if(row == 9 || col == 9)
            return true;
        
        for(int num=1; num<=9; num++){
            if(!isValidPlace(board, row, col, num))
                continue;
            
            board[row][col] = (char)('0' + num);
            int r = row, c = col;
            
            while(r < 9 && board[r][c] != '.'){
                r = (c+1) / 9 + r % 9;
                c = (c+1) % 9;
            }
            
            boolean flag = helper(board, r, c);
            
            if(flag)
                return true;
            
            board[row][col] = '.';
        }
        
        return false;
    }
    
    private boolean isValidPlace(char[][] board, int row, int col, int num){
        char ch = (char)(num + '0');
        
        int newRow = 3 * (row/3);
        int newCol = 3 * (col/3);
        
        for(int i=0; i<9; i++){
            if(board[i][col] == ch && i != row)
                return false;
        }
        for(int j=0; j<9; j++){
            if(board[row][j] == ch && j != col)
                return false;
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[newRow+i][newCol+j] == ch && (i+newRow != row || j+newCol != col))
                    return false;
            }
        }
        
        return true;
    }
}