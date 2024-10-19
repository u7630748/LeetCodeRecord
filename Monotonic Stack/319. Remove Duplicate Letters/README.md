# [316. Remove Duplicate Letters](https://leetcode.cn/problems/remove-duplicate-letters)
#### same question - [1081. Smallest Subsequence of Distinct Characters](https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters)

<span style="color:orange">Level: Medium</span>

Given a string `s`, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.


**Example 1:**
```
Input: s = "bcabc"
Output: "abc"
```

**Example 2:**
```
Input: s = "cbacdcbc"
Output: "acdb"
```

**Constraints:**

* 1 <= s.length <= 10<sup>4</sup>
* `s` consists of lowercase English letters.


### 解題思路

這道題的目標是從一個字串 `s` 中移除重複字母，使每個字母只出現一次，並且保證結果字串的字典序最小。 \
為了實現這一點，我們需要利用一些數據結構來維持結果的順序，並確保結果符合條件。

#### 解題步驟：

1. **<span style="color: #FF6347;">記錄字母出現次數</span>**：  
   我們首先建立一個大小為 256 的陣列 `chCount`，記錄字串 `s` 中每個字母的出現次數。

   ```java
   for (char c : s.toCharArray()) {
       chCount[c]++;
   }
   ```
這樣我們知道每個字母在字串中出現的總次數。

2. <span style="color: #4682B4;">使用雙端隊列 deque 和集合 set</span>：
    - `deque`：用來維持結果字串中的字母，且這些字母的順序會是字典序中最小的。它是一個單調遞增的結構，從隊列底到頂，字母的順序按照字典序遞增。
    - `set`：用來記錄已經在結果中出現過的字母，避免重複加入。

3. <span style="color: #32CD32;">遍歷字串，進行字母處理</span>：
    - 每當遇到一個新字母時，如果它已經在 `deque` 裡，我們跳過，因為每個字母只能出現一次。
    - 如果新字母比 `deque` 的尾部字母小，並且尾部字母在後續字串中還會出現，則移除尾部字母，這樣可以保證字典序最小化。
    - 將當前字母加入 `deque` 並更新 `set`。

4. <span style="color: #8A2BE2;">生成結果</span>：  
   最後，我們將 `deque` 裡的所有字母連接成一個字串，並返回它作為最終結果。

#### 程式碼範例

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        //1. 記錄每個字母的出現次數
        int[] chCount = new int[256];
        for (char c : s.toCharArray()) {
            chCount[c]++;
        }

        // 用來存放最終結果的字母的雙端隊列
        Deque<Character> deque = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();

        //2. 遍歷每個字母
        for (char c : s.toCharArray()) {
            chCount[c]--; // 當前字母的剩餘出現次數 -1
            if (set.contains(c)) {
                continue; // 如果字母已經在結果中，跳過
            }

            //3. 維持單調遞增的字典序
            while (!deque.isEmpty() && deque.peekLast() > c && chCount[deque.peekLast()] > 0) {
                set.remove(deque.removeLast()); // 移除不符合條件的字母
            }

            // 將當前字母加入隊列並記錄
            deque.addLast(c);
            set.add(c);
        }

        //4. 組合最終結果
        StringBuilder result = new StringBuilder();
        for (char c : deque) {
            result.append(c);
        }
        return result.toString();
    }
}
```

---

### 雙端隊列 `deque` 的作用：

在這個解法中，`deque` 用來儲存最終結果的字母，並且其特性是維持單調遞增順序（字母的字典序從小到大）。使用 `deque` 可以方便地從兩端操作字母：

- <span style="color: #FF4500;">從尾部移除字母</span>：當發現當前字母比 `deque` 尾部的字母字典序更小，而且尾部字母後續還會出現時，我們可以移除尾部字母，從而使得結果字串更小。
- <span style="color: #00CED1;">從尾部加入字母</span>：每次確保新的字母能夠符合字典序要求後，將其加入 `deque` 的尾部。

---

### 時間複雜度：

- **遍歷字串**：我們需要遍歷字串一次，這是 `O(n)` 的操作。
- **每個字母的插入/刪除操作**：每個字母最多只會被加入 `deque` 一次，並且最多只會被移除一次。由於 `deque` 的操作都是常數時間 `O(1)`，所以這部分的總操作也是 `O(n)`。
- 因此，總的 **時間複雜度** 為 `O(n)`，其中 `n` 是字串 `s` 的長度。

### 空間複雜度：

- 我們使用了大小為 256 的陣列 `chCount`，這個大小是固定的，與輸入長度無關。
- `deque` 和 `set` 的大小最多為字母數量，也就是 `O(n)`。
- 因此， **空間複雜度** 為 `O(n)`。