package org.prog.session3;

//TODO: print only valid emails
//TODO: valid email has:
//TODO: - at least 3 symbols before @
//TODO: - at least 7 symbols in domain (after @) (cannot start or end with dot)
//TODO: - 1 dot in domain
//TODO: - only one @

public class HomeWork {

    public static void main(String[] args) {
        String[] emails = {
                "asd.asd@asd.asd", //+
                "aa@asd.asd",
                "...@asd.asd", //+
                "asd.asd@asdasd.",
                "asd.asd@.asdasd",
                "asd@@.asdasd",
                "asd@@asd.asd",
                "some_email_that_is_very_long@long_domain_name.com" //+
        };


        for (int i = 0; i < emails.length; i++) {
                int firstAtIndex = emails[i].indexOf('@');
                if (firstAtIndex >= 3) {
                    int lastAtIndex = emails[i].lastIndexOf('@');
                    if (firstAtIndex == lastAtIndex) {
                        String domain = emails[i].substring(firstAtIndex + 1);
                        int firstDotDomainIndex = domain.indexOf('.');
                        int lastDotDomainIndex = domain.lastIndexOf('.');
                        if (domain.length() >= 7
                                && firstDotDomainIndex != -1
                                && firstDotDomainIndex != 0
                                && lastDotDomainIndex != domain.length() - 1
                                && firstDotDomainIndex == lastDotDomainIndex)
                                {
                            System.out.println(emails[i]);
                        }
                    }
                }
            }
        }
    }
