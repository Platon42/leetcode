package stanford.greedy.partthree;

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

        // found a leaf node
        if (root.left == null && root.right == null) {
            huffmanCode.add(str);
        }

        traverse(root.left, str + "0", huffmanCode);
        traverse(root.right, str + "1", huffmanCode);
    }


    private static HuffmanNode buildTree() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Platon\\Downloads\\huffman.txt"));
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.freq.compareTo(o2.freq);
            }
        });

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
