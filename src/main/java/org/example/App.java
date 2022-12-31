package org.example;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String[] args ) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        springClasses.stream()
                .filter(i -> i.getTitle().startsWith("spring"))
                .forEach(i -> System.out.println(i.getTitle()));

        System.out.println("=========");
        springClasses.stream()
                .filter(i -> i.isClosed() == false)
                .forEach(i -> System.out.println(i.getId()));

        System.out.println("=========");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> javaEvent = new ArrayList<>();
        javaEvent.add(springClasses);
        javaEvent.add(javaClasses);

        System.out.println("=============");
        javaEvent.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("=============");

        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("=============");
        final boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test = " + test);

        System.out.println("=================");
        final List<String> spring = springClasses.stream()
                .filter(i -> i.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(toList());
        spring.forEach(System.out::println);

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        //final Duration studyDuration = spring_boot.getProgress().getStudyDuration();

        System.out.println("=================");
        List<OnlineClass> springClasses2 = new ArrayList<>();
        springClasses2.add(new OnlineClass(1, "spring boot", true));
        springClasses2.add(new OnlineClass(5, "rest api development", false));

        final Optional<OnlineClass> spring1 = springClasses2.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        final boolean present = spring1.isPresent();
        System.out.println(present);

        //final OnlineClass onlineClass = spring1.get();
        //System.out.println("onlineClass = " + onlineClass.getTitle());

        spring1.ifPresent(oc->System.out.println(oc.getTitle()));

        final OnlineClass onlineClass1 = spring1.orElse(createNewClass());
        System.out.println("onlineClass1 = " + onlineClass1.getTitle());

        System.out.println("=====================");
        final OnlineClass onlineClass2 = spring1.orElseGet(App::createNewClass);
        System.out.println("onlineClass2 = " + onlineClass2.getTitle());

       // final OnlineClass onlineClass3 = spring1.orElseThrow(IllegalArgumentException::new);
        //System.out.println("onlineClass3 = " + onlineClass3.getTitle());

        final Optional<OnlineClass> onlineClass4 = spring1.filter(OnlineClass::isClosed);
        System.out.println("onlineClass4 = " + onlineClass4.isPresent());

        final Optional<Progress> progress = spring1.flatMap(OnlineClass::getProgress);

        //final Optional<Optional<Progress>> progress1 = spring1.map(OnlineClass::getProgress);
        //final Optional<Progress> progress2 = progress1.orElseThrow();

        final List<String> stringList = Arrays.asList("mo", "th", "tt", "al");
        final List<String> m = stringList.stream()
                .filter(s -> s.startsWith("m"))
                .map(String::toString)
                .collect(toList());
        m.forEach(System.out::println);

        List<String> words = Arrays.asList("Hello", "World");

        final List<String> collect = words.stream()
                .map(i -> i.split(""))
                .flatMap(Arrays::stream)
                .collect(toList());
        collect.forEach(System.out::println);

        //숫자 리스트가 주어졌을때 각 숫자의 제곱근으로 이루어진 리스트를 반환하시오
        //12345가 주어지면 1,4,9,16,25
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> collect1 = integers.stream().map(i -> i * i).collect(toList());
        System.out.println(collect1);

        //두 개의 숫자 리스트가 있을때 모든 숫자 쌍의 리스트를 반환하시오. 예를 들어 두개의 리스트 [1,2,3]과[2,3]가 주어지면
        //[(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)]
        final List<Integer> integers1 = Arrays.asList(1, 2, 3);
        final List<Integer> integers2 = Arrays.asList(3, 4);

        final List<int[]> collect2 = integers1.stream().flatMap(j -> integers2.stream().map(i -> new int[]{j, i}))
                .collect(toList());

        collect2.forEach(p -> System.out.printf("(%d, %d)", p[0], p[1]));
        System.out.println();

        System.out.println("================");

        //이전 예제에서 합이 3으로 나누어 떨어지는 쌍만 반환해라. 예를들어 (1, 3)(2, 3)(3, 3)(3, 4)
        final List<int[]> collect3 = integers1.stream().flatMap(i ->
                        integers2.stream().filter(j -> (i * j) % 3 == 0)
                                .map(mi -> new int[]{i, mi})
                )
                .collect(toList());

        collect3.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));

    }

    private static OnlineClass createNewClass() {
        System.out.println("create new");
        return new OnlineClass(10, "New class", false);
    }
}
