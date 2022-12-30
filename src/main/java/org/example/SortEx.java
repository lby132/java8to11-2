package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class SortEx {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println(Arrays.toString(strArr));
        final Descending descending = new Descending();
        System.out.println("o221 = " + descending.compare("a","b"));
    }

    static class Descending implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                System.out.println("c2 = " + c2);
                return c1.compareTo(c2) * -1; //-1을 곱해서 기본 정렬방식을 역으로변경
                                              //아니면 c2.compareTo(c1)으로 순서를 변경해도됨
            }

            return -1;
        }
    }
}
