package kalva.learnings.ads.againdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BoxStacking {

    static class Box implements Comparable<Box> {
        // constraint: width is never more than length
        int length, width, height;

        Box(int length, int width, int height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }


        @Override
        public int compareTo(Box o) {
            if (length < o.length && width < o.width) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private static List<Box> createAllRotations(List<Box> boxes) {

        List<Box> rotations = new ArrayList<>();
        for (Box box : boxes) {
            rotations.add(box);
            rotations.add(new Box(max(box.length, box.height), min(box.length, box.height), box.width));
            rotations.add(new Box(max(box.width, box.height), min(box.width, box.height), box.length));
        }
        return rotations;
    }

    private static int findMaxHeight(List<Box> boxes) {

        List<Box> rotations = createAllRotations(boxes);
        rotations.sort((x, y) -> (y.length * y.width - x.length * x.width));

        int[] max_height = new int[rotations.size()];
        for (int i = 0; i < rotations.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (rotations.get(i).compareTo(rotations.get(j)) < 0) {
                    max_height[i] = Math.max(max_height[i], max_height[j]);
                }
            }
            max_height[i] += rotations.get(i).height;
        }
        // return the maximum value in `max_height[]`
        return Arrays.stream(max_height).max().getAsInt();
    }

    public static void main(String[] args) {

        List<Box> boxes = Arrays.asList(new Box(4, 2, 5),
                new Box(3, 1, 6),
                new Box(3, 2, 1),
                new Box(6, 3, 8));
        System.out.println("The maximum height is " + findMaxHeight(boxes));
    }
}
