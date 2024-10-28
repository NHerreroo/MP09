package Factorial;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask <Long> {

    private int num;

    public FactorialTask(int i) {
        this.num = i;
    }

    @Override
    protected Long compute() {
        if (num < 10){
            return FactorialSeq();
        }else{
            return FactorialReq();
        }
    }

    private long FactorialReq() {
        if (num == 1)return 1L;
        else {
            FactorialTask task1 = new FactorialTask(num -1);
            task1.fork();
            return num * task1.join();
        }
    }

    private long FactorialSeq() {
        if (num == 1) return 1L;
        else {
            long temp = 1L;

            for (int i = 1; i <= num; i++){
                temp = temp * i;
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        FactorialTask f = new FactorialTask(5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(f);
        long res = f.join();

        System.out.println("factorial resultat " + res);
    }
}
