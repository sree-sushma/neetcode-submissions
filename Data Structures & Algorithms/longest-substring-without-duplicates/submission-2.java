class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;

        int n = s.length();

        HashSet<Character> subs = new HashSet<>();

        for (int right = 0; right < n; right++) {
            int length = 0;

            while (subs.contains(s.charAt(right))) {
                subs.remove(s.charAt(left));
                left++;
            }

            subs.add(s.charAt(right));

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
