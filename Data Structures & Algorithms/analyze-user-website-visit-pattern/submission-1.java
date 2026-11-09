class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<int[]> arr = new ArrayList<>();
        int n = timestamp.length;

        for (int i = 0; i < n; i++) {
            arr.add(new int[] {timestamp[i], i});
            arr.sort((a, b) -> Integer.compare(a[0], b[0]));
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for (int[] a : arr) {
            int index = a[1];
            map.computeIfAbsent(username[index], k -> new ArrayList<>()).add(website[index]);
        }

        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (String user : map.keySet()) {
            List<String> cur = map.get(user);
            Set<String> patterns = new HashSet<>();
            for (int i = 0; i < cur.size(); i++) {
                for (int j = i + 1; j < cur.size(); j++) {
                    for (int k = j + 1; k < cur.size(); k++) {
                        patterns.add(cur.get(i) + "#" + cur.get(j) + "#" + cur.get(k));
                    }
                }
            }

            for (String p : patterns) {
                scoreMap.put(p, scoreMap.getOrDefault(p, 0) + 1);
            }
        }

        String res = "";
        int max_score = 0;
        for (String s : scoreMap.keySet()) {
            int score = scoreMap.get(s);
            if (score > max_score || score == max_score && s.compareTo(res) < 0) {
                max_score = score;
                res = s;
            }
        }

        return Arrays.asList(res.split("#"));
    }
}