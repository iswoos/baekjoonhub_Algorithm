class Solution {
    public String solution(String s, int n) {
        String answer = "";

        //아스키코드를 써보려했지만, 90 = Z 91=[ 인 관계로 부적합하다고 판단!
        // 그냥 배열을 만들어서 거기서 돌리는 게 가장 낫겠다고 생각했다.
        // 정정! char를 사용해서 아스키코드를 돌리는 게 배열을 무식하게 만드는 것보다 낫다고 생각한다.


        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==' '){
                answer += ch;
                continue;
            }

            if(ch>='a' && ch<='z'){
                if(ch+n > 'z'){
                    answer += (char)(ch+n-26);
                } else{
                    answer += (char)(ch+n);
                }
            }

            if(ch>='A' && ch<='Z'){
                if(ch+n > 'Z'){
                    answer += (char)(ch+n-26);
                } else{
                    answer += (char)(ch+n);
                }
            }
        }

        return answer;
    }
}