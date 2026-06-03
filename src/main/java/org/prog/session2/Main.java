package org.prog.session2;

// TODO: replace all _ with . in this email: test_email_for_qa@gmail_com
// TODO: extract and print text between $: thisstringhas$some fragment$thathastobeextracted

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String s = "test_email_for_qa@gmail_com";
        String result = s.replace("_", ".");
        System.out.println(result);

        String s2 = "thisstringhas$some fragment$thathastobeextracted";
        int startIndex = s2.indexOf("$");
        int endIndex = s2.lastIndexOf("$");
        String result2 = s2.substring(startIndex + 1, endIndex);
        System.out.println(result2);
    }
}
