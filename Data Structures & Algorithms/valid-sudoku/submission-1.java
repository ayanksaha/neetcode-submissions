class Solution {
    public boolean isValidSudoku(char[][] board) {
        final Map<Integer, Set<Integer>> rows = new HashMap<>(9);
        final Map<Integer, Set<Integer>> cols = new HashMap<>(9);
        final Map<Integer, Set<Integer>> boxes = new HashMap<>(9);

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                final char item = board[i][j];
                if (item == '.') {
                    continue;
                }

                final int num = Character.getNumericValue(item);
                final Set<Integer> rowSet = rows.getOrDefault(i, new HashSet<>(9));
                final Set<Integer> colSet = cols.getOrDefault(j, new HashSet<>(9));
                
                final int boxIdx = getBox(i, j);
                final Set<Integer> boxesSet = boxes.getOrDefault(boxIdx, new HashSet<>(9));

                if(!rowSet.add(num) || !colSet.add(num) || !boxesSet.add(num)) {
                    return false;
                }

                rows.put(i, rowSet);
                cols.put(j, colSet);
                boxes.put(boxIdx, boxesSet);
            }
        }

        return true;
    }

    private int getBox(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }
}
