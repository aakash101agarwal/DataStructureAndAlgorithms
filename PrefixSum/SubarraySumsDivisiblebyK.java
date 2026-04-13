import java.util.HashMap;
import java.util.Map;

class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        int result = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int modValue = ((sum % k) + k) % k;
            if(map.containsKey(modValue))
                result += map.get(modValue);
            map.put(modValue, map.getOrDefault(modValue, 0) + 1);
        }
        return result;
    }

    public static void main(String args[]){
        int nums[] = {4,5,0,-2,-3,1};
        int k = 5;
        SubarraySumsDivisiblebyK solution = new SubarraySumsDivisiblebyK();
        System.out.println(solution.subarraysDivByK(nums, k));
    }
}
