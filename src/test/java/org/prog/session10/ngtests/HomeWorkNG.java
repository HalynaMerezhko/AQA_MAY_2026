package org.prog.session10.ngtests;

//TODO: using TestNG - move previous homework to test
//TODO: Add assertion that phone book is not empty
//TODO: Add assertion that phone book records all have name and number

import org.prog.session10.session9homework.CollectionsDemo;
import org.prog.session10.session9homework.Member;
import org.prog.session10.session9homework.Phone;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class HomeWorkNG {
    @Test
    public void when_getPhones_should_be_not_empty_phone_book(){
        Set<Phone> phones = CollectionsDemo.getPhones();
        for (Phone phone : phones) {
            Assert.assertFalse(phone.members.isEmpty());
        }
    }

    @Test
    public void when_getPhones_should_be_all_members_have_name_and_number(){
        Set<Phone> phones = CollectionsDemo.getPhones();
        for (Phone phone : phones) {
            for(Member member: phone.members){
                Assert.assertFalse(member.name.isEmpty());
                Assert.assertFalse(member.phoneNumber.isEmpty());
            }
        }
    }
}
