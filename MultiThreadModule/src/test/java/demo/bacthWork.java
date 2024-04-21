package demo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有10000个任务，分为100个批次，每个批次处理100个任务，这些任务有顺序要求，要求前一个批次任务都执行完才能执行下一个批次的任务。
 * 要求一个批次中的任务并发处理。
 */
public class bacthWork {
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
