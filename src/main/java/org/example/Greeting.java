package org.example;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hi " +name;
    }

    public static String hi(String h) {
        return "hi " + h;
    }

    public String getName() {
        return name;
    }
}
