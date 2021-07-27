package kalva.learnings.ads.dp;

import java.util.Stack;

public class TOH {

    private static Stack<Integer> source = new Stack<>();
    private static Stack<Integer> dest = new Stack<>();
    private static Stack<Integer> extra = new Stack<>();

    public static void main(String[] args) {
        int ctr = 4;
        for (int i = ctr; i > 0; i--) {
            source.push(i);
        }
        tohR("s", "d", "e", ctr);
        System.out.println(dest);
    }

    private static void tohR(String s, String d, String e, int n) {
        if (n <= 0) {
            return;
        }
        tohR(s, e, d, n - 1);
        System.out.println(String.format("\t\tMove %s from %s to %s", n, s, d));
        get(d).push(get(s).pop());
        tohR(e, d, s, n - 1);
    }

    static Stack<Integer> get(String s) {
        switch (s) {
            case "s":
                return source;
            case "d":
                return dest;
            case "e":
                return extra;
        }
        return null;
    }
}
