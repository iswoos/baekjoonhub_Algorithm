class Solution {
    // 배달부분 : 최대한 다 싣고 끝에서 부터 지우면 됨.
    // 픽업부분 : 끝에서 부터 최대로 가져오면 됨.
    // 둘 중 어느 끝이 더 큰지 비교해서 (큰 인덱스+1)*2를 정답에 추가.
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        if(isAllZero(deliveries, pickups)) return 0;

        int deliveryLastIndex = getDeliveryLastIndex(deliveries);
        int pickupLastIndex = getDeliveryLastIndex(pickups);
        answer += 2*(Math.max(deliveryLastIndex,pickupLastIndex)+1);

        while(deliveryLastIndex >= 0 || pickupLastIndex >= 0) {
            deliveryLastIndex = delivery(deliveries,cap,deliveryLastIndex);
            pickupLastIndex = pickup(pickups,cap,pickupLastIndex);
            answer += 2*(Math.max(deliveryLastIndex,pickupLastIndex)+1);                 }

        return answer;
    }

    public int getDeliveryLastIndex(int[] deliveries){
        for(int i = deliveries.length - 1; i >= 0; i--) {
            if(deliveries[i] != 0) return i;
        }
        return 0;
    }

    public int getPickupLastIndex(int[] pickups){
        for(int i = pickups.length - 1; i >= 0; i--) {
            if(pickups[i] != 0) return i;
        }
        return 0;
    }

    public int delivery(int[] deliveries, int cap, int deliveryLastIndex) {
        for(int i = deliveryLastIndex; i >= 0; i--) {
            if(cap < 0) {
                return i;
            } else if(cap >= deliveries[i]) {
                cap -= deliveries[i];
                deliveries[i] = 0;
            } else {
                deliveries[i] -= cap;
                return i;
            }
        }
        return -1;
    }

    public int pickup(int[] pickups, int cap, int pickupLastIndex) {
        for(int i = pickupLastIndex; i >= 0; i--) {
            if(cap < 0){
                return i;
            } else if(cap >= pickups[i]) {
                cap -= pickups[i];
                pickups[i] = 0;
            } else {
                pickups[i] -= cap;
                return i;
            }
        }
        return -1;
    }

    public boolean isAllZero(int[] deliveries, int[] pickups) {
        return isAllDeliveriesZero(deliveries) && isAllPickupsZero(pickups);
    }

    public boolean isAllDeliveriesZero(int[] deliveries) {
        for(int i = 0; i < deliveries.length; i++) {
            if(deliveries[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAllPickupsZero(int[] pickups) {
        for(int i = 0; i < pickups.length; i++) {
            if(pickups[i] != 0) {
                return false;
            }
        }
        return true;
    }
}