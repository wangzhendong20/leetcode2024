package meiTuan0409;

public class AlternatePrinting {
    private static int number = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (number <= 10) {
                    synchronized (lock) {
                        while (number % 2 == 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + number++);
                        lock.notifyAll();
                    }
                }
            }
        }, "OddThread");

        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (number <= 10) {
                    synchronized (lock) {
                        while (number % 2 != 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + number++);
                        lock.notifyAll();
                    }
                }
            }
        }, "EvenThread");

        oddThread.start();
        evenThread.start();
    }
}
