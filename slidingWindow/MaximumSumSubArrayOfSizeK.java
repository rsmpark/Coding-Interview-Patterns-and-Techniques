class MaxSumSubArrayOfSizeK {
  // public static int findMaxSumSubArray(int k, int[] arr) {
  // int left = 0, right = 0, sum = 0;

  // while (right < k) {
  // sum += arr[right++];
  // }

  // int maxSum = sum;

  // while (right < arr.length) {
  // sum += arr[right++] - arr[left++];

  // if (sum > maxSum)
  // maxSum = sum;
  // }

  // return maxSum;
  // }

  public static int findMaxSumSubArray(int k, int[] arr) {
    int sum = 0, maxSum = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      sum += arr[windowEnd];

      if (windowEnd >= k - 1) {
        maxSum = Math.max(maxSum, sum);
        sum -= arr[windowStart];
        windowStart++;
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
  }
}