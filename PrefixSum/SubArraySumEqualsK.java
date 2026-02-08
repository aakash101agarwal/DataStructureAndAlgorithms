import java.util.HashMap;
import java.util.Map;

class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String args[]){
        int nums[] = {3,4,7,2,-3,1,4,2};
        int k = 7;
        SubArraySumEqualsK solution = new SubArraySumEqualsK();
        System.out.println(solution.subarraySum(nums, k));
    }
}