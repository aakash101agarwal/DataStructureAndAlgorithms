import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        for(int i=1; i<=nums.length; i++){
            sum += nums[i-1];
            int modValue = sum%k;
            if(map.containsKey(modValue)){
                if(i - map.get(modValue) > 1)
                    return true;
            }
            else{
                map.put(modValue, i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {23, 2, 4, 6, 7};
        int k = 6;
        ContinuousSubarraySum solution = new ContinuousSubarraySum();
        System.out.println(solution.checkSubarraySum(nums, k));
    }
}
