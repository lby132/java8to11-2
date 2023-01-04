package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

public class CallableEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> study = () -> {
            Thread.sleep(1000L);
            return "Study";
        };

        //invokeAll을 쓰면 hello, java, study 전체가 다 끝날때까지 기다리고 한번에 실행된다.
        //final List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, study));
//        for (Future<String> f : futures) {
//            System.out.println(f.get());
//        }
        //invokeAny는 hello, java, study 전체가 끝날때까지 기다리지 않고 하나라도 끝난게 있으면 그것만 반환한다. java stream에 findAny()같은??
        final String s = executorService.invokeAny(Arrays.asList(hello, java, study));
        System.out.println("s = " + s);

        executorService.shutdown();
    }
}
