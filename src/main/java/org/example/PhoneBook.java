package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {

    public static HashMap<String, HashSet<String>> contacts = new HashMap<>();

    public static void addContact(String contactName, String contactNumber) {
        if (contacts.containsKey(contactName)){
            HashSet phoneNumbers = contacts.get(contactName);
            phoneNumbers.add(contactNumber);
            contacts.put(contactName, phoneNumbers);
        }else{
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(contactNumber);
            contacts.put(contactName, phoneNumbers);
        }
    }

    public static void PrintPhoneBook () {
        ArrayList<HashSet<String>> printContacts = new ArrayList<HashSet<String>>();
        ArrayList<HashSet<String>> resultContacts = new ArrayList<HashSet<String>>();
        Integer sizeBook = contacts.size();
        for (Map.Entry<String, HashSet<String>> el : contacts.entrySet()) {
            printContacts.add(el.getValue());
        }

        while (resultContacts.size()<sizeBook){
            Integer maxInd = 0;
            Integer maxSize = 0;
            for (int i = 0; i < printContacts.size(); i++) {
                if (printContacts.get(i).size()>= maxSize) {
                    maxSize = printContacts.get(i).size();
                    maxInd = i;
                }
            }
            resultContacts.add(printContacts.get(maxInd));
            printContacts.remove(printContacts.get(maxInd));
        }

        for (HashSet<String> el : resultContacts) {
            String name = null;
            for (Map.Entry<String, HashSet<String>> cont : contacts.entrySet()) {

                if (cont.getValue().equals(el)){
                    name = cont.getKey();
                }
            }
            System.out.println(name+" : "+ el);
        }
    }




    public static void main(String[] args) {
        addContact("Nastya", "+375458788");
        addContact("Nastya", "+375458548");
        addContact("Nastya", "+375458548");
        addContact("Andrew", "+375489757");
        addContact("Andrew", "+375465941");
        addContact("Sergei", "+375476478");
        addContact("Sergei", "+375654786");
        addContact("Sergei", "+375654759");
        addContact("Sergei", "+375654759");

        PrintPhoneBook();
    }

}
