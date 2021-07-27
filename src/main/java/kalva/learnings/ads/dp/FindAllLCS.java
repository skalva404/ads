package kalva.learnings.ads.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllLCS {

    public static Set<String> LCS(String X, String Y, int[][] T) {

        // fill lookup table
        LCSPath.LCSLength(X, Y, X.length(), Y.length(), T);
        // find all the longest common sequences
//        List<String> lcs = LongestCommonSubSeq(X, Y, X.length(), Y.length(), T);
        // since a list can contain duplicates, "convert" it to a set
        // and return
//        return new HashSet<>(lcs);

        return null;
    }

    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";
        int[][] T = new int[X.length() + 1][Y.length() + 1];
        Set<String> lcs = LCS(X, Y, T);
        System.out.print(lcs);
    }
}
