class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;

        int[] res = new int[2];
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            while (numbers[i] + numbers[right] > target) {
                right--;
            }

            if (numbers[i] + numbers[right] == target) {
                return new int[] {i + 1, right + 1};
            }
        }
        throw new IllegalArgumentException("No solution found");
    }
}
