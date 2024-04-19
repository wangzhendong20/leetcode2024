package feiZhu;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class code2 {
    private static final int batch = 100;
    private static final int allBatch = 100;
    private static AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {

                Thread thread = new Thread(r,"thread"+count.getAndIncrement());
                return thread;
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                batch,
                batch,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(batch),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < allBatch; i++) {
            CountDownLatch latch = new CountDownLatch(batch);

            for (int j = 0; j < batch; j++) {
                int taskNumber = i * batch + j;
                executor.submit(() -> {
                    System.out.println("Task " + taskNumber);
                    latch.countDown();
                });
            }

            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executor.shutdown();
    }
}
