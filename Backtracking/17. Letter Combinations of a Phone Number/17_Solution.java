String[] mapping = new String[]{ // 0 - 9 mapping of digits and letters
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
}

List<String> list = new ArrayList<>();

StringBuilder temp = new StringBuilder(); // 用來暫存當前組合的字串

public List<String> letterCombinations(String digits) {
    if (digits.length() == 0 || digits == null) { // 若輸入為空，直接回傳空結果
        return list;
    }

    backtracking(0, digits); // 從第0個數字開始遞迴
    return list;
}

private void backtracking(int num, String digits){
    if (num == digits.length()) { // 當遞迴到最底層時（全部數字處理完畢）
        list.add(temp.toString());
        return;
    }

    // e.g. "2" --> "abc" --> "ad", "ae", "af",
    String str = mapping[digits.charAt(i) - '0']; // 將數字轉為對應的字母串

    for (int i = 0; i < str.length(); i++) {
        temp.add(str.charAt(i));
        backtracking(num + 1, digits);
        temp.deleteCharAt(temp.length() - 1);
    }
}