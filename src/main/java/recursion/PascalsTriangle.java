package recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> integerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                System.out.println(j);
                integerList.add(pascal(i,j));
            }
            list.add(integerList);
        }
        return list;
    }

    private int pascal (int row, int col) {

        if (col == 0 || col == row ) return 1;
        return pascal(row - 1, col - 1) + pascal(row - 1, col);
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> lists = pascalsTriangle.generate(5);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                //System.out.println(i);
            }
            System.out.println(list);
        }
    }
}
