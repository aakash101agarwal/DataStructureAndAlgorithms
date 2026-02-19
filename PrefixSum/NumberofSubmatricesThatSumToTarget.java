import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] sum = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int top = i>0? sum[i-1][j] : 0;
                int left = j>0? sum[i][j-1] : 0;
                int top_left = (i>0 && j>0)? sum[i-1][j-1] : 0;
                sum[i][j] = matrix[i][j] + top + left - top_left;
            }
        }

        for(int r1=0; r1<m; r1++){
            for(int r2=r1; r2<m; r2++){
                map.clear();
                map.put(0,1);
                for(int c=0; c<n; c++){
                    int curr_sum = sum[r2][c] - (r1>0? sum[r1-1][c] : 0);
                    result += map.getOrDefault(curr_sum-target,0);
                    map.put(curr_sum, map.getOrDefault(curr_sum,0)+1);
                }
            }
        }
        return result;
    }
}
