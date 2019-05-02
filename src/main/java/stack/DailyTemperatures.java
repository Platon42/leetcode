package stack;

// T = [73, 74, 75, 71, 69, 72, 76, 73]
// [1, 1, 4, 2, 1, 1, 0, 0]

// [89,62,70,58,47,47,46,76,100,70]

// [8,1,5,4,3,2,1,1,0,0] correct
// [8,1,5,4,1,2,1,1,0,0] wrong

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[T.length];
        int length = T.length;

        for (int i = 0; i < length - 1; i++) {
            int curr = T[i], next = T[i + 1];
            stack.push(curr);
            if (next > stack.peek()) {
                stack.pop();
                res[i] = 1;
            } else {
                int count = 1;
                boolean brk = false;
                System.out.println("i = " + i);
                for (int j = i + 1; j < length; j++) {

                    //System.out.println("count = "+count);
                    System.out.println("curr = " + curr);
                    System.out.println("T[j] = " + T[j]);

                    if (curr >= T[j])
                        count++;
                    else {
                        brk = true;
                        break;
                    }
                }
                if (!brk) count = 0;
                res[i] = count;
                stack.pop();
            }

        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}

