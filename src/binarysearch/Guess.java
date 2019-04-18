package binarysearch;

@SuppressWarnings("Duplicates")

public class Guess {

    int guessNumber(int n) {

        GuessGame guessGame = new GuessGame(n);
        int left = 1, right = n;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (guessGame.guess(mid) == 0) {
                return mid;
            } else if (guessGame.guess(mid) == -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Guess guess = new Guess();
        System.out.println("magic found = "+guess.guessNumber(10));
    }
}
