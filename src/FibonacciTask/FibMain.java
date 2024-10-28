package FibonacciTask;

import java.util.concurrent.ForkJoinPool;

public class FibMain {
    public static void main(String[] args) {
        FibonacciTask fib = new FibonacciTask(7);
        ForkJoinPool executor = new ForkJoinPool();
        executor.invoke(fib);

         long res = fib.join();

        System.out.println(res);
    }

}
