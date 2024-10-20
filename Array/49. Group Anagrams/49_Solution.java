public List<List<String>> groupAnagrams(String[] strs) {

    // Key：由排序後的字串組成，表示該組 anagram 的唯一識別符。
    // Value：一個 List<String>，用來儲存所有對應該識別符的 anagram。
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // 對字符陣列排序，這樣相同字母組合的單詞會變成相同順序
        String key = new String(arr); // 排序後的字符陣列轉成字串作為 key

        List<String> list = map.getOrDefault(key, new ArrayList<>()); // 取得對應 key 的 list，若不存在則初始化
        list.add(s); // 將當前字串加入對應的 anagram 群組中
        map.put(key, list); // 將更新後的 list 放回 map 中
    }

    return new ArrayList<List<String>>(map.values()); // 將所有 anagram 群組的 list 回傳
}

// TC: O(n * k * log(k))
// n 是字串陣列的長度
// m 是每個字串的平均長度，排序每個字串需要 O(k * log(k))
// SC: O(n*k) 因為我們需要儲存每個字串及其對應的 anagram 分組