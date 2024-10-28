package DivisionRusa;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        DivisionTask div = new DivisionTask(24,7);
        ForkJoinPool execute = new ForkJoinPool();

        execute.invoke(div);
        int res = div.join();
        System.out.println(res);
    }
}
