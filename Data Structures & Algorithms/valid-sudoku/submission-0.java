class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int boardSize = 9;
        final Set<Character>[] rows = new HashSet[boardSize];
        final Set<Character>[] cols = new HashSet[boardSize];
        final Set<Character>[] grids = new HashSet[boardSize];

        for(int i=0; i<boardSize; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for(int row=0; row<boardSize; row++) {
            for(int col=0; col<boardSize; col++) {
                final char item = board[row][col];
                if(item == '.') {
                    continue;
                }
                
                final int grid = (row/3) * 3 + (col/3);

                if(!rows[row].add(item) || !cols[col].add(item) || !grids[grid].add(item)) {
                    return false;
                }
            }
        }

        return true;
    }
}
