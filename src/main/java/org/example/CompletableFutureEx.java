package org.example;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //final CompletableFuture<String> future = new CompletableFuture<>();
        //future.complete("lby");
//
//        final CompletableFuture<String> future = CompletableFuture.completedFuture("lby");
//
//        System.out.println(future.get());
//
//        //리턴값이 없는 future
//        final CompletableFuture<Void> voidFuture = CompletableFuture.runAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//        });
//        voidFuture.get();

//        final CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "Hello";
//        }).thenApply((s) -> {
//            System.out.println("thread: " + Thread.currentThread().getName());
//            return s.toUpperCase();
//        });
//        System.out.println(stringFuture.get());

        final CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        final CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        final CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future.get());

//        final CompletableFuture<Void> future1 = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
//        future1.get();

//        final CompletableFuture<String> future = hello.thenCompose(CompletableFutureEx::getWorld);
//        System.out.println(future.get());

    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
