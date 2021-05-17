package concurency.syncron;

public class SynchronizedMethodClass {

    private int sum = 0;
    private int syncSum = 0;

    static int staticSum = 0;

    public void calculate() {
        setSum(getSum() + 1);
    }

    public synchronized void syncCalculate() {
        setSum(getSum() + 1);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    int getSyncSum() {
        return syncSum;
    }

    private void setSyncSum(int syncSum) {
        this.syncSum = syncSum;
    }
}
