package kalva.learnings.ads.dp;

import java.util.HashMap;
import java.util.Map;

public class LCSLength {

    static String s1 = "ABCBDAB";
    static String s2 = "BDCABA";

    private static Map<String, Integer> simple = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(lcsSimple());
        System.out.println(lcsRecurssion(0, 0));
        System.out.println(lcsDP(s1.length() - 1, s2.length() - 1));
    }

    private static int lcsDP(int m, int n) {
        if (0 > m || 0 > n) {
            return 0;
        }
        String key = m + "|" + n;
        if (!simple.containsKey(key)) {
            if (s1.charAt(m) == s2.charAt(n)) {
                simple.put(key, lcsDP(m - 1, n - 1) + 1);
            } else {
                simple.put(key, Integer.max(lcsDP(m - 1, n), lcsDP(m, n - 1)));
            }
        }
        return simple.get(key);
    }

    private static int lcsRecurssion(int m, int n) {
        if (m >= s1.length() || n >= s2.length()) {
            return 0;
        }
        if (s1.charAt(m) == s2.charAt(n)) {
            return 1 + lcsRecurssion(m + 1, n + 1);
        }
        return Integer.max(lcsRecurssion(m + 1, n), lcsRecurssion(m, n + 1));
    }

    private static int lcsSimple() {

        int finalValue = Integer.MIN_VALUE;
        for (int i = s2.length() - 1; i >= 0; i--) {
            int length = getLength(i, 0, 0);
            finalValue = Math.max(finalValue, length);
        }
        return finalValue;
    }

    private static Integer getLength(int s2Index, int s1Index, int length) {
        if (s2Index >= s2.length()) {
            return length;
        }
        int found = found(s1, s2.charAt(s2Index), s1Index);
        if (0 <= found) {
            length++;
        } else {
            return length;
        }
        s1Index = Math.max(s1Index, found + 1);
        return getLength(s2Index + 1, s1Index, length);
    }

    private static int found(String s1, char c, int index) {
        if (index > s1.length() - 1) {
            return -1;
        }
        for (int i = index; i < s1.length(); i++) {
            if (c == s1.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
