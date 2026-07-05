package org.prog.session10.session9homework;

import java.util.HashSet;
import java.util.Set;

//TODO: write collection which will represent:
// - Each unique phone may have some unique records in phone book
// - Each record in phone book is an object with name and phone number

public class CollectionsDemo {

    public static Set<Phone> getPhones() {
       Member member1 = new Member("Mary", "1234567890");
       Member member2 = new Member("John", "987654321");

       Phone phone = new Phone();
       phone.members.add(member1);
       phone.members.add(member2);

       Set<Phone> phones = new HashSet<>();
       phones.add(phone);
       return phones;
    }
}
