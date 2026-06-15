package org.prog.session9.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        set.add("b");

        for(String s: set){
            System.out.println(s);
        }

        System.out.println(set.size());
    }
}
