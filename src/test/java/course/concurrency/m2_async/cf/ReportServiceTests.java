package course.concurrency.m2_async.cf;

import course.concurrency.m2_async.cf.report.ReportServiceCF;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

class ReportServiceTests {

//    private ReportServiceExecutors reportService = new ReportServiceExecutors();
    int poolSize = 24;
    int iterations = 5;

        private final ReportServiceCF reportService = new ReportServiceCF();
//    @Disabled
    @Test
    @DisplayName("ForkJoinPool")
    void testMultipleTasksF() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = ForkJoinPool.commonPool();

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("ForkJoinPool- Execution time: " + (end - start));
    }
    @Disabled
    @Test
    @DisplayName("SingleThreadExecutor")
    void testMultipleTasks1() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("SingleThreadExecutor- Execution time: " + (end - start));
    }

//    @Disabled
    @Test
    @DisplayName("CachedThreadPool")
    void testMultipleTasks2() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("CachedThreadPool- Execution time: " + (end - start));
    }

//    @Disabled
    @Test
    @DisplayName("FixedThreadPool(2)")
    void testMultipleTasks3() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("FixedThreadPool(2)- Execution time: " + (end - start));
    }

//    @Disabled
    @Test
    @DisplayName("FixedThreadPool(4)")
    void testMultipleTasks4() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("FixedThreadPool(4)- Execution time: " + (end - start));
    }

//    @Disabled
    @Test
    @DisplayName("FixedThreadPool(8)")
    void testMultipleTasks5() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = Executors.newFixedThreadPool(8);

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("FixedThreadPool(8)- Execution time: " + (end - start));
    }

//    @Disabled
    @Test
    @DisplayName("FixedThreadPool(12)")
    void testMultipleTasks6() throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = Executors.newFixedThreadPool(12);

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("FixedThreadPool(12)- Execution time: " + (end - start));
    }

//    @Disabled
    @Test
    @DisplayName("FixedThreadPool(16)")
    void testMultipleTasks7() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = Executors.newFixedThreadPool(16);

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("FixedThreadPool(16)- Execution time: " + (end - start));
    }

//    @Disabled
    @Test
    @DisplayName("FixedThreadPool(20)")
    void testMultipleTasks8() throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("FixedThreadPool(20)- Execution time: " + (end - start));
    }

    @Test
    @DisplayName("FixedThreadPool(24)")
    void testMultipleTasks9() throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = Executors.newFixedThreadPool(24);

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("FixedThreadPool(24)- Execution time: " + (end - start));

    }

    @Test
    @DisplayName("FixedThreadPool(28)")
    void testMultipleTasks10() throws InterruptedException {


        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService executor = Executors.newFixedThreadPool(21);

        for (int i = 0; i < poolSize; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                } catch (InterruptedException ignored) {
                }
                for (int it = 0; it < iterations; it++) {
                    reportService.getReport();
                }
            });
        }

        long start = System.currentTimeMillis();
        latch.countDown();
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("FixedThreadPool(24)- Execution time: " + (end - start));

    }

}
