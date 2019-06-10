package stanford.greedy_dynamic.partthree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Huffman {

    private static class HuffmanNode {

        Integer freq;
        HuffmanNode right = null, left = null;

        HuffmanNode(int freq) {
            this.freq = freq;
        }

        HuffmanNode(HuffmanNode left, HuffmanNode right, int freq) {

            this.left = left;
            this.right = right;
            this.freq = freq;
        }
    }

    public static void main(String[] args) throws IOException {

        HuffmanNode root = buildTree();
        String s = "";

        ArrayList<String> arrayList = new ArrayList<>();
        traverse(root, s, arrayList);

        StringBuilder sb = new StringBuilder();

        int m = 0;
        for (String d : arrayList) {
            sb.append(d);
            m += d.length();
            //System.out.println(d);
        }

        System.out.println(m);
        //System.out.println(sb.toString());
        String max = Collections.max(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        String min = Collections.max(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println(max.length());
        System.out.println(min.length());

    }

    private static void traverse(HuffmanNode root, String str, ArrayList<String> huffmanCode)
    {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            huffmanCode.add(str);
        }

        traverse(root.left, str + "0", huffmanCode);
        traverse(root.right, str + "1", huffmanCode);
    }


    private static HuffmanNode buildTree() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Platon\\Downloads\\huf2.txt"));
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparing(o -> o.freq));

        for (String line : lines)
            pq.add(new HuffmanNode(Integer.valueOf(line)));

        while (pq.size() != 1) {

            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            int sum = left.freq + right.freq;
            pq.add(new HuffmanNode(left, right, sum));

        }

        return pq.peek();
    }
}
