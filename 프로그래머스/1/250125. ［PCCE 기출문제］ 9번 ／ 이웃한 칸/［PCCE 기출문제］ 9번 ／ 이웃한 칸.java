class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        int maxHeighAndWidth = board.length;
        String searchColor = board[h][w];

        int[] checkHeigh = {0, 1, -1, 0};
        int[] checkWidth = {1, 0, 0, -1};

        for (int i = 0; i < 4; i++) {
            int checkHeighValue = h + checkHeigh[i];
            int checkWidthValue = w + checkWidth[i];

            if (checkHeighValue >= 0 && checkHeighValue < maxHeighAndWidth && checkWidthValue >= 0 && checkWidthValue < maxHeighAndWidth) {
                if (searchColor.equals(board[checkHeighValue][checkWidthValue])) {
                    count++;
                }
            }
        }

        return count;
    }
}