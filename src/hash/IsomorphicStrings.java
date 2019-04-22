package hash;

import java.util.*;
import java.util.stream.Stream;

public class IsomorphicStrings {

    static boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character> hashMap = new HashMap<>();

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for (int i = 0; i < sc.length; i++) {

            char key = sc[i];
            char value = tc[i];

            if (hashMap.containsKey(key)) {
                char v = hashMap.get(key);
                if (v!=value) return false;
            }

            if (hashMap.containsValue(value)) {

                Set<Map.Entry<Character, Character>> entrySet = hashMap.entrySet();
                for (Map.Entry<Character, Character> entry : entrySet) {
                    if (entry.getKey()!=key && entry.getValue()==value) return false;
                }
//
//                Stream<Character> characterStream =
//                        hashMap.entrySet()
//                                .stream()
//                                .filter(entry -> value == entry.getValue())
//                                .map(Map.Entry::getKey);
//                Character[] keys = characterStream.toArray(Character[]::new);
//                if (keys[0]!=key) return false;
            }
            hashMap.put(key,value);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));

    }

}
