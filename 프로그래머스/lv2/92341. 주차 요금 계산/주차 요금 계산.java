import java.util.HashMap;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();

        // 존재하는 모든 차 번호를 키로 맵에 넣는다. 값은 0으로 우선 고정해둔다
        for(int i = 0; i < records.length; i++){
            feeMap.put(records[i].split(" ")[1], 0);
        }

        // records를 하나씩 돌리며, 첫번째 배열 값을 infos에 공백기준 분리하여 집어넣는다.
        // 이제 하나에 대한 것들만 다루며 계산을 시작할거다.
        for(int i = 0; i < records.length; i++){
            String[] infos = records[i].split(" ");

            // 만약 map에 차 번호가 기존에 존재하면 맵에서 해당 차번호를 지우고, intime 배열에 시간과 분으로 집어넣는다.
            if(map.containsKey(infos[1])){
                String[] inTime = map.remove(infos[1]).split(":");
                // 검색했던 값 기준, outtime 배열에 시간과 분으로 집어넣는다.
                String[] outTime = infos[0].split(":");

                // intime과 outtime을 활용하여 시간과 분을 계산하여 도출한다.
                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

                // 계산한 시간,분 값을 feeMap에 존재하는 차번호 값을 기준으로 검색한 후 교체저장한다. (기존 값에 누적되어 저장되게 처리)
                feeMap.replace(infos[1], feeMap.get(infos[1]) + 60 * hour + minute);

            }
            // 만약 map 안에 차 번호가 존재하지 않을 시에는 차 번호, 시간을 집어넣는다.
            else{
                map.put(infos[1], infos[0]); // 차 번호, 시간
            }
        }
        
        // map에 아직 출차되지 않은 차가 있을 경우, 키(차 번호) 값 기준으로 반복문을 돌린다.
        for(String key : map.keySet()){
            // 키에 해당하는 값을 나눠 intime 배열에 담는다.
            String[] inTime = map.get(key).split(":");

            // 23:59분이라는 조건에 맞춰, 주차한 시간과 분을 구한다.
            int hour = 23 - Integer.parseInt(inTime[0]);
            int minute = 59 -Integer.parseInt(inTime[1]);

            // 키 값을 기준으로, feeMap에 저장되어 있는 값을 누적하여 교체저장한다.
            feeMap.replace(key, feeMap.get(key) + 60 * hour + minute);
        }

        // feeMap에 있는 값들을 List에 담는다.
        List<Map.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        // 키값(차번호)를 기준으로 오름차순 정렬한다.
        Collections.sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.getKey()) > Integer.parseInt(o2.getKey())?1 :
                    Integer.parseInt(o1.getKey()) < Integer.parseInt(o2.getKey())?-1 : 0;
        });

        
        answer = new int[list.size()];

        // 리스트의 값을 기준으로 기본시간을 초과하였는지 체크 후, 
        // 초과했다면 조건에 나와있는 계산식 실행, 아니라면 기본요금만 부과된 값을 answer 배열에 담는다.
        for(int i = 0; i < answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[i] = fees[1];
            }
        }

        return answer;
    }
}