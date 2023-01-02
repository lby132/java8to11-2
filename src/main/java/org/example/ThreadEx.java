package org.example;

import java.util.concurrent.*;

public class ThreadEx {
    public static void main(String[] args) throws InterruptedException {
        /*Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit");
                    return;
                }
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        thread.join();
        System.out.println(thread + "is finished");*/

        //스레드를 만들고 관리하는걸 고수준의 API에게 위임한다. (ExecutorService)
        //final ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        final ExecutorService executorService = Executors.newFixedThreadPool(2); //두개의 스레드로 번갈아가면서 실행
//        executorService.submit(getRunnable("Hello"));
//        executorService.submit(getRunnable("java"));
//        executorService.submit(getRunnable("world"));
//        executorService.submit(getRunnable("Thread"));

        //executorService.shutdown(); //현재 진행중인 작업을 다 끝내고 셧다운함.
        //executorService.shutdownNow(); // 현재 진행중인 작업이 종료되지 않아도 셧다운 시킬 수 있음.

        final ScheduledExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
        executorService1.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
