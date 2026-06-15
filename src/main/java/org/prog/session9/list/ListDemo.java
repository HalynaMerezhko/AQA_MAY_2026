package org.prog.session9.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list.add(null);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        list2.add("p");
        list2.add("d");
        list2.add("f");

//        list.retainAll(list2);
//        System.out.println(list.contains("k"));
//        list.removeAll(list2);
        list.addAll(list2);
//        list.remove("a");
//        list.set(2, "j");
//        list.sort(Comparator.naturalOrder());


//        list.add(2, "e");

        for (String s : list) {
            System.out.println(s);
        }

//        for (int i = 0; i < list.reversed().size(); i++) {
//            System.out.println(list.reversed().get(i));
//        }

//        System.out.println("=========================");
//        List<String> sublist = list.subList(1, 4);

    }
}
