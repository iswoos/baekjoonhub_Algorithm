class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 각 배열의 최대공약수 구하기
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 각 최대공약수가 반대편 배열을 나눌 수 없는지에 대한 체크
        // gcd와 동일하게 외부 메소드로 추출하여 가독성 증가시킴
        if (notDivisble(arrayB, gcdA)) {
            if (answer < gcdA) {
                answer = gcdA;
            }
        }
        if (notDivisble(arrayA, gcdB)) {
            if (answer < gcdB) {
                answer = gcdB;
            }
        }

        return answer;
    }

    // 이거는 거의 공식이나 다름없음. 이해를 못하겠으면 외우기라도하자!
    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    // 별도로 추출한 조건성립 여부확인 메소드
    private boolean notDivisble(int[] arr, int num) {
        for (int i : arr) {
            if (i % num == 0) {
                return false;
            }
        }
        return true;
    }
}