package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressWarnings("Duplicates")

public class GroupShiftedStrings {

    public static List<List<String>> groupStrings(String[] strings) {

        HashMap<Integer,ArrayList<String>> hashMap = new HashMap<>();

        for (String str : strings) {
            char[] chars = str.toCharArray();
            int key = 1;
            int first = str.charAt(0);
            for (char ch : chars) {
                if (ch - first <= 0) {
                    key += ch - first + 26;
                    System.out.println(key);
                } else {
                    System.out.println(key);

                    key += ch - first;
                }
                //key += (ch - first < 0 ? ch - first + 26 : ch - first);
            }
            if (!hashMap.containsKey(key)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                hashMap.put(key, arrayList);
            } else {
                ArrayList<String> current = hashMap.get(key);
                current.add(str);
                hashMap.put(key, current);
            }
        }
        List<List<String>> arrayLists = new ArrayList<>(hashMap.values());
        int i=0;
        for (List<String> arrayList: arrayLists) {
            System.out.println("Index="+i);
            for (String s : arrayList) {
                System.out.println("item= " + s);
            }
            i++;
        }

        return arrayLists;

    }

    public static void main(String[] args) {
        groupStrings(new String[]{"aa","bb","b"});
    }
}
