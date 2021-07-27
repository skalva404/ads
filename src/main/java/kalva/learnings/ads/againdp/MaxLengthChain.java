package kalva.learnings.ads.againdp;

import edu.emory.mathcs.backport.java.util.Collections;

import java.util.Arrays;
import java.util.List;

import static kalva.learnings.ads.againdp.LIS_Bridge.Point;

public class MaxLengthChain {

    static int maxLengthChain(List<Point> data) {

        int[] dp = new int[data.size()];
        Arrays.fill(dp, 1);
        Collections.sort(data, (o1, o2) -> {
            if (((Point) o1).south == ((Point) o2).south) {
                return ((Point) o1).north - ((Point) o2).north;
            } else {
                return ((Point) o1).south - ((Point) o2).south;
            }
        });

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data.get(j).south < data.get(i).north) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    //    {5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}
    public static void main(String[] args) {
        System.out.println(maxLengthChain(Arrays.asList(
                new Point(5, 24), new Point(39, 60),
                new Point(15, 28), new Point(27, 40),
                new Point(50, 90))));
    }
}
