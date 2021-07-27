package kalva.learnings.ads.againdp;

import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Collections;

import java.util.List;

public class LIS_Bridge {

    public static class Point {

        int north;
        int south;

        Point(int north, int south) {
            this.north = north;
            this.south = south;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "north=" + north +
                    ", south=" + south +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Point> bridgeList =
                Arrays.asList(new Point[]{
                        new Point(6, 2), new Point(4, 3),
                        new Point(2, 6), new Point(1, 5)
                });
//                Arrays.asList(new Point[]{
//                        new Point(7, 5), new Point(4, 3),
//                        new Point(3, 2), new Point(6, 4),
//                        new Point(2, 6), new Point(1, 1),
//                        new Point(5, 7)
//                });

        //7,4,3,6,2,1,5   => 1,2,3,4,5,6,7
        //5,3,2,4,6,1,7   => 1,6,2,3,7,4,5

        Collections.sort(bridgeList, (o1, o2) -> {
            if (((Point) o1).south == ((Point) o2).south) {
                return ((Point) o1).north - ((Point) o2).north;
            } else {
                return ((Point) o1).south - ((Point) o2).south;
            }
        });
        System.out.println(bridgeList);

        int[] cmax = new int[bridgeList.size()];
        int[] prevNodes = new int[bridgeList.size()];

        for (int n = 0; n < bridgeList.size(); n++) {
            int max = 1;//when no other
            int prevNode = -1;
            Point nthItem = bridgeList.get(n);
            for (int i = 0; i < n; i++) {
                //CRUX: consider only those items which will include nth item
                //IMP FOR DP
                if (nthItem.north >= bridgeList.get(i).north) {
                    if (cmax[i] >= max) {
                        max = cmax[i] + 1;
                        prevNode = i;
                    }
                }
            }

            cmax[n] = max;
            prevNodes[n] = prevNode;
        }

        for (int prevNode : prevNodes) {
            System.out.println(prevNode);
        }
    }
}
