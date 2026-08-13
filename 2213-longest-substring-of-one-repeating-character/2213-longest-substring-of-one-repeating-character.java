class Solution {

    class Node {
        char leftChar, rightChar;
        int prefix, suffix, best, len;

        Node() {}

        Node(char c) {
            leftChar = rightChar = c;
            prefix = suffix = best = len = 1;
        }
    }

    Node[] tree;

    Node merge(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node res = new Node();

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.prefix = a.prefix;

        if (a.prefix == a.len &&
            a.rightChar == b.leftChar) {
            res.prefix = a.len + b.prefix;
        }

        res.suffix = b.suffix;

        if (b.suffix == b.len &&
            a.rightChar == b.leftChar) {
            res.suffix = b.len + a.suffix;
        }

        res.best = Math.max(a.best, b.best);

        if (a.rightChar == b.leftChar) {
            res.best = Math.max(
                res.best,
                a.suffix + b.prefix
            );
        }

        return res;
    }

    void build(int node, int l, int r, String s) {

        if (l == r) {
            tree[node] = new Node(s.charAt(l));
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    void update(int node, int l, int r,
                int index, char c) {

        if (l == r) {
            tree[node] = new Node(c);
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, r, index, c);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        tree = new Node[4 * n];

        build(1, 0, n - 1, s);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, c);

            ans[i] = tree[1].best;
        }

        return ans;
    }
}