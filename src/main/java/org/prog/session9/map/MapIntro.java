package org.prog.session9.map;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {

    public static void main(String[] args) {
//        UserData userData = new UserData();
//        userData.email = "askjdhajsgdjhgas@ajsdgjgasdjhgasd";
//
//        Map<String, UserData> userDataMap = new HashMap<>();
//        userDataMap.put("broken_email_user", userData);

        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map2.put("key3", "value4");
        map2.put("key4", "value4");
        map2.put("key5", "value5");

        map.putAll(map2);
//        map.remove("key1");
//        map.replace("key5", "value10", "new_value_5");
//        map.replace("key5", "value5", "new_new_value_5");
//        map.replace("key6", "value6");

//        map.putIfAbsent("key4", "key44");

        System.out.println(map.get("key1"));
        System.out.println(map.get("key2"));
        System.out.println(map.get("key3"));
        System.out.println(map.get("key4"));
        System.out.println(map.getOrDefault("key5", "defaultValue"));
        System.out.println(map.getOrDefault("key6", "defaultValue"));

//        for (String v : map.values()) {
//            System.out.println(v);
//        }
//        for (String k : map.keySet()) {
//            System.out.println(k);
//        }
//        for (Map.Entry<String, String> e : map.entrySet()) {
//            System.out.println(e.getKey() + " : " + e.getValue());
//        }
    }
}
