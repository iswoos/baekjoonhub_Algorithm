class Solution {
    public String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        // 2명이니까 2명 배분할 값만 할당
        for (int i = 1; i < food.length; i++) {
            int foods = food[i] / 2;

            // 배분할 값의 수만큼 int[] food에 있는 값 StringBuilder에 append
            for (int j = 0; j < foods; j++) {
                sb.append(i);
            }
        }

//        String answer = sb.toString() + "0" + sb.reverse().toString();

        return answer +sb.toString() + "0" + sb.reverse().toString();
    }
}