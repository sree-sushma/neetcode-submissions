class Solution {
    public String encode(List<String> strs) {
        String encodedS = new String();
        for (int i = 0; i < strs.size(); i++) {
            String substring = strs.get(i);
            encodedS += substring.length() + "#" + substring;
        }
        return encodedS;
    }

    public List<String> decode(String str) {
        List<String> decodedS = new ArrayList<>();
int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str.substring(i, j));
            decodedS.add(str.substring(j+1, j + 1 + len));
            i = 1 + j + len;
        }

        return decodedS;
    }
}
