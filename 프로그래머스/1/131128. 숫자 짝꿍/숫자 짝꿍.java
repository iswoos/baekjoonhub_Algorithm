class Solution {
    public String solution(String X, String Y) {

        StringBuilder sb = new StringBuilder();

        // 각 자리수별로 몇개 있는지 체크할 용도의 배열생성
        int[] arrx = new int[10];
        int[] arry = new int[10];

        // 외부메소드로 각 자리수별 개수 세기 기능생성
        countArr(X, arrx);
        countArr(Y, arry);

        // 가장 큰 정수를 뽑아야하니, 뒤쪽부터 반복문 진행
        for (int i = arrx.length - 1; i >= 0; i--) {
            // 각 자리수의 값이 x,y 모두 0이상일 경우 StringBuilder에 추가한 뒤 해당 자리수 개수값 -1 차감진행
            while (arrx[i] > 0 && arry[i] > 0) {
                arrx[i]--;
                arry[i]--;
                sb.append(i);
            }
        }

        if (sb.toString().equals("")) {
            return "-1";
        } else if (sb.charAt(0) == '0') {
            return "0";
        } else return sb.toString();
    }

    // 숫자별로 배열값 +1씩 증가
    private void countArr(String str, int[] arr) {
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0';
            arr[index]++;
        }
    }
}