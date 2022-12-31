package org.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

        System.out.println("=================");
        List<OnlineClass> springClasses2 = new ArrayList<>();
        springClasses2.add(new OnlineClass(1, "spring boot", true));
        springClasses2.add(new OnlineClass(5, "rest api development", false));

        final Optional<OnlineClass> spring1 = springClasses2.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        final boolean present = spring1.isPresent();
        System.out.println(present);

        final OnlineClass onlineClass = spring1.get();
        System.out.println("onlineClass = " + onlineClass.getTitle());

        spring1.ifPresent(oc->System.out.println(oc.getTitle()));

        final OnlineClass onlineClass1 = spring1.orElse(createNewClass());
        System.out.println("onlineClass1 = " + onlineClass1.getTitle());

        System.out.println("=====================");
        final OnlineClass onlineClass2 = spring1.orElseGet(App::createNewClass);
        System.out.println("onlineClass2 = " + onlineClass2.getTitle());

        final OnlineClass onlineClass3 = spring1.orElseThrow(IllegalArgumentException::new);
        System.out.println("onlineClass3 = " + onlineClass3.getTitle());

        final Optional<OnlineClass> onlineClass4 = spring1.filter(OnlineClass::isClosed);
        System.out.println("onlineClass4 = " + onlineClass4.isPresent());

        final Optional<Progress> progress = spring1.flatMap(OnlineClass::getProgress);

        final Optional<Optional<Progress>> progress1 = spring1.map(OnlineClass::getProgress);
        final Optional<Progress> progress2 = progress1.orElseThrow();
    }

    private static OnlineClass createNewClass() {
        System.out.println("create new");
        return new OnlineClass(10, "New class", false);
    }
}
