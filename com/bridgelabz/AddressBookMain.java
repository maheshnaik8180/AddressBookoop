package com.bridgelabz;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {


    private AddressBook addressBook = new AddressBook();
    public static Map<String,AddressBook> addressBookListMap = new HashMap<>();

    public void addContactInAddressBook(String addName) {

        boolean flag = true;

        while(flag) {
            Scanner in =new Scanner(System.in);

            System.out.println("Enter your choice : ");
            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete");
            System.out.println("4.Display");
            int choice = in.nextInt();

            switch (choice)
            {
                case 1:
                    addressBook.addPersonDetails();
                    break;

                case 2:
                    System.out.println("Enter the Person First Name to edit details: ");
                    String personName = in.next();
                    boolean listNameEdit = addressBook.editPersonDetails(personName);
                    if (listNameEdit) {
                        System.out.println("List Edited Successfully");
                    }
                    else {
                        System.out.println("List Cannot be Edited");
                    }
                    break;

                case 3:
                    System.out.println("Enter the Person First Name to delete details: ");
                    String personName1 = in.next();
                    boolean listNameDelete = addressBook.deletePersonDetails(personName1);
                    if (listNameDelete) {
                        System.out.println("List Deleted Successfully");
                    }
                    else {
                        System.out.println("List Cannot be Deleted");
                    }
                    break;

                case 4:
                    flag = false;
                    break;


            }
        }
        addressBookListMap.put(addName, addressBook);
    }

    //Search person by state
     void searchPersonByState(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }

    //Search person by city
    void searchPersonByCity(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }


    //View person by state using Hash map
    private void viewPersonByStateUsingHashmap(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<DisplayOption> contacts = value.personByState.entrySet().stream()
                    .filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for (DisplayOption contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }


    //View person by city using Hashmap
    private void viewPersonByCityUsingHashMap(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<DisplayOption> contacts = value.personByCity.entrySet().stream()
                    .filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst()
                    .orElse(null);
            for (DisplayOption contact : contacts) {
                System.out.println("First Name: " + contact.getFirstName() + " Last Name: " + contact.getLastName());
            }
        }
    }


    //Count person by state name
    public void CountByState(String state) {
        int count = 0;
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            for (int i = 0; i < (entry.getValue()).contactList.size(); i++) {
                DisplayOption contact = entry.getValue().contactList.get(i);

                if (state.equals(contact.getState())) {
                    count++;
                }

            }
        }
        System.out.println("Total Person Count in state " + state + ": " + count);
    }

    //Count person by City name
    public void CountByCity(String city) {
        int countPersonInCity = 0;
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            for (int i = 0; i < (entry.getValue()).contactList.size(); i++) {
                DisplayOption d = entry.getValue().contactList.get(i);

                if (city.equals(d.getCity())) {
                    countPersonInCity++;
                }

            }
        }
        System.out.println("Total number of people in this city " + city + ": " + countPersonInCity);
    }

    //sort contact by name
    void sortContactByName() {
        for (Map.Entry<String,AddressBook>entry:addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            List<DisplayOption> sortedList = value.contactList.stream()
                    .sorted(Comparator.comparing(DisplayOption::getFirstName)).collect(Collectors.toList());
            for(DisplayOption contact:sortedList){
                System.out.println("First Name: "+contact.getFirstName());
                System.out.println("Last Name: "+contact.getLastName());

            }
        }
    }


    //sorting contact by state
    void sortContactByState() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<DisplayOption> sortedList = value.contactList.stream()
                    .sorted(Comparator.comparing(DisplayOption::getState)).collect(Collectors.toList());

            for (DisplayOption contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
            }
        }
    }

    //sorting contact by city
    public void sortContactByCity() {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            List<DisplayOption> sortedList = value.contactList.stream()
                    .sorted(Comparator.comparing(DisplayOption::getCity)).collect(Collectors.toList());

            for (DisplayOption contact : sortedList) {
                System.out.println("First Name: " + contact.getFirstName());
                System.out.println("Last Name: " + contact.getLastName());
            }
        }
    }
}
