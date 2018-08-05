package kalva.learnings.ads.arrays.rotate;

/**
 * https://algorithms.tutorialhorizon.com/divide-and-conquer-rearrange-array-elements-in-special-order/
 */
public class Rearrange1 {

  public static void main(String[] args) {
    int[] array = {1, 3, 5, 7, 2, 4, 6, 8};
    int[] dest = new int[array.length];

    int counter = 1;
    int mid = array.length / 2;
    dest[array.length - 1] = array[array.length - 1];
    for (int i = 0; i < array.length - 2; i += 2) {
      dest[i + 1] = array[mid++];
      dest[i + 2] = array[counter++];
    }

    for (int i1 : dest) {
      System.out.print(i1 + "\t");
    }
  }
}
