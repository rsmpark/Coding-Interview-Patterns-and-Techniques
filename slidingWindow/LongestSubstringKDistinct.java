import java.util.HashMap;
import java.util.Map;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0)
      throw new IllegalArgumentException();

    int windowStart = 0, maxLength = 0;

    Map<Character, Integer> charFreqMap = new HashMap<Character, Integer>();

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char currChar = str.charAt(windowEnd);
      charFreqMap.put(currChar, charFreqMap.getOrDefault(currChar, 0) + 1);

      while (charFreqMap.size() > k) {
        char leftChar = str.charAt(windowStart++);
        charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
        if (charFreqMap.get(leftChar) == 0) {
          charFreqMap.remove(leftChar);
        }
      }

      maxLength = Math.max(maxLength, charFreqMap.values().stream().reduce(0, Integer::sum));
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }
}