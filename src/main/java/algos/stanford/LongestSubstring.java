package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        longestSubstring.lengthOfLongestSubstring("abcabcbb");
    }

    private void lengthOfLongestSubstring(String s) {

        final char[] chars = s.toCharArray();

        Map<Character, Integer> visited = new HashMap<>();
        String output = "";

        for (int start = 0, end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = s.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        for (Map.Entry<Character, Integer> entries : visited.entrySet()) {
            System.out.println(entries.getKey() +  " = " + entries.getValue());
        }

    }
}
