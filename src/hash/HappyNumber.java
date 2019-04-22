package hash;

import java.util.HashSet;

public class HappyNumber {

    public static boolean isHappy(int n) {

        HashSet<Integer> hashSet = new HashSet<>();

        int digits,squareSum;
        while (hashSet.add(n)) {
            squareSum = 0;
            while (n > 0) {
                digits = n % 10;
                squareSum += digits * digits;
                n = n / 10;
            }

            if (squareSum==1) return true;
            else n=squareSum;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));
    }
}
