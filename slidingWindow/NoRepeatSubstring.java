import java.util.HashMap;

public class NoRepeatSubstring {
  // public static int findLength(String str) {
  // int start = 0, length = 0;

  // HashMap<Character, Integer> charFreqMap = new HashMap<Character, Integer>();

  // for (int end = 0; end < str.length(); end++) {
  // char rightChar = str.charAt(end);
  // charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);

  // while (charFreqMap.get(rightChar) > 1) {
  // char leftChar = str.charAt(start++);
  // charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
  // }

  // length = Math.max(length, end - start + 1);
  // }

  // return length;
  // }

  public static int findLength(String str) {
    int windowStart = 0, maxLength = 0;
    HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      // if the map already contains the 'rightChar', shrink the window from the
      // beginning so that
      // we have only one occurrence of 'rightChar'
      if (charIndexMap.containsKey(rightChar)) {
        // this is tricky; in the current window, we will not have any 'rightChar' after
        // its previous index
        // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll
        // keep 'windowStart'
        windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
      }
      charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
  }
}
