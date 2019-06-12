package algos.stanford.part1.lesson3;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.*;


//162085
@SuppressWarnings("Duplicates")
public class QuickLow {
    static LinkedHashMap<Double,Integer> acc = new LinkedHashMap<>();
    private static int countComparisons;

    private static void swap(int[] input, int i, int j) {

        final int t = input[i];
        input[i] = input[j];
        input[j] = t;

    }

    public static void main(String[] args) throws IOException {

//        int[] inputArray = new int[10000];
//        try {
//            inputArray = initializeInputArray("/Users/platon/Desktop/intq");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File f = new File("/Users/platon/Desktop/intq");
        List<String> lines2 = FileUtils.readLines(f, "UTF-8");
        ArrayList<Integer> arrayList = new ArrayList<>();

        int ln = 0;
        int[] inputArray = new int[lines2.size()+1];

        for (String line : lines2) {
            inputArray[++ln]=Integer.valueOf(line);
            //arrayList.add(Integer.valueOf(line));

        }
        //arrayList.sort(Comparator.naturalOrder());
//        for (int i : inputArray){
//            System.out.println("sort array="+i);
//        }
        //int[] inputArray = {199,85552,6,5,9,5,7676,3};
        //int[] inputArray = {18,822,66,55,9,5,7,3};

        int[] inputArraya = {3,1,2,4,5,8,7,6,9};

        //System.out.println(inputArray.length);


//        Scanner scanner = new Scanner(new File("/Users/platon/Desktop/intq"));
//        while (scanner.hasNextLine()) {
//
//            //System.out.println("string is="+scanner.nextLine());
//            ln++;
//            inputArray[ln]=Integer.valueOf(scanner.nextLine());
//
//        }

        sort(inputArraya, 0, inputArraya.length);

        for (int i : inputArraya) {
           System.out.println("sort="+i);
        }

        System.out.println("comps="+countComparisons);
        //System.out.println("element are "+inputArray[1]);


    }

    private static void sort(int a[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pivotIndex = partition(a, low, high);
            System.out.println("pivotIndex is="+pivotIndex);

            //System.out.println("pi is="+pivotIndex);
            // Recursively sort elements before
            // partition and after partition
            sort(a, low, pivotIndex-1);
            sort(a, pivotIndex, high);
        }
    }
    private static int partition(int[] a, int low, int high) {

        int p = a[low];
        int i = low + 1;
        //countComparisons += (long) high - i;
        countComparisons += (long) high - low -1;

        for (int j = low + 1; j < high; j++) {
            System.out.println("low+1 is="+low+1);

            if (a[j] < p) {
                System.out.println("j is="+j);
                System.out.println("a[j] is="+j);

                swap(a,i,j);
                System.out.println("i is="+i);

                i++;

            }
            System.out.println("j2 is="+j);

        }
        System.out.println("i2 is="+i);

        swap(a,low,i-1);
        System.out.println(Arrays.toString(a));

        return i;
    }


}
