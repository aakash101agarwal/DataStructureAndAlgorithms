public class NumberofSubarraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int res = 0;
        int evenCount = 1;
        int oddCount = 0;
        int sum = 0;
        for(int num : arr){
            sum += num;
            if(sum % 2 == 0){
                res += oddCount;
                evenCount++;
            }
            else{
                res += evenCount;
                oddCount++;
            }
            res = res % 1000000007;
        }
        return res;
    }

    public static void main(String args[]){
        int arr[] = {1,3,5};
        NumberofSubarraysWithOddSum solution = new NumberofSubarraysWithOddSum();
        System.out.println(solution.numOfSubarrays(arr));
    }
}
