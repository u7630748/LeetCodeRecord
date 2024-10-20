class Solution {
    public boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] check = new int[26]; // 建立一個大小為 26 的整數陣列，用於記錄每個字母的出現次數
        for (int i = 0; i < s.length(); i++) {
            check[s.charAt(i) - 'a']++;
            check[t.charAt(i) - 't']--;
        }

        for (int i = 0; i < 26; i++) {
            if (check[i] != 0) return false; // 若有任何一個字母的次數不為 0，則兩字串不是異位詞
        }

        return true;
    }
}