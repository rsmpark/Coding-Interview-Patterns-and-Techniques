// 2 1 5 2 3 2

public class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int sum = 0, windowStart = 0, length = Integer.MAX_VALUE;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      sum += arr[windowEnd];

      while (sum >= S) {
        length = Math.min(length, windowEnd - windowStart + 1);
        sum -= arr[windowStart++];
      }
    }

    return length;
  }

  public static void main(String[] args) {
    System.out.println(findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 }));
    System.out.println(findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 }));
    System.out.println(findMinSubArray(7, new int[] { 2, 1, 3, 2, 4, 2, 6, 1 }));
    System.out.println(findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 }));
  }
}