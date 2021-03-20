package com.bridgelabz;
import java.util.*;

public class AddressBookMain {

    public static Scanner in = new Scanner(System.in);
    private AddressBook addressBook = new AddressBook();
    public static Map<String,AddressBook> addressBookListMap = new HashMap<>();

    public void addContactInAddressBook(String addName) {
        AddressBookMain addBookMain = new AddressBookMain();
        boolean flag = true;

        while(flag) {
            System.out.println("Enter your choice \n 1: For Adding person \n 2:For Editing person's details \n 3:For Deleting person's details \n 4:Display");
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

    private void searchPersonByState(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }

    private void searchPersonByCity(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByCity(cityName);
        }
    }

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



    public static void main(String[] args) {

        AddressBookMain addressBookMainobj = new AddressBookMain();
        boolean flag = true;
        while(flag)
        {
            System.out.println("Enter your choice \n 1: Add new AddressBook \n 2:Search contact from a city \n 3:Search contact from a state \n 4:View contact By State Using City and Person HashMap \n 5:View contact By State Using State and Person HashMap \n 6:Display ");
            int choice = in.nextInt();
            switch (choice){
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = in.next();
                    if(addressBookListMap.containsKey(addressBookName)){
                        System.out.println("The Address book Already Exists");
                        break;
                    }
                    else
                    {
                        addressBookMainobj.addContactInAddressBook(addressBookName);
                        break;
                    }
                }
                case 2:
                    System.out.println("Enter Name of City: ");
                    String CityName = in.next();
                    addressBookMainobj.searchPersonByCity(CityName);
                    break;

                case 3:
                    System.out.println("Enter Name of State: ");
                    String StateName = in.next();
                    addressBookMainobj.searchPersonByState(StateName);
                    break;
                case 4:
                    System.out.println("Enter Name of City: ");
                    String CityName1 = in.next();
                    addressBookMainobj.searchPersonByCity(CityName1);
                    break;
                case 5:
                    System.out.println("Enter Name of State: ");
                    String StateName1 = in.next();
                    addressBookMainobj.searchPersonByState(StateName1);
                    break;
                case 6:
                    flag = false;
                    break;
            }

                }
            }
        }


