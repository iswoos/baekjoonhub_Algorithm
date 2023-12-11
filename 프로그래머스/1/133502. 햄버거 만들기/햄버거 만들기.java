import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        ArrayList<Integer> making = new ArrayList();
        
        for (int i=0; i<ingredient.length; i++) {
        	making.add(ingredient[i]);
        	if (making.size()>3 && 
        			making.get(making.size()-4)==1 &&
        			making.get(making.size()-3)==2 &&
        			making.get(making.size()-2)==3 &&
        			making.get(making.size()-1)==1) {
        		answer++;
        		for(int j=0; j<4; j++) {
        			making.remove(making.size()-1);
        		}
        	}
        }
        
        return answer;
    }
}