import java.util.HashMap;

class CharacterReplacement {
  public static int findLength(String str, int k) {
    int start = 0, maxLength = 0, maxFrequency = 0;
    HashMap<Character, Integer> charFreqMap = new HashMap<Character, Integer>();

    for (int end = 0; end < str.length(); end++) {
      int windowLength = end - start + 1;

      char rightChar = str.charAt(end);
      charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);

      maxFrequency = Math.max(maxFrequency, charFreqMap.get(rightChar));

      if (windowLength - maxFrequency > k) {
        char leftChar = str.charAt(start++);
        charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
      }

      maxLength = Math.max(maxLength, end - start + 1);

    }

    return maxLength;
  }
}
