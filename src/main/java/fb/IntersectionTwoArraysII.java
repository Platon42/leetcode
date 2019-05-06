package fb;

import java.util.*;

@SuppressWarnings("Duplicates")
public class IntersectionTwoArraysII {

    public void intersect(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();


        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = nums1.length - 1, j = nums2.length - 1; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0) {
                q.add(nums1[i]);
            }
            if (j >= 0) {
                q2.add(nums2[j]);
            }
        }
        for(int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);

        while (!q.isEmpty() && !q2.isEmpty()) {
            if (q.peek() < q2.peek()) q.remove();
            else if (q.peek() > q2.peek()) q2.remove();
            else if (q.peek().equals(q2.peek())) {
                linkedList.add(q.poll());
                q2.remove();
            }
        }

//        while (!q.isEmpty() || !q2.isEmpty()) {
//            if (q.peek() != null && q2.peek() != null && q.peek().equals(q2.peek())) {
//
//                int key = (q.size() < q2.size()) ? q.poll() : q2.poll();
//                if (hashMap.containsKey(key)) {
//                    hashMap.put(key, (hashMap.get(key) + 1));
//                } else hashMap.put(key, 1);
//                //if (hashMap.containsKey(b) && hashMap.get(b)/2==0) hashMap.put(b,(hashMap.get(b)+1));
//                //else hashMap.put(b,1);
//            } else if (q.peek() != null && q2.peek() != null && q.peek() < q2.peek())
//                q.remove();
//            else  {
//                if (q2.isEmpty()) break;
//                q2.remove();
//            }
//        }


        //int res[] = new int[hashMap.values().stream().];
        for (Integer key : hashMap.keySet()) {
            int qty = hashMap.get(key);
            System.out.println("qty is " +qty);

            if (qty % 2 == 0 && qty < 2) qty=qty/2;
            else if (qty % 2 != 0 && qty < 1) System.out.println("11"); qty--;
            System.out.println("key is " +key);
            System.out.println("qty is " +qty);
            for (int i = 0; i < qty; i++) {
                //linkedList.add(key);
            }
        }

        int[] res = new int[linkedList.size()];
        for (int i = 0; i < linkedList.size(); i++) {
            res[i] = linkedList.get(i);
        }

        System.out.println(Arrays.toString(res));
    }

    int findSum(LinkedList<Integer> linkedList, int N)
    {
        if (N <= 0)
            return 0;
        return (findSum(linkedList, N - 1) + linkedList.get(N - 1));
    }

    public static void main(String[] args) {
        IntersectionTwoArraysII intersectionTwoArraysII = new IntersectionTwoArraysII();
        intersectionTwoArraysII.intersect(new int[]{1,2,2,1}, new int[]{2,2});

    }


}
