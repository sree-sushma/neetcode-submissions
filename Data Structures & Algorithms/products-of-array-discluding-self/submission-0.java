class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, 1);
        int prefix = 1;
        int suffix = 1;

        for (int i=0; i<n; i++) {
            res[i] = res[i] * prefix;
            prefix *= nums[i];
            int j = n-1-i;

            res[j] = res[j] * suffix;
            suffix *= nums[j];

        }

        


        
        
    
    return res;
    }
}  
