class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        for (int mat : mats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[i].length; j++) {
                    if (park[i][j].equals("-1")) {
                        if (AddMatch(i, j, mat, park)) {
                            answer = Math.max(answer, mat);
                        }
                    }
                }
            }
        }
        return answer;
    }

    private boolean AddMatch(int x, int y, int answer, String[][] park) {
        if (x + answer - 1 >= park.length || y + answer - 1 >= park[x].length) {
            return false;
        }

        for (int i = 0; i < answer; i++) {
            for (int j = 0; j < answer; j++) {
                String isMatLocation = park[x + i][y + j];
                if (!isMatLocation.equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}