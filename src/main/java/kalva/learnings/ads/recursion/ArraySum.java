package kalva.learnings.ads.recursion;

import java.util.ArrayList;
import java.util.List;

public class ArraySum {

    static int sum(List<Integer> list, int sum) {
        if (null == list || 0 == list.size()) {
            return sum;
        }
        sum += list.remove(0);
        return sum(list, sum);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(sum(arrayList, 0));
    }
}
