package org.example;

import java.util.Arrays;

@Chicken("양념")
@Chicken("마늘간장")
public class App2 {
    public static void main(String[] args) {
        final Chicken[] chickens = App2.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });

        System.out.println("=====================");

        final ChickenContainer chickenContainer = App2.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }

//    static class FeelsLikeChicken<@Chicken T> {
//
//        public static <C> void print(C c) {
//
//        }
//
//    }

}
