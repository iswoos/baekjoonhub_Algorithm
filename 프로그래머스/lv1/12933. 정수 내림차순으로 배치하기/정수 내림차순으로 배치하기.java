import java.util.Arrays;

class Solution {
    public long solution(long n) {
        
        String num = String.valueOf(n);
        String strAnswer = "";
        
        char [] arr = new char[num.length()];
        for (int i = 0; i < num.length(); i++) {
        	arr[i] += num.charAt(i);
        }
        
        Arrays.sort(arr);
        for (int i = arr.length-1; i >= 0; i--) {
        	strAnswer += arr[i];
        }
        
        long answer = Long.parseLong(strAnswer);
        return answer;
    }
}