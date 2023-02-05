class Solution {
    public String solution(String number, int k) {
        StringBuilder ret = new StringBuilder();
        char max;
        int cur = 0;
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = cur; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    cur = j + 1;
                }
            }
            ret.append(max);
        }
        return ret.toString();
    }
}