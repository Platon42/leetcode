package queue;

import java.util.*;

public class MovingAverage {

    private int limit;
    private LinkedList<Integer> queue;

    public MovingAverage(int size) {
        this.limit = size;
        this.queue = new CircularQueue<>();
    }

    private class CircularQueue<E> extends LinkedList<E> {

        @Override
        public boolean add(E e) {
            super.add(e);
            if (size() > limit) super.remove();
            return true;
        }

    }

    public double next(int val) {

        double average = 0;
        queue.add(val);
        int sum = 0;
        sum += queue.pop();

//        average=average/queue.size();
        System.out.println(sum);

        return average;

    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        m.next(1);
        m.next(10);
        m.next(3);
        m.next(5);
    }

}
