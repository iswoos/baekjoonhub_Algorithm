class Solution {
    public int solution(String[] board) {

/*        규칙을 지키지않은 상황
        1. O보다 X의 개수가 많을 경우 (O가 선공을 하지못하게됨)
        2. O가 X보다 2개 이상 많을 경우 (O가 번갈아 두지않고 한번 더 둠)
        3. O가 우승할 때 O와 X의 개수가 동일한 상황 (O 우승 후 X가 한번 더 둠)
        4. X가 우승할 때 O가 1개 더 많은 상황 (X 우승 후 O가 한번 더 둠)
*/

        int Ocnt = 0;
        int Xcnt = 0;

        for (int i = 0; i < board.length; i++) {
            Ocnt += boardCheck(board[i], 'O');
            Xcnt += boardCheck(board[i], 'X');
        }

        if (Ocnt < Xcnt) {
            return 0;
        }

        if (Ocnt > Xcnt + 1) {
            return 0;
        }

        if (gameWin(board, 'O')) {
            if (Ocnt == Xcnt) {
                return 0;
            }
        }

        if (gameWin(board, 'X')) {
            if (Ocnt  == Xcnt + 1) {
                return 0;
            }
        }
        return 1;
    }

    private int boardCheck(String str, char o) {
        return str.length() - str.replace(String.valueOf(o), "").length();
    }

    private boolean gameWin(String[] board, char o) {
        // 가로직선 검사
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == o &&
                board[i].charAt(1) == o &&
                board[i].charAt(2) == o
            ) {return true;}
        }
        // 세로직선 검사
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == o &&
                    board[1].charAt(i) == o &&
                    board[2].charAt(i) == o
            ) {return true;}
        }

        //대각선 검사
        if (board[0].charAt(0) == o
                && board[1].charAt(1) == o
                && board[2].charAt(2) == o) {
            return true;
        }
        if (board[0].charAt(2) == o
                && board[1].charAt(1) == o
                && board[2].charAt(0) == o) {
            return true;
        }
        return false;
    }
}