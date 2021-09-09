public class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    int start = 0, maxLength = 0, onesRepeat = 0;

    for (int end = 0; end < arr.length; end++) {
      int windowSize = end - start;

      if (arr[end] == 1)
        onesRepeat++;

      if (windowSize - onesRepeat > k) {
        if (arr[start++] == 1)
          onesRepeat--;
      }

      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
  }
}
