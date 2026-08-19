import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int total4People = n * 2;
        HashMap<Integer, boolean[]> reserved = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];
            if (!reserved.containsKey(row)) {
                reserved.put(row, new boolean[3]);
            }
            if (seat >= 2 && seat <= 5) {
                reserved.get(row)[0] = true;
            }
            if (seat >= 4 && seat <= 7) {
                reserved.get(row)[1] = true;
            }
            if (seat >= 6 && seat <= 9) {
                reserved.get(row)[2] = true;
            }
        }
        for (boolean[] val : reserved.values()) {
            boolean left = val[0];
            boolean middle = val[1];
            boolean right = val[2];
            if (left && middle && right) {
                total4People -= 2;
            }
            else if (left && right) {
                total4People -= 1;
            }
            else if (left || right || middle) {
                total4People -= 1;
            }
        }

        return total4People;
    }
}