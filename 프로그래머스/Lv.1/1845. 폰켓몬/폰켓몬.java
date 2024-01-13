import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length/2;


        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        if(set.size()<pick){
            answer = set.size();
        } else{
            answer = pick;
        }


        return answer;
    }
}