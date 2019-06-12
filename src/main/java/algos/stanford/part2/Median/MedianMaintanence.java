package algos.stanford.part2.Median;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MedianMaintanence {

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers ){

        if (lowers.isEmpty() || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){

        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());

        }

    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){

        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() == smallerHeap.size()){
            double t = (double)biggerHeap.peek() + smallerHeap.peek() / 2;
            //System.out.println(t);
            return  ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;

        } else {
            return biggerHeap.peek();
        }

    }

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("/Users/platon/Desktop/m2"));
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        int[] array = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            array[i] = Integer.valueOf(lines.get(i));
        }
        //System.out.println(array[0]);
        List<Double> medianss = new ArrayList<>();
        double[] medians = new double[array.length];
        double res = 0l;

        for (int i = 0; i < array.length; i++) {

            int number = array[i];
            addNumber(number,lowers,highers);
            rebalance(lowers,highers);
            medianss.add(getMedian(lowers,highers));
            medians[i] = getMedian(lowers,highers);
            res += getMedian(lowers,highers);

        }
        Float f;
        Float sum =0f;
        for (int i = 0; i < medians.length; i++) {
            f = (float) medians[i];
            sum = sum + f;
        }
        System.out.println(Arrays.toString(medians));
        System.out.println(sum);


    }


}
