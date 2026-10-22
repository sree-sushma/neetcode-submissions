class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        HashMap<List<Integer>, HashSet<String>> seenb = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String current = String.valueOf(board[i][j]);
                if (!(current.equals("."))) {
                    if (!seen.add(current + "row" + i) || !seen.add(current + "column" + j)) {
                        return false;
                    }

                    seenb.putIfAbsent(Arrays.asList(i / 3, j / 3), new HashSet<>());
                    if (!seenb.get(Arrays.asList(i / 3, j / 3)).add(current)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
