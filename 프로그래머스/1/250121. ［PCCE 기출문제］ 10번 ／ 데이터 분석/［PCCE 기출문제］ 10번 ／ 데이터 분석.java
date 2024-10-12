import java.util.*;


class Solution {
    static Map<String, Integer> dataC = new HashMap<>();

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> filteredData = new ArrayList<>();
        setDataCMap();
        filterProcess(data, ext, val_ext, filteredData);
        sortProcess(sort_by, filteredData);
        return convertToArrayProcess(filteredData);
    }

    private void filterProcess(int[][] data, String ext, int val_ext, List<int[]> filteredData) {
        for (int[] datum : data) {
            if (datum[dataC.get(ext)] < val_ext) {
                filteredData.add(datum);
            }
        }
    }

    private void sortProcess(String sort_by, List<int[]> filteredData) {
        filteredData.sort(Comparator.comparingInt(d -> d[dataC.get(sort_by)]));
    }

    private int[][] convertToArrayProcess(List<int[]> filteredData) {
        return filteredData.toArray(new int[0][0]);
    }

    public void setDataCMap() {
        dataC.put("code", 0);
        dataC.put("date", 1);
        dataC.put("maximum", 2);
        dataC.put("remain", 3);
    }
}