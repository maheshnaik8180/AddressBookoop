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

                default:
                    flag = true;
            }
        }
        addressBookListMap.put(addName, addressBook);
    }

    //Search person by state
    private void searchPersonByState(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByState(stateName);
        }
    }

    //Search person by city
    private void searchPersonByCity(String cityName) {
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

    //Count person by state name
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
                    System.out.println("Enter Name of the City: ");
                    String CityName = in.next();
                    addressBookMainobj.searchPersonByCity(CityName);
                    break;

                case 3:
                    System.out.println("Enter Name of the State: ");
                    String StateName = in.next();
                    addressBookMainobj.searchPersonByState(StateName);
                    break;
                case 4:
                    System.out.println("Enter Name of the City: ");
                    String CityName1 = in.next();
                    addressBookMainobj.searchPersonByCity(CityName1);
                    break;
                case 5:
                    System.out.println("Enter Name of the State: ");
                    String StateName1 = in.next();
                    addressBookMainobj.searchPersonByState(StateName1);
                    break;
                case 6:
                    System.out.println("Enter Name of the City: ");
                    String cityName2 = in.next();
                    addressBookMainobj.CountByCity(cityName2);
                    break;

                case 7:
                    System.out.println("Enter Name of the City: ");
                    String StateName2 = in.next();
                    addressBookMainobj.CountByCity(StateName2);
                    break;

                case 8:
                    flag = false;
                    break;
            }

                }
            }
        }


