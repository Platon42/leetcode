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
            for (char ch : chars) {
                key = ch - 'a';
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
        groupStrings(new String[]{"abc","bcd"});
    }
}
