package kalva.learnings.ads;

import java.text.DecimalFormat;

public class Utils {

    public static int height(Node root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    public static void printInt(int data) {
        DecimalFormat twodigits = new DecimalFormat("00");
        System.out.print(twodigits.format(data) + "  ");
    }

    public static void printArray(int[] arr) {
        DecimalFormat myFormatter = new DecimalFormat("##");
        for (int i1 : arr) {
            System.out.print(myFormatter.format(i1) + " ");
        }
        System.out.println();
    }

    public static void printArray(boolean[][] arr) {
        DecimalFormat myFormatter = new DecimalFormat("##");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] ? myFormatter.format(1L) : myFormatter.format(0L) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(int[][] arr) {

        DecimalFormat myFormatter = new DecimalFormat("##");
        int len = arr[arr.length - 1].length;
        System.out.print("    ");

        for (int i = 0; i < len; i++) {
            System.out.print(myFormatter.format(i) + " ");
        }
        System.out.println();
        fillHorRow(len, "-");

        int ind = 0;
        for (int[] ints : arr) {
            System.out.print(myFormatter.format(ind++) + " | ");
            for (int anInt : ints) {
                System.out.print(myFormatter.format(anInt) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(int[][] arr, String s1, String s2) {
        DecimalFormat myFormatter = new DecimalFormat("##");
        int len = arr[arr.length - 1].length;

        fillHorRow(len, "-");
        System.out.print("      ");
        for (int i = 0; i < len; i++) {
            System.out.print(myFormatter.format(i) + " ");
        }
        System.out.println();
        System.out.print("        ");
        for (int i = 0; i < len - 1; i++) {
            System.out.print(s2.charAt(i) + " ");
        }
        System.out.println();


        fillHorRow(len, "=");

        int ind = 0;
        for (int[] ints : arr) {
            System.out.print(myFormatter.format(ind) + " ");
            if (1 <= ind && s1.length() >= ind) {
                System.out.print(s1.charAt(ind - 1) + " | ");
            } else {
                System.out.print("  | ");
            }
            for (int anInt : ints) {
                System.out.print(myFormatter.format(anInt) + " ");
            }
            System.out.println();
            ;
            ind++;
        }
        System.out.println();
    }

    private static void fillHorRow(int len, String s) {
        for (int i = 0; i <= len + 1; i++) {
            System.out.print(s + " ");
        }
        System.out.println(s);
    }

    public static int getOrDefault(int m, int n, int[][] T) {
        if (0 > m || 0 > n) {
            return 0;
        }
        try {
            return T[m][n];
        } catch (ArrayIndexOutOfBoundsException ir) {
            ir.printStackTrace();
            return 0;
        }
    }

    public static void testGraph() {
//        Graph g = new Graph();
    }

    public static void main(String[] args) {
        System.out.println(height(Node.createSampleTree()));
    }
}
