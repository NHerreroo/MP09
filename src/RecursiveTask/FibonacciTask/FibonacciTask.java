package RecursiveTask.FibonacciTask;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {

    private  int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n < 10)  fibonacciS();
        else return fibonacciR();
        return 0L;
    }

    private Long fibonacciR() {
        FibonacciTask t1 = new FibonacciTask(n-1);
        FibonacciTask t2 = new FibonacciTask(n-2);

        t1.fork();
        t2.fork();

        return  t1.join() + t2.join();
    }

    private Long fibonacciS() {
        if(n <= 1){
            return 1L;

        }
        return 0L;
    }


}
