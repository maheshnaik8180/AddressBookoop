package com.bridgelabz;
import java.util.*;

public class AddressBookMain {
    public static Scanner in = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String,AddressBook> addressBookListMap = new HashMap<>();

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

    public static void main(String[] args) {

        AddressBookMain addressBookMainobj = new AddressBookMain();
        boolean flag = true;
        while(flag)
        {
            while(flag)
            {
                System.out.println("Enter your choice \n 1: Add new AddressBook \n 2:Display");
                int choice = in.nextInt();
                switch (choice){
                    case 1: {
                        System.out.println("Enter the Name of Address Book: ");
                        String addressBookName = in.next();
                        if(addressBookMainobj.addressBookListMap.containsKey(addressBookName)){
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

                    case 3: {
                        System.out.println("Enter Name of State: ");
                        String StateName = in.next();
                        addressBookMainobj.searchPersonByState(StateName);
                        break;
                    }
                    case 4:
                        flag = false;
                        break;

                }
            }
        }
    }
}
