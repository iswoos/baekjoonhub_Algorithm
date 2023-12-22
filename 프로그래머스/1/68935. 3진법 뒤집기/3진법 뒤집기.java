import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";

        String[] a = Integer.toString(n,3).split("");

        ArrayList<String> lists = new ArrayList<>();
        for(String list:a) {
            lists.add(list);
        }
        Collections.reverse(lists);

        for(String list:lists){
            str += list;
        }

        return answer = Integer.parseInt(str,3);
        
    }
}