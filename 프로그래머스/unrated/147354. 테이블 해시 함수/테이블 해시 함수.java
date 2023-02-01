import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int[] sum = new int[data.length];
        int answer = 0;
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if (o1[col-1] != o2[col-1])
                    //오름차순 정렬
                    return o1[col-1] - o2[col-1]; 
                else
                    //내림차순 정렬
                    return o2[0] - o1[0]; 
            }
        });
        
        for (int i = row_begin-1; i < row_end; i++) {
            for (int j = 0; j < data[0].length; j++){
                sum[i]+=(data[i][j]%(i+1));
            }
            answer ^= sum[i];
        }
        
        return answer;
    }
}