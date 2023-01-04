package org.example;

import java.util.concurrent.*;

public class ThreadEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
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

//        final ScheduledExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
//        executorService1.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);

        final ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        final Future<String> submit = executorService.submit(hello);
        System.out.println(submit.isDone()); //isDone을 통해 끝났는지 체크 실행이 끝나지 않았으면 false
        System.out.println("Started");

        //submit.get();   //hello에서 걸어준 sleep2초동안 기다린다.
        submit.cancel(false); //파라미터값 false는 실행중인 작업을 기다리고 true는 기다리지 않고 종료

        System.out.println(submit.isDone());
        System.out.println("End");
        executorService.shutdown();

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
