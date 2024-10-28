package DivisionRusa;

import java.util.concurrent.RecursiveTask;

public class DivisionTask extends RecursiveTask<Integer> {

    private int divisor;
    private int divident;

    public DivisionTask(int divisor, int divident) {
        this.divisor = divisor;
        this.divident = divident;
    }

    @Override
    protected Integer compute() {
        if ((divident -divisor) < 30) {
            return divisionS();
        }
        else {
            return divisionR();
        }
    }

    private Integer divisionR() {
        if (divisor > divident) return 0;
        else {
            DivisionTask d1 = new DivisionTask(divisor -divident, divisor);
            d1.fork();
            return d1.join() + 1;
        }
    }

    private Integer divisionS() {
        int c = 0;
        while (divident >= divisor){
            divident = divident - divisor;
            c++;
        }
        return c;
    }
    
}
