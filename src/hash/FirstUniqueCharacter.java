package hash;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {

        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();
        for (char key : charArray) {
            if (hashMap.containsKey(key)) {
                hashMap.put(key,hashMap.get(key)+1);
            } else {
                hashMap.put(key,1);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.get(charArray[i])==1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {

       System.out.println(firstUniqChar("leetcode"));
    }
}
