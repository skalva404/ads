package kalva.learnings.ads.againdp;

import kalva.learnings.ads.Utils;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubSeq {

    static String s1 = "AGTGATG";
    static String s2 = "GTTAG";
    //  Output: GTAG, GTTG

    private static int rLCS(String a, String b, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (a.charAt(m) == b.charAt(n)) {
            return 1 + rLCS(a, b, m - 1, n - 1);
        }
        return Math.max(rLCS(a, b, m, n - 1), rLCS(a, b, m - 1, n));
    }

    private static int[][] prepareDPTable(String s1, String s2) {
        int[][] retTable = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    retTable[i][j] = 1 + retTable[i - 1][j - 1];
                } else {
                    retTable[i][j] = Math.max(retTable[i - 1][j], retTable[i][j - 1]);
                }
            }
        }
        return retTable;
    }

    private static Set<String> getAllLCSStrinings(int[][] dp, String fst, String snd, int i, int j) {
        Set<String> lcss = new HashSet<>();
//        System.out.println(i + " " + j);
        if (i == 0 || j == 0) {
            lcss.add("");
        } else if (fst.charAt(i - 1) == snd.charAt(j - 1)) {
            for (String lcs : getAllLCSStrinings(dp, fst, snd, i - 1, j - 1)) {
                lcss.add(lcs + fst.charAt(i - 1));
            }
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                lcss.addAll(getAllLCSStrinings(dp, fst, snd, i - 1, j));
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                lcss.addAll(getAllLCSStrinings(dp, fst, snd, i, j - 1));
            }
        }
        return lcss;
    }

    private static String getLCSString(String s1, String s2, int m, int n, int[][] dpTable) {
        if (m == 0 || n == 0) {
            return "";
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return getLCSString(s1, s2, m - 1, n - 1, dpTable) + s1.charAt(m - 1);
        }
        if (dpTable[m - 1][n] > dpTable[m][n - 1]) {
            return getLCSString(s1, s2, m - 1, n, dpTable);
        } else {
            return getLCSString(s1, s2, m, n - 1, dpTable);
        }
    }

    public static void main(String[] args) {

        int[][] dpTable = prepareDPTable(s1, s2);
        Utils.printArray(dpTable, s1, s2);

//        System.out.println(rLCS(s1, s2, s1.length() - 1, s2.length() - 1));

        System.out.println(getLCSString(s1, s2, s1.length(), s2.length(), dpTable));
        System.out.println(getAllLCSStrinings(dpTable, s1, s2, s1.length(), s2.length()));
    }
}

//    private static String rLCS(int[][] dp, String fst, String snd, int i, int j) {
//        String lcss = "";
//
//        if (i == 0 || j == 0) {
//            lcss = "";
//        } else if (fst.charAt(i - 1) == snd.charAt(j - 1)) {
//            lcss = fst.charAt(i - 1) + lcss;
//            rLCS(dp, fst, snd, i - 1, j - 1);
//        } else {
//            if (dp[i - 1][j] >= dp[i][j - 1]) {
//                lcss = fst.charAt(i - 1) + lcss;
//                rLCS(dp, fst, snd, i - 1, j);
//            }
//            if (dp[i][j - 1] >= dp[i - 1][j]) {
//                lcss = fst.charAt(i - 1) + lcss;
//                rLCS(dp, fst, snd, i, j - 1);
//            }
//        }
//        return lcss;
//    }
