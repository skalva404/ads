package kalva.learnings.ads.arrays.general;

/**
 * Best time to buy and sell stocks.
 * 1) Only 1 transaction is allowed
 * 2) Infinite number transactions are allowed
 * <p>
 * Time complexity O(n)
 * Space complexity O(1)
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuySell {

  private int oneProfit(int arr[]) {

    int minPrice = arr[0];
    int maxProfit = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - minPrice > maxProfit) {
        maxProfit = arr[i] - minPrice;
      }
      if (minPrice > arr[i]) {
        minPrice = arr[i];
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {

    int arr[] = {7, 10, 15, 5, 11, 2, 7, 9, 3};
    BuySell buySell = new BuySell();
    System.out.println(buySell.oneProfit(arr));
  }
}
