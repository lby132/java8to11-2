package org.example;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {

        Function<Integer, String> dd = (i) -> i + "10";
        System.out.println(dd.apply(3));

        Plus10 xx = new Plus10();
        System.out.println(xx.apply(1));

        System.out.println("===================================");

        Function<Integer, Integer> plus = (i) -> i + 10;
        Function<Integer, Integer> multiply = (i) -> i * 2;

        // compose는 뒤에오는 함수를 적용한 결과값을 plus의 i값에 담는다.
        System.out.println("compose = " + plus.compose(multiply).apply(2));

        // andThen은 compose의 반대이다. plus에 일단 12가 적용될것이고 그 값을 multiply의 i값에 적용된다.
        System.out.println("andThen = " + plus.andThen(multiply).apply(2));

        // T타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
        Consumer<Integer> printT = System.out::println;
        printT.accept(10);

        // T타입의 값을 제공하는 함수 인터페이스. (이 함수의 경우 무조건 10을 리턴하는 함수)
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // T타입을 받아서 boolean을 리턴하는 함수 인터페이스

        Predicate<String> startsWith = (s) -> s.startsWith("lby dddd");
        Predicate<String> startsWith2 = (s) -> s.startsWith("dddd");
        System.out.println("or = " + startsWith.or(startsWith2).test("dddd"));
        Predicate<Integer> isEven = (i) -> i%2 == 0;
        System.out.println("isEven = " + isEven.test(2));

        //UnaryOperator는 Function<T,R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
        //입력값의 타입과 결과값의 타입이 같을경우 예를들어 Function<Integer,Integer>이면 UnaryOperator<Integer>를 쓸 수 있다.
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 10;
        System.out.println(plus10.andThen(multiply2).apply(2));

        //BinaryOperator<T>는 BiFunction<T,U,R>의 (U는 두번째 입력값) 특수한 형태로, 동일한 입력값 두개를 받아 리턴하는 함수 인터페이스
        //UnaryOperator와 비슷하게 세개의 타입이 같은 BinaryOperator<Intger>이런식으로 사용가능. BiFunction<T,T,T>
        BinaryOperator<Integer> plus20 = (i1, i2) -> i1 + i2;
        System.out.println("plus20 = " + plus20.apply(2,3));

    }
}
