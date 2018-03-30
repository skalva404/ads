package kalva.learnings.ads.recursion;

public class Permutations {

  public static void main(String[] args) {
    permute("ABCD", 0);
  }

  private static void permute(String str, int left) {
    if (left == str.length() - 1) {
      System.out.println(str);
    } else {
      for (int i = left; i <= str.length() - 1; i++) {
        str = swap(str, left, i);
        permute(str, left + 1);
        str = swap(str, left, i);
      }
    }
  }

  private static String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }
}
