package org.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
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
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        //final Duration studyDuration = spring_boot.getProgress().getStudyDuration();
    }
}
