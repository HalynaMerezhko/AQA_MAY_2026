package org.prog.session9;

import java.util.*;

//TODO: write collection which will represent:
// - Each unique phone may have some unique records in phone book
// - Each record in phone book is an object with name and phone number


public class CollectionsDemo {

    public static void main(String[] args) {
        String userName = "Olaf Svensson";
        Set<String> ownedCars = new HashSet<>();
        ownedCars.add("Ford T");
        ownedCars.add("Pontiac Firebird");
        Map<String, Set<String>> carOwners = new HashMap<>();
        carOwners.put(userName, ownedCars);

        Map<String, List<String>> map =  new HashMap<>();
        map.put("company_5", new ArrayList<>());
        map.get("company_5").add("userName");

        Map<List<String>, String> map2 =  new HashMap<>();
    }
}
