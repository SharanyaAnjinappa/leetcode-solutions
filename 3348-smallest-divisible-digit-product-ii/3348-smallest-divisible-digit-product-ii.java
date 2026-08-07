class Solution {

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public String smallestNumber(String num, long t) {
        long temp = t;
        for (int i = 2; i <= 9; i++) {
            while (temp % i == 0) {
                temp /= i;
            }
        }
        if (temp > 1) {
            return "-1";
        }
        int n = num.length();
        long[] rem = new long[n + 1];
        rem[0] = t;
        int pos = n - 1;
        char[] arr = num.toCharArray();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                pos = i;
                break;
            }
            rem[i + 1] = rem[i] / gcd(rem[i], arr[i] - '0');
        }
        if (rem[n] == 1) {
            return num;
        }
        for (int i = pos; i >= 0; i--) {
            while (++arr[i] <= '9') {
                long tNow = rem[i] / gcd(rem[i], arr[i] - '0');
                int k = 9;
                for (int j = n - 1; j > i; j--) {
                    while (tNow % k != 0) {
                        k--;
                    }
                    tNow /= k;
                    arr[j] = (char) ('0' + k);
                }
                if (tNow == 1) {
                    return new String(arr);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (t > 1) {
            for (int i = 9; i > 1; i--) {
                while (t % i == 0) {
                    ans.append((char) ('0' + i));
                    t /= i;
                }
            }
            break;
        }
        int ones = Math.max(n + 1 - ans.length(), 0);
        for (int i = 0; i < ones; i++) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }
}