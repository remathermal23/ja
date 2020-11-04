import java.util.*;

public class LongestSubstringWithoutDuplication {

  public static void main(String[] args) {
    // Testcases
    assert longestUniqueSubstring("lmnoppqrrsss").equals("lmnop");
    assert longestUniqueSubstring("falafel").equals("lafe");
    assert longestUniqueSubstring("krishnamachari").equals("krishnam");
  }

  // Finds the longest substring of a string having unique characters
  public static String longestUniqueSubstring(String str) {
    if (str.equals("")) return "";
    HashMap<Character, Integer> lastSeenAt = new HashMap<>();
    int[] longest = new int[] { 0, 1 };
    int start = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (lastSeenAt.containsKey(c)) start =
        Math.max(start, lastSeenAt.get(c) + 1);
      if (longest[1] - longest[0] < i + 1 - start) longest =
        new int[] { start, i + 1 };
      lastSeenAt.put(c, i);
    }
    return str.substring(longest[0], longest[1]);
  }
}
