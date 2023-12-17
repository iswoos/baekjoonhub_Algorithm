import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 실패율을 구하기 위한 맵
        HashMap<Integer, Double> map = new HashMap();

        // 배열 리스트로 옮기기
        ArrayList<Integer> list = new ArrayList();
        for (int i : stages) {
            list.add(i);
        }

        // 스테이지 개수만큼 반복
        for (int i = 1; i <= N; i++) {
            int failpeople = 0;
            // 리스트의 사이즈
            int s = list.size();
            for (int j = 0; j < list.size(); j++) {
                //만약 스테이지 번호와 막혀있는 번호가 같으면
                if(i == list.get(j)) {
                    // 막혀있는 플레이어 숫자 구하기
                    failpeople = Collections.frequency(list, i);
                    // 계산된 플레이어 삭제
                    // removeAll의 매개변수는 Collections 객체여야함으로,
                    // 단 한개의 객체만 저장 가능한 컬렉션을 만들고 싶을 때
                    // Collections.singleton을 사용한다.
                    // Set객체 하나만 저장
                    // 예시 ) Collections.singleton(new TreeSet());
                    list.removeAll(Collections.singleton(list.get(j)));
                }
            }

            // 실패율 계산
            double fail = (double)failpeople / s;

            // 0 / 0 예외처리
            if (failpeople == 0) {
                fail = 0.0;
            }

            // 맵에 스테이지 정보와 실패율 추가
            map.put(i, fail);
        }


        System.out.println(map);

        // ArrayList 생성자에 적혀있는 map.keySet()은?
        // Key값이 저장된 Collection 객체이다.
        // >> [1,2,3,4,5]
        // map.values()였다면 value값이 저장된 Collection 객체이다
        // >> [0.125,0.4285,0.5,0.5,0.0]
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());

//       생성법 리스트
//        ArrayList<Integer> integers1 = new ArrayList<Integer>(); // 타입 지정
//        ArrayList<Integer> integers2 = new ArrayList<>(); // 타입 생략 가능
//        ArrayList<Integer> integers3 = new ArrayList<>(10); // 초기 용량(Capacity) 설정
//        ArrayList<Integer> integers4 = new ArrayList<>(integers1); // 다른 Collection값으로 초기화
//        ArrayList<Integer> integers5 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); // Arrays.asList()
//        ArrayList를 생성할 때 Set이나 다른 ArrayList를 전달하면 해당 Collections의 값들로 초기화됩니다.

        System.out.println(keyList);




        //keyList에서 값을 비교하여 정렬한다.
        Collections.sort(keyList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        System.out.println(keyList);

        // 맵의 키값 정답으로 출력
        for (int i=0; i<keyList.size(); i++) {
            answer[i] = keyList.get(i);
        }

        return answer;
    }
}