
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

int sum = 0;

public List<List<Integer>> combinationSum3(int k, int n) {
    backtracking(1, k, n);
}

private void backtracking(int ind, int k, int n) {
    if (path.size() == k && sum == n) {
        ans.add(new ArrayList<>(path));
        return;
    }

    if (sum > n) {
        return;
    }

    if (path.size() > k) {
        return;
    }

    for (int i = ind; i <= 9; i++) {
        path.add(i);
        sum += i;
        backtracking(i+1, k, n);
        path.remove(path.size() - 1);
        sum -= i;
    }
}