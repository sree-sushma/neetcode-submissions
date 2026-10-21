class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        int[] output = new int[2];
        for (int i=0; i<nums.length; i++)
        {
            int diff = target - nums[i];
            System.out.println(diff);
            if(diffMap.containsKey(diff)) {
                output[0] = diffMap.get(diff);
                output[1] = i;
                return output;
                
            }
           diffMap.put(nums[i],i);
        }
        return output;

    }
}
