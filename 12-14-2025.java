class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                mat[i][j] += mat[i - 1][j];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(queries.length);

        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            int sum = mat[r2][c2];
            if (r1 > 0) sum -= mat[r1 - 1][c2];
            if (c1 > 0) sum -= mat[r2][c1 - 1];
            if (r1 > 0 && c1 > 0) sum += mat[r1 - 1][c1 - 1];

            ans.add(sum);
        }

        return ans;
    }
}
