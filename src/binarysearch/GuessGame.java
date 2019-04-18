package binarysearch;

import java.util.Random;

class GuessGame {
    private int random;

    GuessGame(int seed) {
        this.random = new Random().nextInt(seed);
    }

    int guess(int num) {
        System.out.println("magic is =" + random);
        return Integer.compare(num, random);
    }
}
