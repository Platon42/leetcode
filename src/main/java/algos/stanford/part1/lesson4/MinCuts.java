package algos.stanford.part1.lesson4;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("Duplicates")
public class MinCuts {

    public static void main(String[] args) throws IOException {

        File f = new File("/Users/platon/Desktop/gr");
        List<String> lines2 = FileUtils.readLines(f, "UTF-8");

        int ln = 0;
        int[] inputArray = new int[lines2.size()];

        for (String line : lines2) {
            ln++;
            inputArray[ln]=Integer.valueOf(line);
        }

        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(i);
        }

    }


}
