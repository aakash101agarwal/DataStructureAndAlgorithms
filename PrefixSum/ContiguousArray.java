class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int maxlength = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<nums.length; i++){
            count += (nums[i] == 0? -1 : 1);
            if(map.containsKey(count)){
                int value = map.get(count);
                maxlength = maxlength < i-value ? i-value : maxlength;
            }
            else{
                map.put(count, i);
            }
        }
        return maxlength;
    }

    public static void main(String args[]){
        int nums[] = {0,1,0,1,0,1};
        ContiguousArray solution = new ContiguousArray();
        System.out.println(solution.findMaxLength(nums));
    }
}