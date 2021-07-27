package kalva.learnings.ads.againdp;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/printing-longest-increasing-consecutive-subsequence/?ref=rp
public class LongIncConsecutiveSubSeq {

    //3, 10, 3, 11, 4, 5, 6, 7, 8, 12
    static List<Integer> longIncConsecutiveSubSeq(int[] data) {

        List<Integer> tempList = new ArrayList<>();
        List<Integer> longList = new ArrayList<>();

        int highCount = 0;
        int currentMax;

        for (int i = 0; i < data.length; i++) {
            currentMax = data[i];
            tempList.add(data[i]);
            for (int j = i + 1; j < data.length; j++) {
                if (currentMax + 1 == data[j]) {
                    currentMax = data[j];
                    tempList.add(data[j]);
                }
            }
            if (highCount < tempList.size()) {
                highCount = tempList.size();
                longList = new ArrayList<>(tempList);
            }
            tempList.clear();
        }
        return longList;
    }

    public static void main(String[] args) {
        System.out.println(longIncConsecutiveSubSeq(new int[]{3, 10, 3, 11, 5, 14, 6, 7, 8, 12}));
    }
}
