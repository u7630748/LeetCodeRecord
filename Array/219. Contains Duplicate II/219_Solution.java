public boolean contains(int[] nums, int k) {
    // map 會儲存數字及其對應的索引
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        // 1. map.containsKey(nums[i])：確認這個數字是否已經出現在 map 中
        // 2. 如果這個數字已經出現過，檢查其對應的索引與目前索引的差距是否小於等於 k
        if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
            return true;
        }
        map.add(nums[i], i);
    }

    return false;
}