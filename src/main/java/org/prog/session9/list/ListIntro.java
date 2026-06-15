package org.prog.session9.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListIntro {

    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        List<String> lList = new LinkedList<>();

        aList.add("a");//0
        aList.add("b");//1
        //...
        aList.add("g");//20001
        aList.add("f");//20002
        //...
        aList.add("c");//50001
        aList.add("d");//50002

        lList.add("a");//[start_of_list] - ["a"] - ["b"]
        //... (25000)
        lList.add("b");//["a"]-["b"]-["g"]
        lList.add("g");//["b"]-["g"]-["c"] //2501
        lList.add("c");//["g"]-["c"]-["..."]
        //... (25000)
        lList.add("d");//["..."]-["d"]-["end_of_list"]
    }
}
