package demo;

/**
 * 一个死锁的例子
 */
public class DeadLock {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (lock1) {
                     System.out.println("Thread 0 locked lock1");
                     try {
                         Thread.sleep(1000);
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                    System.out.println(Thread.currentThread().getName() + ": wait locked lock2");

                     synchronized (lock2) {
                         System.out.println("Thread 0 locked lock2");
                     }

                }
            }
        }, "Thread 0");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread 1 locked lock2");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": wait locked lock1");

                    synchronized (lock1) {
                        System.out.println("Thread 1 locked lock1");
                    }
                }
            }
        },"Thread 1");

        t1.start();
        t2.start();
    }

    /**
     * 解决该死锁的方法：
     * 按序获取锁，即按照锁的顺序获取锁，先获取lock1，再获取lock2，反之亦然。
     */
//    Thread t2 = new Thread(new Runnable() {
//
//        @Override
//        public void run() {
//            synchronized (lock1) {
//                System.out.println("Thread 1 locked lock1");
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + ": wait locked lock2");
//
//                synchronized (lock2) {
//                    System.out.println("Thread 1 locked lock2");
//                }
//            }
//        }
//    },"Thread 1");

}
