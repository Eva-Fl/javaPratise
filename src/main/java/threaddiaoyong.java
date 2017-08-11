/**
 * Created by ljfeng on 2017/8/2.
 */
public class threaddiaoyong {
    public static void main(String[] args) {
        //ThreadClass t=new ThreadClass();
        //RunnableClass r=new RunnableClass();
        Sums s = new Sums();
        ThreadClass t1 = new ThreadClass(s);
        //Thread t1=new Thread(new ThreadClass(s));
        Thread r1 = new Thread(new RunnableClass(s));
        r1.setDaemon(true);
        t1.start();
        r1.start();
    }
}

class Sums {
    public int sum;
    public void calculate() {
        for (int i = 1; i < 100; i++) {
            try {
                Thread.sleep(100);
                sum += i * i;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public int getSum() {
        return sum;
    }
}

class ThreadClass extends Thread {
    private Sums s;

    public ThreadClass(Sums s) {
        this.s = s;
    }

    public void run() {
        s.calculate();
    }
}

class RunnableClass implements Runnable {
    private Sums s;

    public RunnableClass(Sums s) {
        this.s = s;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(300);
                System.out.println("Thread1" +"-----" + s.getSum());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
