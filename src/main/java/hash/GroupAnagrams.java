package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("Duplicates")
public class GroupAnagrams {

    public static void groupAnagrams(String[] strs) {

        HashMap<Integer,ArrayList<String>> hashMap = new HashMap<>();
        int [] array = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107};

        for (String str : strs) {
            char[] chars = str.toCharArray();
            int key = 1;
            for (char ch : chars) {
                key *= array[ch - 'a'];
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
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>(hashMap.values());
        int i=0;
        for (ArrayList<String> arrayList: arrayLists) {
            System.out.println("Index="+i);
            for (String s : arrayList) {
                System.out.println("item= " + s);
            }
            i++;
        }

    }
    public static void main(String[] args) {
       groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"});
    }

}

