// 986. Interval List Intersections
// https://leetcode.com/problems/interval-list-intersections/


class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> ans = new ArrayList<>();
        
        int i = 0, j = 0;
            
        while (i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            
            if (low <= high) {
                ans.add(new int[]{low, high});
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}
