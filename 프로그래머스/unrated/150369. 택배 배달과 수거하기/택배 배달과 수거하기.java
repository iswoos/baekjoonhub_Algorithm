class Solution {
    // 배달부분 : 최대한 다 싣고 끝에서 부터 지우면 됨.
    // 픽업부분 : 끝에서 부터 최대로 가져오면 됨.
    // 둘 중 어느 끝이 더 큰지 비교해서 (큰 인덱스+1)*2를 정답에 추가.
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 전부 다 0일 경우를 대비하여 예외처리 메소드 작성
        if(AllZero(deliveries, pickups)) return 0;

        
        // 배열 맨 뒤에 0이 아닌 값을 지니고 있는 인덱스로 변수지정
        int deliveryLastIndex = getDeliveryLastIndex(deliveries);
        int pickupLastIndex = getPickupLastIndex(pickups);
        answer += 2 * (Math.max(deliveryLastIndex,pickupLastIndex)+1);

        // 변수값 기준으로 조건문 실행
        // 리턴되는 인덱스를 기준으로 다시 조건문을 실행한다.
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
            } 
            // 인덱스값보다 cap이 클 경우 cap차감 후 인덱스값 0으로 수정
            else if(cap >= deliveries[i]) {
                cap -= deliveries[i];
                deliveries[i] = 0;
            } 
            // 인덱스값이 cap보다 클 경우 인덱스 값에 cap 차감 후 해당 인덱스 리턴
            else {
                deliveries[i] -= cap;
                return i;
            }
        }

        // 전부 아무 이상없이 차감이 진행되었을 경우는 모든 처리가 완료되었음을 의미, -1을 리턴 (아무 곳에도 쓰지않을 숫자임)
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

    public boolean AllZero(int[] deliveries, int[] pickups) {
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
