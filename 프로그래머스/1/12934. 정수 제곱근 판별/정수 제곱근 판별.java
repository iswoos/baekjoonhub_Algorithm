class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long a = 0;

        while(a<=n){
            a++;
            if(a*a==n){
             answer = (a+1)*(a+1);
             break;
            } else{
                answer = -1;
                }
    }
        return answer;
    }
}