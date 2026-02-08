class RangeQuerySum{
    int arr[];
    public RangeQuerySum(int[] nums) {
        int len = nums.length;
        arr = new int[len];
        arr[0] = nums[0];
        for(int i=1; i<len; i++){
            arr[i] = arr[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0){
            return arr[right];
        }
        return arr[right] - arr[left-1];
    }

    public static void main(String args[]){
        int nums[] = {-2, 0, 3, -5, 2, -1};
        RangeQuerySum rangeQuerySum = new RangeQuerySum(nums);
        System.out.println(rangeQuerySum.sumRange(0,4));
        System.out.println(rangeQuerySum.sumRange(2,4));
        System.out.println(rangeQuerySum.sumRange(1,5));
    }
}