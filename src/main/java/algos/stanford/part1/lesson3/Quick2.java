package algos.stanford.part1.lesson3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Quick2 {

    static LinkedHashMap<Double,Integer> acc = new LinkedHashMap<>();
    private static int countComparisons;

    private static void swap(int[] input, int i, int j) {

        final int t = input[i];
        input[i] = input[j];
        input[j] = t;

    }

    public static void main(String[] args) throws IOException {

        File f = new File("/Users/platon/Desktop/intq");
        List<String> lines2 = FileUtils.readLines(f, "UTF-8");
        ArrayList<Integer> arrayList = new ArrayList<>();

        int ln = 0;
        /*
        int[] inputArray = new int[lines2.size()+1];

        for (String line : lines2) {
            ln++;
            inputArray[ln]=Integer.valueOf(line);
            //arrayList.add(Integer.valueOf(line));

        }

        */

        //arrayList.sort(Comparator.naturalOrder());
//        for (int i : inputArray){
//            System.out.println("sort array="+i);
//        }
        //int[] inputArray = {199,85552,6,5,9,5,7676,3};
        //int[] inputArray = {18,822,66,55,9,5,7,3};

        int[] inputArray = {18,822,66,55,9,5,7,3};

//        Scanner scanner = new Scanner(new File("/Users/platon/Desktop/intq"));
//        while (scanner.hasNextLine()) {
//
//            //System.out.println("string is="+scanner.nextLine());
//            ln++;
//            inputArray[ln]=Integer.valueOf(scanner.nextLine());
//
//        }

        sort(inputArray, 0, inputArray.length-1);

        for (int i : inputArray) {
            System.out.println("sort="+i);
        }

        System.out.println("comps="+countComparisons);
        //System.out.println("element are "+inputArray[1]);


    }

    private static void sort(int[] a, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pivotIndex = partition(a, low, high);

            //System.out.println("pi is="+pivotIndex);
            // Recursively sort elements before
            // partition and after partition
            sort(a, low, pivotIndex-1);
            sort(a, pivotIndex, high);
        }
    }
    private static int partition(int[] a, int low, int high) {

        int p = a[high];
        int i = low + 1;
        //countComparisons += (long) high - i;
        countComparisons += (long) high - low -1;

        for (int j = low + 1; j < high; j++) {
            if (a[j] < p) {

                swap(a,i,j);
                i++;
            }
        }

        swap(a,high,i-1);

        return i+1;
    }
}
