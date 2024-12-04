class Solution {

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            int maxWallet = getMaxInt(wallet);
            int minWallet = getMinInt(wallet);
            int maxBill = getMaxInt(bill);
            int minBill = getMinInt(bill);
            if (maxBill > maxWallet || minBill > minWallet) {
                if (bill[0] > bill[1]) {
                    bill[0] = bill[0] / 2;
                } else {
                    bill[1] = bill[1] / 2;
                }
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    private static int getMaxInt(int[] array) {
        int maxInt = Math.max(array[0], array[1]);
        return maxInt;
    }

    private static int getMinInt(int[] array) {
        int minInt = Math.min(array[0], array[1]);
        return minInt;
    }
}