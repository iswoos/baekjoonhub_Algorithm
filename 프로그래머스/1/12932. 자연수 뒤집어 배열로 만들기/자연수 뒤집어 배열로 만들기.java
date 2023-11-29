import java.util.ArrayList;

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        long a = 0;

        while(n!=0){
            a = n%10;
            n/=10;
            list.add((int)a);
        }

        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}