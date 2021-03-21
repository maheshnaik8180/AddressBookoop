package com.bridgelabz;

import java.util.*;

public class MenuOption {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        AddressBookMain addressBookMainobj = new AddressBookMain();
        boolean flag = true;
        while(flag)
        {
            System.out.println("--Enter your choice--");
            System.out.println("1.Add New Address Book");
            System.out.println("2.Search Contact from a city");
            System.out.println("3.Search Contact from a State");
            System.out.println("4.View contact By State ");
            System.out.println("5.View Contact by city ");
            System.out.println("6.Count Contact By State");
            System.out.println("7.Count Contact By City");
            System.out.println("8.Sort Contact By Name");
            System.out.println("9.Sort Contact By City");
            System.out.println("10.Sort Contact By State");
            System.out.println("11.Write the data");
            System.out.println("12.Read the data");
            System.out.println("13.Display");



            int choice = in.nextInt();

            switch (choice){
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = in.next();
                    if(AddressBookMain.addressBookListMap.containsKey(addressBookName)){
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
                    System.out.println("Sort Contact by name");
                    addressBookMainobj.sortContactByName();
                    break;

                case 9:
                    System.out.println("Sort Contact by city");
                    addressBookMainobj.sortContactByCity();
                    break;

                case 10:
                    System.out.println("Sort Contact by state");
                    addressBookMainobj.sortContactByState();
                    break;

                case 11:
                    System.out.println("Write the data");
                    AddressBook.writeData(addressBookMainobj);
                    break;

                case 12:
                    System.out.println("Read the data");
                    AddressBook.readData(addressBookMainobj);
                    break;

                case 13:
                    flag = false;
                    break;

            }
        }
    }
}