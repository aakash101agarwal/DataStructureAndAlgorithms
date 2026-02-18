import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int sum =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0 ;i<nums.length; i++){
            sum += nums[i];
            res += map.getOrDefault(sum-goal,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return res;
    }

    public static void main(String args[]){
        int nums[] = {1,0,1,0,1};
        int goal = 2;
        BinarySubarraysWithSum solution = new BinarySubarraysWithSum();
        System.out.println(solution.numSubarraysWithSum(nums, goal));
    }
}
