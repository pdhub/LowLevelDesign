package solution3;

import java.nio.charset.Charset;
import java.util.*;

public class BadEmails {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("s�meemail@gmail.com",
                "someemail@gmail.com",
                "somee�ail@gmail.com",
                "s�meemail@gmail.com",
                "some�mail@gmail.com",
                "someOtheremail@gmail.com");

        Map<String, List<String>> map = convertUniqueEmails(list);
        System.out.println(map);
    }

    private static Map<String, List<String>> convertUniqueEmails(List<String> list) {
        Map<String, List<String>> emailToList = new HashMap<>();
        for (String email : list) {
            if (isPureAscii(email))
                emailToList.put(email, new ArrayList());

        }
        Set<String> goodEmails = (Set<String>) emailToList.keySet();
        for (String email : list) {
            if (!isPureAscii((email))) {
                for (int i = 0; i < email.length(); i++) {
                    if (email.charAt(i) > 255) {
                        addmatching(email, i, goodEmails, emailToList);
                    }
                }
            }
        }
        return emailToList;
    }



    private static void addmatching(String email, int pivot, Set<String> goodEmails, Map<String, List<String>> emailToList) {
        for(String goodEmail : goodEmails) {
            if (email.length() == goodEmail.length() && pivot > 0 && pivot < email.length()) {
                String left = email.substring(0, pivot);
                String right = email.substring(pivot+1, email.length());
                if (String.valueOf(left + goodEmail.charAt(pivot) + right).equals(goodEmail)) {
                    List<String> newList = emailToList.get(goodEmail);
                    newList.add(email);
                    emailToList.put(goodEmail, newList);
                }
            }
        }
    }


    public static boolean isPureAscii(String v) {
        return Charset.forName("US-ASCII").newEncoder().canEncode(v);
        // or "ISO-8859-1" for ISO Latin 1
        // or StandardCharsets.US_ASCII with JDK1.7+
    }
}
