class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> res = new HashMap<>();
        
        for (Integer i: nums) {
            res.putIfAbsent(i,0);
            res.put(i,res.getOrDefault(i,0)+1);
        }

        System.out.println(res);

        List<Map.Entry<Integer,Integer>> listRes = new ArrayList<>(res.entrySet());

        listRes.sort((a,b) -> b.getValue().compareTo(a.getValue()));

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = listRes.get(i).getKey();
        }

        return result;  
        
    }
}
